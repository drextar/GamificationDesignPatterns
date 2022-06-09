package storage;

public class AchievementStorageFactory {
	static AchievementStorage storage;
	
	public static AchievementStorage getAchievementStorage() {
		if (storage == null) {
			storage = new MemoryAchievementStorage();
		}
		
		return storage;
	}
	
	void setAchievementStorage(AchievementStorage a) {
		if (storage == null) {
			storage = a;
		}
	}
}
