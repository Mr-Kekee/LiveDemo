package livedDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import livedDemo.dao.UserRedisDao;
import livedDemo.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserRedisDao userRedisDao;
	
	public void save(User user) {
		userRedisDao.put(user.getName(), user, -1);
	}
	
	public boolean checkPass(User user) {
		if(user != null){
			User userCheck;
			if((userCheck = userRedisDao.get(user.getName())) == null)
				return false;
			if(userCheck.getPassword().equals(user.getPassword()))
				return true;
		}
		return false;
	}
}
