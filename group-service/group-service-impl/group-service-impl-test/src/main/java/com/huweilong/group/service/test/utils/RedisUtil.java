package com.huweilong.group.service.test.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * redis 工具类
 */
@Slf4j
@Component
public class RedisUtil {

	/**
	 *
	 */
	@Autowired
	private RedisTemplate redisTemplate;

	/**
	 * 设置缓存失效时间
	 * @param key 缓存名
	 * @param time 失效时间
	 * @return true成功 false失败
	 */
	public boolean expire(String key, long time) {
		if (time > 0) {
			return redisTemplate.expire(key, time, TimeUnit.SECONDS);
		} else {
			log.error("expire", "time = " + time);
			return false;
		}
	}

	/**
	 * 获取缓存失效时间
	 * @param key 缓存名
	 * @return 失效时间 单位：秒 返回0代表为永久有效
	 */
	public long getExpire(String key) {
		return redisTemplate.getExpire(key, TimeUnit.SECONDS);
	}

	/**
	 * 判断缓存是否存在
	 * @param key 缓存名
	 * @return true 存在 false不存在
	 */
	public boolean exist(String key) {
		return redisTemplate.hasKey(key);
	}

	/**
	 * 删除缓存
	 * @param key 缓存名 可以传一个或多个值
	 */
	public void del(String... key) {
		if (key != null && key.length > 0) {
			if (key.length == 1) {
				redisTemplate.delete(key[0]);
			} else {
				redisTemplate.delete(CollectionUtils.arrayToList(key));
			}
		}
	}

	// ============================String============================

	/**
	 * 获取缓存内容
	 * @param key 缓存名
	 * @return 缓存结果
	 */
	public Object get(String key) {
		return key == null ? null : redisTemplate.opsForValue().get(key);
	}

	/**
	 * 设置缓存内容
	 * @param key 缓存名
	 * @param value 缓存内容
	 * @return true成功 false失败
	 */
	public boolean set(String key, Object value) {
		redisTemplate.opsForValue().set(key, value);
		return true;
	}

	/**
	 * 设置缓存内容
	 * @param key 缓存名
	 * @param value 缓存内容
	 * @param time 失效时间 单位：秒 time要大于0 如果time小于等于0 将设置无限期
	 * @return true成功 false失败
	 */
	public boolean set(String key, Object value, long time) {
		if (time > 0) {
			redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
		} else {
			set(key, value);
		}
		return true;
	}

	/**
	 * 递增
	 * @param key 缓存名
	 * @param delta 递增因子
	 * @return 递增后的缓存内容
	 */
	public long incr(String key, long delta) {
		if (delta < 0) {
			throw new RuntimeException("递增因子必须大于0");
		}
		return redisTemplate.opsForValue().increment(key, Math.abs(delta));
	}

	/**
	 * 递减
	 * @param key 缓存名
	 * @param delta 递减因子
	 * @return 递减后的缓存内容
	 */
	public long decr(String key, long delta) {
		if (delta < 0) {
			throw new RuntimeException("递减因子必须大于0");
		}

		return redisTemplate.opsForValue().increment(key, -Math.abs(delta));
	}

	// ================================Map=================================

	/**
	 * 获取缓存内容
	 * @param key 缓存名
	 * @param item hash名
	 * @return 缓存内容
	 */
	public Object getHash(String key, String item) {
		return redisTemplate.opsForHash().get(key, item);
	}

	/**
	 * 获取缓存内容
	 * @param key 缓存名
	 * @return 缓存内容
	 */
	public Map<Object, Object> getHash(String key) {
		return redisTemplate.opsForHash().entries(key);
	}

	/**
	 * 设置缓存内容
	 * @param key 缓存名
	 * @param map 缓存内容
	 * @return true成功 false失败
	 */
	public boolean setHash(String key, Map<String, Object> map) {
		redisTemplate.opsForHash().putAll(key, map);
		return true;
	}

	/**
	 * 设置缓存内容
	 * @param key 缓存名
	 * @param map 缓存内容
	 * @param time 失效时间 单位：秒 time要大于0 如果time小于等于0 将设置无限期
	 * @return true成功 false失败
	 */
	public boolean setHash(String key, Map<String, Object> map, long time) {
		redisTemplate.opsForHash().putAll(key, map);
		if (time > 0) {
			expire(key, time);
		}
		return true;
	}

	/**
	 * 设置缓存内容
	 * @param key 缓存名
	 * @param item hash名
	 * @param value 缓存内容
	 * @return true成功 false失败
	 */
	public boolean setHash(String key, String item, Object value) {
		redisTemplate.opsForHash().put(key, item, value);
		return true;
	}

	/**
	 * 设置缓存内容
	 * @param key 缓存名
	 * @param item hash名
	 * @param value 缓存内容
	 * @param time 失效时间 单位：秒 time要大于0 如果time小于等于0则保留之前的设置
	 * @return true成功 false失败
	 */
	public boolean setHash(String key, String item, Object value, long time) {
		redisTemplate.opsForHash().put(key, item, value);
		if (time > 0) {
			expire(key, time);
		}
		return true;
	}

	/**
	 * 删除缓存
	 * @param key 缓存名
	 * @param item hash名 可以传一个或多个值
	 */
	public void delHash(String key, Object... item) {
		redisTemplate.opsForHash().delete(key, item);
	}

