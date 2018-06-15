package livedDemo.dao;

import org.springframework.stereotype.Repository;

import livedDemo.model.User;

@Repository
public class UserRedisDao extends IRedisDao<User>{

	@Override
	public String getRedisKey() {
		return RedisConfig.RedisKeyConfig.USER;
	}
	
}
