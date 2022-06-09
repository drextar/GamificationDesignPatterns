package main;

import java.util.List;

public class NullAchievement extends Achievement {

	@Override
	public
	boolean checkIfCanBeAdd(List<Achievement> achiviements) {		
		return false;
	}

}
