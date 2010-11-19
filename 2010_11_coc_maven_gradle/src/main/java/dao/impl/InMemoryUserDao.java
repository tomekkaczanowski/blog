package dao.impl;

import java.util.HashMap;
import java.util.Map;

import dao.UserDao;
import model.User;
import org.apache.commons.lang.text.StrBuilder;

/**
 * A very unreliable and not persistent implementation of {@link UserDao}
 * interface.
 * 
 * @author tomek
 * 
 */
public class InMemoryUserDao implements UserDao {

	private static long ID = 0;
	public Map<Long, User> user;

	public InMemoryUserDao() {
		super();
		user = new HashMap<Long, User>();
	}

	public Long storeUser(User user) {
		this.user.put(ID, user);
		return ID++;
	}

	public User getUser(Long userId) {
		return user.get(userId);
	}
}
