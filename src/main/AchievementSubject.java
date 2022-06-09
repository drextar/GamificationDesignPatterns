package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import storage.AchievementStorage;

public class AchievementSubject{
	
	HashMap<String, List<AchievementObserver>> observers;
		
	public AchievementSubject(AchievementStorage storage) {		
		observers = new HashMap<String, List<AchievementObserver>>();
	}
	
	public void attach(String user, AchievementObserver ob) { 
		List<AchievementObserver> list = this.getListObservers(user);
		
		if (!list.stream().filter(o -> o.getClass().equals(ob.getClass())).findFirst().isPresent()) {
			list.add(ob);
		}			
	}
	
	public void dettach(String user, AchievementObserver ob) {
		List<AchievementObserver> list = this.getListObservers(user);
		
		if (list.stream().filter(o -> o.getClass().equals(ob.getClass())).findFirst().isPresent()) {
			AchievementObserver observer = (AchievementObserver) list.stream().filter(o -> o.getClass().equals(ob.getClass())).findFirst().get();
			list.remove(observer);			
		}
	}
	
	
	private List<AchievementObserver> getListObservers(String user) {
		return this.observers.getOrDefault(user, new ArrayList<AchievementObserver>());
	}
	
	public void checkUpdates(String user, Achievement achievement) {
		List<AchievementObserver> list = this.getListObservers(user);
		for (AchievementObserver ob : list) {
			ob.achievementUpdate(user, achievement);
		}
	}
	
	
	
}
