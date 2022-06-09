package storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import main.Achievement;
import main.NullAchievement;

public class MemoryAchievementStorage implements AchievementStorage {

	HashMap<String, List<Achievement>> achiviements;
	
	public MemoryAchievementStorage () {
		this.achiviements = new HashMap<String, List<Achievement>>();
	}
	
	@Override
	public void addAchievement(String user, Achievement a) {
		List<Achievement> list = this.getAchievements(user);
		
		if (a.checkIfCanBeAdd(list)) {
			list.add(a);
		}
		
		this.achiviements.put(user, list);
	}

	@Override
	public List<Achievement> getAchievements(String user) {
		return this.achiviements.getOrDefault(user, new ArrayList<Achievement>());
	}

	@Override
	public Achievement getAchievement(String user, String achievementName) {
		List<Achievement> list = this.getAchievements(user);
		for (Achievement a: list) {
			if (a.getName().equals(achievementName)) {
				return a;
			}
		}
		
		return new NullAchievement();
	}

}
