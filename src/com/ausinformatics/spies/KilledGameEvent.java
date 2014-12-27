package com.ausinformatics.spies;

import java.util.List;

import com.ausinformatics.phais.core.interfaces.PersistentPlayer;

public class KilledGameEvent implements GameEvent {
	
	private int killer;
	private int killed;
	
	public KilledGameEvent(int killer, int killed) {
		this.killer = killer;
		this.killed = killed;
	}

	public String getRepresentation(List<PersistentPlayer> players) {
		return players.get(killer).getName() + " killed " + players.get(killed).getName();
	}

}
