package edu.mum.dao;

import edu.mum.domain.User;

public interface UserDao extends GenericDao<User> {
      
	public User findByUserNumber(Integer number);
	/*public List<User> findAllJoinFetch();
	public List<User> findByGraph();*/
	}
