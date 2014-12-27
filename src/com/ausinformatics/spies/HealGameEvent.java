package com.ausinformatics.spies;

import java.util.List;

import com.ausinformatics.phais.core.interfaces.PersistentPlayer;

public class HealGameEvent implements GameEvent {

	private int healer;

	public HealGameEvent(int healer) {
		this.healer = healer;
	}

	public String getRepresentation(List<PersistentPlayer> players) {
		return players.get(healer).getName() + " healed!";
	}

}
