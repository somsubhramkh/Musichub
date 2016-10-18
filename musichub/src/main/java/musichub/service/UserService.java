package musichub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import musichub.dao.ProductDAO;
import musichub.dao.UserDAO;

import musichub.model.Product;
import musichub.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;

	public void setUserDAO(UserDAO u) {
		this.userDAO = u;
	}

	@Transactional
	public void addUser(User u) {
		userDAO.addUser(u);
	}

	@Transactional
	public void updateUser(User u) {
		userDAO.updateUser(u);
	}

	@Transactional
	public List<User> listUsers() {
		return userDAO.listUsers();
	}

	@Transactional
	public User getUserById(int id) {
		return userDAO.getUserById(id);
	}

	@Transactional
	public void removeUser(int id) {
		this.userDAO.removeUser(id);
	}

	public musichub.model.User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userDAO.getUserByUsername(username);
	}
	
	

}
