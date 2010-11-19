package tests.dao.impl;

import model.User;

import org.junit.BeforeClass;
import org.junit.Test;

import dao.impl.InMemoryUserDao;
import junit.framework.TestCase;

public class InMemoryUserDaoTest extends TestCase {
	private static final long NON_EXISTING_USER = 32408923;
	private static final String USER_NAME_A = "John Doe";
	private static final String USER_NAME_B = "Mary Doe";
	private InMemoryUserDao userDao;
	private User userA, userB;

	@BeforeClass
	public void setUp() {
		userDao = new InMemoryUserDao();
		userA = new User(USER_NAME_A);
		userB = new User(USER_NAME_B);
	}

	@Test
	public void testShouldReturnNullForUnknownUser() {
		assertNull(userDao.getUser(NON_EXISTING_USER));
	}

	@Test
	public void testShouldReturnUserAfterUserIsSaved() {
		final long userId = userDao.storeUser(userA);
		assertEquals(userA, userDao.getUser(userId));
	}
	
	@Test
	public void testShouldReturnMoreUsers() {
		final long userIdA = userDao.storeUser(userA);
		final long userIdB = userDao.storeUser(userB);
		assertEquals(userA, userDao.getUser(userIdA));
		assertEquals(userB, userDao.getUser(userIdB));
		assertEquals(userA, userDao.getUser(userIdA));
		assertEquals(userB, userDao.getUser(userIdB));
	}
}
