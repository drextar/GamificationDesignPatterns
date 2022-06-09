package main;

import java.util.List;

abstract public class Achievement {
	public String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public abstract boolean checkIfCanBeAdd(List<Achievement> achiviements);
}
