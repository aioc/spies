package com.ausinformatics.spies;

import java.util.List;
import java.util.Random;

import com.ausinformatics.phais.core.interfaces.GameBuilder;
import com.ausinformatics.phais.core.interfaces.GameInstance;
import com.ausinformatics.phais.core.interfaces.PersistentPlayer;
import com.ausinformatics.phais.core.server.DisconnectedException;

public class GameFactory implements GameBuilder {

	private int boardSize = 8;
	private int startingHealth = 5;

	public GameInstance createGameInstance(List<PersistentPlayer> players) {
		int randKey = new Random().nextInt();
		for (int i = 0; i < players.size(); i++) {
			int swap = i + (new Random().nextInt(players.size() - i));
			PersistentPlayer p = players.get(i);
			players.set(i, players.get(swap));
			players.set(swap, p);
		}
		for (int i = 0; i < players.size(); i++) {
			PersistentPlayer p = players.get(i);
			String toSend = "NEWGAME " + players.size() + " " + boardSize + " " + startingHealth + " " + i + " " + randKey;
			p.getConnection().sendInfo(toSend);

			try {
				String inputString = p.getConnection().getStrInput();
				String[] tokens = inputString.split("\\s");
				if (tokens.length != 2) {
					p.getConnection().disconnect();
					continue;
				} else if (!tokens[0].equals("READY")) {
					p.getConnection().disconnect();
					continue;
				}

				try {
					if (Integer.parseInt(tokens[1]) != randKey) {
						p.getConnection().disconnect();
					} // Else success!
				} catch (NumberFormatException nfe) {
					p.getConnection().disconnect();
				}
			} catch (DisconnectedException de) {
				p.getConnection().disconnect();
			}
		}
		return new GameRunner(players, boardSize, startingHealth);
	}
}
