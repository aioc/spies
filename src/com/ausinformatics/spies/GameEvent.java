package com.ausinformatics.spies;

import java.util.List;

import com.ausinformatics.phais.core.interfaces.PersistentPlayer;

public interface GameEvent {
	
	public String getRepresentation(List<PersistentPlayer> players);
}
