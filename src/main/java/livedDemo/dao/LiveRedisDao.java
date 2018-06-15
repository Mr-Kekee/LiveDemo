package livedDemo.dao;

import org.springframework.stereotype.Repository;

import livedDemo.model.LiveRedis;

@Repository
public class LiveRedisDao extends IRedisDao<LiveRedis>{

	@Override
	protected String getRedisKey() {
		return RedisConfig.RedisKeyConfig.LIVE;
	}

}
