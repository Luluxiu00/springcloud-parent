package com.olmysoft.util;

public final class RedisUtils {

	private static RedisCluster RedisCluster;

	private RedisUtils() {
	}

	public static void init(final RedisConfig redisConfig) {
		if (null == RedisCluster) {
			RedisClusterFactory.init(redisConfig);
			RedisCluster = RedisClusterFactory.getInstance();
		}
	}

	public static void set(final String key, final String value) {
		RedisCluster.set(key, value);
	}

	public static String get(final String key) {
		return RedisCluster.get(key);
	}

	public static void set(final String key, final String value, final int expireSeconds) {
		RedisCluster.setex(key, expireSeconds, value);
	}

	public static Long del(final String... key) {
		return RedisCluster.del(key);
	}

}