	/**
	 * 判断缓存是否存在
	 * @param key 缓存名
	 * @param item hash名
	 * @return true 存在 false不存在
	 */
	public boolean existHash(String key, String item) {
		return redisTemplate.opsForHash().hasKey(key, item);
	}

	/**
	 * 递增
	 * @param key 缓存名
	 * @param item hash名
	 * @param delta 递增因子
	 * @return 递增后的缓存内容
	 */
	public double incrHash(String key, String item, double delta) {
		if (delta < 0) {
			throw new RuntimeException("递增因子必须大于0");
		}
		return redisTemplate.opsForHash().increment(key, item, Math.abs(delta));
	}

	/**
	 * 递减
	 * @param key 缓存名
	 * @param item hash名
	 * @param delta 递减因子
	 * @return 递减后的缓存内容
	 */
	public double decrHash(String key, String item, double delta) {
		if (delta < 0) {
			throw new RuntimeException("递增因子必须大于0");
		}
		return redisTemplate.opsForHash().increment(key, item, -Math.abs(delta));
	}

	// ============================set=============================

	/**
	 * 获取缓存内容
	 * @param key 缓存名
	 * @return 缓存内容
	 */
	public Set<Object> getSet(String key) {
		return redisTemplate.opsForSet().members(key);
	}

	/**
	 * 获取缓存内容的长度
	 * @param key 缓存名
	 * @return 缓存内容的长度
	 */
	public long getSetSize(String key) {
		return redisTemplate.opsForSet().size(key);
	}

	/**
	 * 设置缓存内容
	 * @param key 缓存名
	 * @param values 缓存内容 可以传一个或多个值
	 * @return 成功个数
	 */
	public long setSet(String key, Object... values) {
		return redisTemplate.opsForSet().add(key, values);
	}

	/**
	 * 设置缓存内容
	 * @param key 缓存名
	 * @param time 失效时间 单位：秒 time要大于0 如果time小于等于0则保留之前的设置
	 * @param values 缓存内容 可以传一个或多个值
	 * @return 成功个数
	 */
	public long setSet(String key, long time, Object... values) {
		Long count = redisTemplate.opsForSet().add(key, values);
		if (time > 0) {
			expire(key, time);
		}
		return count;
	}

	/**
	 * 删除缓存
	 * @param key 缓存名
	 * @param values 缓存内容 可以传一个或多个值
	 * @return 删除的个数
	 */
	public long delSet(String key, Object... values) {
		return redisTemplate.opsForSet().remove(key, values);
	}

	/**
	 * 判断缓存是否存在
	 * @param key 缓存名
	 * @param value 缓存内容
	 * @return true 存在 false不存在
	 */
	public boolean existSet(String key, Object value) {
		return redisTemplate.opsForSet().isMember(key, value);
	}

	// ===============================list=================================

	/**
	 * 获取缓存内容
	 * @param key 缓存名
	 * @param start 开始位置
	 * @param end 结束位置
	 * @return 缓存内容
	 */
	public List<Object> getList(String key, long start, long end) {
		return redisTemplate.opsForList().range(key, start, end);
	}

	/**
	 * 获取缓存内容
	 * @param key 缓存名
	 * @param index 位置索引
	 * @return 缓存内容
	 */
	public Object getList(String key, long index) {
		return redisTemplate.opsForList().index(key, index);
	}

	/**
	 * 获取缓存内容的长度
	 * @param key 缓存名
	 * @return 缓存内容的长度
	 */
	public long getListSize(String key) {
		return redisTemplate.opsForList().size(key);
	}

	/**
	 * 设置缓存内容
	 * @param key 缓存名
	 * @param value 缓存内容
	 * @return true成功 false失败
	 */
	public boolean setList(String key, Object value) {
		redisTemplate.opsForList().rightPush(key, value);
		return true;
	}

	/**
	 * 设置缓存内容
	 * @param key 缓存名
	 * @param index 位置索引
	 * @param value 缓存内容
	 * @return true成功 false失败
	 */
	public boolean setList(String key, long index, Object value) {
		redisTemplate.opsForList().set(key, index, value);
		return true;
	}

	/**
	 * 设置缓存内容
	 * @param key 缓存名
	 * @param value 缓存内容
	 * @param time 失效时间 单位：秒 time要大于0 如果time小于等于0则保留之前的设置
	 * @return true成功 false失败
	 */
	public boolean setList(String key, Object value, long time) {
		redisTemplate.opsForList().rightPush(key, value);
		if (time > 0) {
			expire(key, time);
		}
		return true;
	}

	/**
	 * 设置缓存内容
	 * @param key 缓存名
	 * @param value 缓存内容
	 * @return true成功 false失败
	 */
	public boolean setList(String key, List<Object> value) {
		redisTemplate.opsForList().rightPushAll(key, value);
		return true;
	}

	/**
	 * 设置缓存内容
	 * @param key 缓存名
	 * @param value 缓存内容
	 * @param time 失效时间 单位：秒 time要大于0 如果time小于等于0则保留之前的设置
	 * @return true成功 false失败
	 */
	public boolean setList(String key, List<Object> value, long time) {
		redisTemplate.opsForList().rightPushAll(key, value);
		if (time > 0) {
			expire(key, time);
		}
		return true;
	}

	/**
	 * 删除缓存
	 * @param key 缓存名
	 * @param count 移除多少个
	 * @param value 缓存内容
	 * @return 移除的个数
	 */
	public long delList(String key, long count, Object value) {
		return redisTemplate.opsForList().remove(key, count, value);
	}
}
