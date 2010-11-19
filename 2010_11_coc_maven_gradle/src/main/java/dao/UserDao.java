package dao;

import model.User;

/**
 * Defines basic operations on stored users.
 * 
 * @author tomek
 * 
 */
public interface UserDao {

	Long storeUser(User user);

	User getUser(Long userId);
}
