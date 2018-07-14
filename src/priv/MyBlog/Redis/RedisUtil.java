package priv.MyBlog.Redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import java.util.concurrent.TimeUnit;
public class RedisUtil {

	@Autowired
	private static RedisTemplate<String,Object> redisTemplate;
	
	
	public static RedisTemplate<String, Object> getRedisTemplate() {
		return redisTemplate;
	}

	public static void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
		RedisUtil.redisTemplate = redisTemplate;
	}

	//设置缓存内容以及时间
	public static void set(String key,Object object, int time ,TimeUnit timeUnit) {
		redisTemplate.opsForValue().set(key, object);
		if(timeUnit==null||time==0) return ;
		redisTemplate.expire(key, time, timeUnit);
	}
	
	public static Object get(String key) {
		Object obj = redisTemplate.opsForValue().get(key);
		return obj;
	}
}
