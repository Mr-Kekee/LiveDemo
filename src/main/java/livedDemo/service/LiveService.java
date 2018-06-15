package livedDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import livedDemo.dao.LiveRedisDao;
import livedDemo.model.LiveRedis;

@Service
public class LiveService {

	@Autowired
	private LiveRedisDao liveRedisDao;
	
	public void save(LiveRedis live) {
		liveRedisDao.put(live.getLiveName(), live, -1);
	}
	
	public List<LiveRedis> getAll() {
		List<LiveRedis> users = liveRedisDao.getAll();
		return users;
	}
}
