package main;

import java.util.List;

public class Badge extends Achievement {

	@Override
	public boolean checkIfCanBeAdd(List<Achievement> achiviements) {
		for (Achievement a : achiviements) {
			if (a instanceof Badge && a.getName().equals(this.getName())) {				
				return false;
			}
		}

		return true;				
	}

}
