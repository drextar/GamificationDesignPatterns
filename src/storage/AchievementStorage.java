package storage;

import java.util.List;

import main.Achievement;

public interface AchievementStorage {
	
	void addAchievement(String user, Achievement a);
	List<Achievement> getAchievements(String user);
	Achievement getAchievement(String user, String achievementName);
}
