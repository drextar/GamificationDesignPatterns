package main;

import storage.AchievementStorage;

public class ForumServiceGamificationProxy implements ForumService {
	private ForumService service;
	private AchievementStorage storage;
	
	public ForumServiceGamificationProxy(ForumService service, AchievementStorage storage) {
		this.service = service;
		this.storage = storage;
	}

	@Override
	public void addTopic(String user, String topic) throws Exception {
		this.service.addTopic(user, topic);
		
		Points p = new Points("CREATION", 5);
		Badge b = new Badge();
		b.setName("I CAN TALK");
		
		this.storage.addAchievement(user, p);
		this.storage.addAchievement(user, b);
	}

	@Override
	public void addComment(String user, String topic, String comment) {
		this.service.addComment(user, topic, comment);
		
		Points p = new Points("PARTICIPATION", 3);
		Badge b = new Badge();
		b.setName("LET ME ADD");
		
		this.storage.addAchievement(user, p);
		this.storage.addAchievement(user, b);

	}

	@Override
	public void likeTopic(String user, String topic, String topicUser) {
		this.service.likeTopic(user, topic, topicUser);
		Points p = new Points("CREATION", 1);
		this.storage.addAchievement(user, p);
	}

	@Override
	public void likeComment(String user, String topic, String comment, String commentUser) {
		this.service.likeComment(user, topic, comment, commentUser);
		Points p = new Points("PARTICIPATION", 1);
		this.storage.addAchievement(user, p);
	}

}
