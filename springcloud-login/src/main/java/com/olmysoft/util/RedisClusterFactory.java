package com.olmysoft.util;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;

public final class RedisClusterFactory {

	private static RedisConfig redisClusterConfig;
	private static RedisCluster redisCluster;

	private RedisClusterFactory() {
	}

	public synchronized static void init(final RedisConfig redisConfig) {
		if (null == redisClusterConfig) {
			redisClusterConfig = redisConfig;
		}
	}

	public synchronized static RedisCluster getInstance() {
		try {
			if (null == redisCluster) {
				String[] serverArray = redisClusterConfig.getNodes().split(",");
				Set<HostAndPort> nodes = new HashSet<>();
				for (String ipPort : serverArray) {
					String[] ipPortPair = ipPort.split(":");
					nodes.add(new HostAndPort(ipPortPair[0].trim(), Integer.valueOf(ipPortPair[1].trim())));
				}

				redisCluster = new RedisCluster(nodes, redisClusterConfig.getConnectionTimeOut());
			}

			return redisCluster;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
