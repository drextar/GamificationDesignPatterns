package tests;

import main.ForumService;

public class ForumServiceMockup implements ForumService {
	
	public boolean throwException;
	
	@Override
	public void addTopic(String user, String topic) throws Exception {
		if (this.throwException) {
			throw new Exception("Lancou uma excessao");
		}
		
	}

	@Override
	public void addComment(String user, String topic, String comment) {
		
	}

	@Override
	public void likeTopic(String user, String topic, String topicUser) {
		
	}

	@Override
	public void likeComment(String user, String topic, String comment, String commentUser) {
		
	}

}
