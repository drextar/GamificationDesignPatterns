package main;

import java.util.List;

public class Points extends Achievement {
	public int total;
	
	Points() {
		this.total = 0;
	}
		
	public Points(String name, int points) {
		this.total = points;
		this.setName(name);
	}

	public int getTotal() {
		return total;
	}

	public void addPoint(int point) {
		this.total += point;
	}

	@Override
	public boolean checkIfCanBeAdd(List<Achievement> achiviements) {
		
		for (Achievement a : achiviements) {
			if (a instanceof Points && a.getName().equals(this.getName())) {
				Points p = (Points) a;
				p.addPoint(this.getTotal());
				return false;
			}
		}

		return true;
	}	
}
