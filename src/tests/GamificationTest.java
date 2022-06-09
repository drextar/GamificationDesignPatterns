package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.Achievement;
import main.ForumServiceGamificationProxy;
import main.Points;
import storage.AchievementStorage;
import storage.AchievementStorageFactory;
import storage.MemoryAchievementStorage;

public class GamificationTest {
	
	AchievementStorage storage;
	ForumServiceMockup mockup;
	
	@Before
	public void setUp() {
		storage = new MemoryAchievementStorage();
		mockup = new ForumServiceMockup();
	}

	@Test
	public void testAddTopic() throws Exception {	
		ForumServiceGamificationProxy proxy = new ForumServiceGamificationProxy(mockup, this.storage);
		proxy.addTopic("teste", "teste");		
		
		Points p = (Points) storage.getAchievement("teste", "CREATION");
		
		assertEquals(5, p.getTotal());			
	}
	
	@Test
	public void testCallAddTopicTwice() throws Exception {	
		ForumServiceGamificationProxy proxy = new ForumServiceGamificationProxy(mockup, this.storage);
		proxy.addTopic("teste", "teste");		
		proxy.addTopic("teste", "teste2");
		
		Points p = (Points) storage.getAchievement("teste", "CREATION");
		List<Achievement> list = storage.getAchievements("teste");
		
		assertEquals(10, p.getTotal());
		assertEquals(2, list.size());
	}
	
	@Test
	public void testAddComments() {
		ForumServiceGamificationProxy proxy = new ForumServiceGamificationProxy(mockup, this.storage);
		proxy.addComment("teste", "Hello", "Very nice");
		
		List<Achievement> list = storage.getAchievements("teste");
		
		Points p = (Points) storage.getAchievement("teste", "PARTICIPATION");
		
		assertEquals(2, list.size());
		assertEquals(3, p.getTotal());
		
		proxy.addComment("teste", "Hello", "Very nice");
		
		assertEquals(2, list.size());
		
		p = (Points) storage.getAchievement("teste", "PARTICIPATION");
		assertEquals(6, p.getTotal());
		
	}
	
	@Test
	public void testLikeTopic() throws Exception {
		ForumServiceGamificationProxy proxy = new ForumServiceGamificationProxy(mockup, this.storage);
		proxy.addTopic("teste", "topic");
		proxy.likeTopic("teste", "topic", "topic");
		
		Points p = (Points) storage.getAchievement("teste", "CREATION");
		
		assertEquals(6, p.getTotal());
	}
	
	@Test
	public void testLikeComment() throws Exception {
		ForumServiceGamificationProxy proxy = new ForumServiceGamificationProxy(mockup, this.storage);
		proxy.addTopic("teste", "topic");
		proxy.addComment("teste", "topic", "comment");		
		
		proxy.likeComment("teste", "topic", "comment", "user2");
		
		Points p = (Points) storage.getAchievement("teste", "PARTICIPATION");
		
		assertEquals(4, p.getTotal());
	}
	
	@Test(expected = Exception.class)
	public void testThrowException() throws Exception {
		ForumServiceGamificationProxy proxy = new ForumServiceGamificationProxy(mockup, this.storage);
		mockup.throwException = true;
		
		proxy.addTopic("teste", "topic");		
		Points p = (Points) storage.getAchievement("teste", "CREATION");
		
		assertEquals(0, p.getTotal());
	}

}
