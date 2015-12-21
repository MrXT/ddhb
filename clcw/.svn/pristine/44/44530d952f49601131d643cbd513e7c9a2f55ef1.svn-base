/**
\ * Project Name:dtdp File Name:BaseService.java Package
 * Name:com.manzz.framework.core.model Date:2015-02-03上午 11:21:12 Copyright (c)
 * 2015, manzz.com All Rights Reserved.
 */

package com.manzz.framework.core.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import com.manzz.framework.core.util.JacksonUtils;

/**
 * ClassName: RedisClient <br/>
 * Function: REDIS缓存客户端操作类
 * @author WJK
 * @version 2015-06
 */
public class RedisClient <T> {

    private static transient Log logger = LogFactory.getLog(RedisClient.class);
    
    private ShardedJedisPool shardedJedisPool;
    
    public ShardedJedisPool getShardedJedisPool() {
        return shardedJedisPool;
    }
    
    public void setShardedJedisPool(ShardedJedisPool shardedJedisPool) {
        this.shardedJedisPool = shardedJedisPool;
    }

    /**
     * 设置一个key的过期时间（单位：秒）
     * @param key key值
     * @param seconds 多少秒后过期
     * @return 1：设置了过期时间 0：没有设置过期时间/不能设置过期时间
     */
    public long expire(String key, int seconds) {
        if (key == null || key.equals("")) {
            return 0;
        }

        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.expire(key, seconds);
        } catch (Exception ex) {
            logger.error("EXPIRE error[key=" + key + " seconds=" + seconds + "]" + ex.getMessage(), ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
            return 0;
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
    }

    /**
     * 设置一个key在某个时间点过期
     * @param key key值
     * @param unixTimestamp unix时间戳，从1970-01-01 00:00:00开始到现在的秒数
     * @return 1：设置了过期时间 0：没有设置过期时间/不能设置过期时间
     */
    public long expireAt(String key, int unixTimestamp) {
        if (key == null || key.equals("")) {
            return 0;
        }

        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.expireAt(key, unixTimestamp);
        } catch (Exception ex) {
            logger.error("EXPIRE error[key=" + key + " unixTimestamp=" + unixTimestamp + "]" + ex.getMessage(), ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
            return 0;
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
    }

    /**
     * 截断一个List
     * @param key 列表key
     * @param start 开始位置 从0开始
     * @param end 结束位置
     * @return 状态码
     */
    public String trimList(String key, long start, long end) {
        if (key == null || key.equals("")) {
            return "-";
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.ltrim(key, start, end);
        } catch (Exception ex) {
            logger.error("LTRIM 出错[key=" + key + " start=" + start + " end=" + end + "]" + ex.getMessage(), ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
            return "-";
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
    }

    /**
     * 检查Set长度
     * @param key
     * @return
     */
    public long countSet(String key) {
        if (key == null) {
            return 0;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.scard(key);
        } catch (Exception ex) {
            logger.error("countSet error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
            return 0;
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
    }
    
    /**
     * 添加到Set中（同时设置过期时间）
     * @param key key值
     * @param seconds 过期时间 单位s
     * @param value
     * @return
     */
    public boolean addSetObject(String key, int seconds, T value) {
        boolean result = addSetObject(key, value);
        if (result) {
            long i = expire(key, seconds);
            return i == 1;
        }
        return false;
    }

    /**
     * 添加到Set中
     * @param key
     * @param value
     * @return
     */
    public boolean addSetObject(String key, T value) {
        if (key == null || value == null) {
            return false;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            shardedJedis.sadd(key, JacksonUtils.beanToJson(value));
            return true;
        } catch (Exception ex) {
            logger.error("addSet error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
            return false;
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
    }

    /**
     * @param key
     * @param value
     * @return 判断值是否包含在set中
     */
    public boolean containsInSetObject(String key, T value) {
        if (key == null || value == null) {
            return false;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.sismember(key, JacksonUtils.beanToJson(value));
        } catch (Exception ex) {
            logger.error("containsInSet error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
            return false;
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
    }
    
    /**
     * 获取Set
     * @param key
     * @return
     */
    public Set<byte[]> getSet(byte[] data) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.smembers(data);
        } catch (Exception ex) {
            logger.error("getSet error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
            return new HashSet<byte[]>();
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
    }

    /**
     * 从set中删除value
     * @param key
     * @return
     */
    public boolean removeSetObjectValue(String key, T value) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            shardedJedis.srem(key, JacksonUtils.beanToJson(value));
            return true;
        } catch (Exception ex) {
            logger.error("removeSetValue error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
            return false;
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
    }

    /**
     * 从list中删除value 默认count 1
     * @param key
     * @param values 值list
     * @return
     */
    public int removeListValue(String key, List<T> values) {
        return removeListValue(key, 1, values);
    }

    /**
     * 从list中删除value
     * @param key
     * @param count
     * @param values 值list
     * @return
     */
    public int removeListValue(String key, long count, List<T> values) {
        int result = 0;
        if (values != null && values.size() > 0) {
            for (T value : values) {
                if (removeListValue(key, count, value)) {
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * 从list中删除value
     * @param key
     * @param count 要删除个数
     * @param value
     * @return
     */
    public boolean removeListValue(String key, long count, T value) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            shardedJedis.lrem(key, count, JacksonUtils.beanToJson(value));
            return true;
        } catch (Exception ex) {
            logger.error("removeListValue error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
            return false;
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        
    }

    /**
     * 截取List
     * @param key
     * @param start 起始位置
     * @param end 结束位置
     * @return
     */
    public List<String> rangeList(String key, long start, long end) {
        if (key == null || key.equals("")) {
            return null;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.lrange(key, start, end);
        } catch (Exception ex) {
            logger.error("rangeList 出错[key=" + key + " start=" + start + " end=" + end + "]" + ex.getMessage(), ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
            return new ArrayList<String>();
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
    }

    /**
     * 检查List长度
     * @param key
     * @return
     */
    public long countList(String key) {
        if (key == null) {
            return 0;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.llen(key);
        } catch (Exception ex) {
            logger.error("countList error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
            return 0;
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
    }

    /**
     * 添加到List中（同时设置过期时间）
     * @param key key值
     * @param seconds 过期时间 单位s
     * @param value
     * @return
     */
    public boolean setList(String key, int seconds, List<T> value) {
        boolean result = setList(key, value);
        if (result) {
            long i = expire(key, seconds);
            return i == 1;
        }
        return false;
    }

    /**
     * 添加到List
     * @param key
     * @param value
     * @return
     */
    public boolean setList(String key, List<T> value) {
        if (key == null || value == null) {
            return false;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            shardedJedis.del(key);//清除原有数据
            shardedJedis.set(key, JacksonUtils.beanToJson(value));
            return true;
        } catch (Exception ex) {
            logger.error("redis error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
            return false;
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
    }
    
    /**
     * 设置HashSet
     * @param domain 域名
     * @param key 键
     * @param value 值
     * @return -1表示设置失败 0表示key已存在 1 表示key为新增 
     */
    public long setHSet(String domain, String key, String value) {
        if (value == null)
            return 0;
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.hset(domain, key, value);
        } catch (Exception ex) {
            logger.error("setHSet error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
            return -1;
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
    }

    /**
     * 设置HashSet对象
     * @param domain 域名
     * @param key 键值
     * @param value 实体对象
     * @return
     */
    public boolean setHSetObject(String domain, String key, T value) {
        if (value == null)
            return false;
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            shardedJedis.hset(domain, key, JacksonUtils.beanToJson(value));
            return true;
        } catch (Exception ex) {
            logger.error("setHSet error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
            return false;
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
    }
    
    /**
     * 设置HashSet对象
     * @param domain 域名
     * @param key 键值
     * @param value List实体对象
     * @return
     */
    public boolean setHSetObject(String domain, String key, Collection<T> value) {
        if (value == null)
            return false;
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            shardedJedis.del(key);//清除原有数据
            shardedJedis.hset(domain, key, JacksonUtils.beanToJson(value));
            return true;
        } catch (Exception ex) {
            logger.error("setHSet error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
            return false;
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
    }

    /**
     * 获得HashSet对象
     * @param domain 域名
     * @param key 键值
     * @param 返回的对象类
     * @return 
     */
    public T getHSet(String domain, String key,Class<T> clazz) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return JacksonUtils.jsonToBean(shardedJedis.hget(domain, key), clazz);
        } catch (Exception ex) {
            logger.error("getHSet error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
            return null;
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
    }
    
    /**
     * 获得HashSet返回List
     * @param domain 域名
     * @param key 键值
     * @param clazzArray 返回的对象类数组
     * @return 
     */
    public List<T> getHSetToList(String domain, String key,Class<T[]> clazzArray) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return JacksonUtils.jsonToList(shardedJedis.hget(domain, key), clazzArray);      
        } catch (Exception ex) {
            logger.error("getHSet error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
            return null;
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
    }

    /**
     * 删除HashSet对象
     * @param domain 域名
     * @param key 键值
     * @return 删除的记录数
     */
    public long delHSet(String domain, String key) {
        ShardedJedis shardedJedis = null;
        long count = 0;
        try {
            shardedJedis = shardedJedisPool.getResource();
            count = shardedJedis.hdel(domain, key);
        } catch (Exception ex) {
            logger.error("delHSet error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return count;
    }

    /**
     * 删除HashSet对象
     * @param domain 域名
     * @param key 键值
     * @return 删除的记录数
     */
    public long delHSet(String domain, String... key) {
        ShardedJedis shardedJedis = null;
        long count = 0;
        try {
            shardedJedis = shardedJedisPool.getResource();
            count = shardedJedis.hdel(domain, key);
        } catch (Exception ex) {
            logger.error("delHSet error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return count;
    }
    
    /**
     * 判断domain是否存在
     * @param domain 域名
     * @return
     */
    public boolean exists(String domain) {
        ShardedJedis shardedJedis = null;
        boolean isExist = false;
        try {
            shardedJedis = shardedJedisPool.getResource();
            isExist = shardedJedis.exists(domain);
        } catch (Exception ex) {
            logger.error("existsHSet error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return isExist;
    }

    /**
     * 判断key是否存在
     * @param domain 域名
     * @param key 键值
     * @return
     */
    public boolean existsHSet(String domain, String key) {
        ShardedJedis shardedJedis = null;
        boolean isExist = false;
        try {
            shardedJedis = shardedJedisPool.getResource();
            isExist = shardedJedis.hexists(domain, key);
        } catch (Exception ex) {
            logger.error("existsHSet error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return isExist;
    }

    /**
     * 全局扫描hset
     * @param match field匹配模式
     * @return
     */
    public List<Map.Entry<String, String>> scanHSet(String domain, String match) {
        ShardedJedis shardedJedis = null;
        try {
            int cursor = 0;
            shardedJedis = shardedJedisPool.getResource();
            ScanParams scanParams = new ScanParams();
            scanParams.match(match);
            Jedis jedis = shardedJedis.getShard(domain);
            ScanResult<Map.Entry<String, String>> scanResult;
            List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>();
            do {
                scanResult = jedis.hscan(domain, String.valueOf(cursor), scanParams);
                list.addAll(scanResult.getResult());
                cursor = Integer.parseInt(scanResult.getStringCursor());
            } while (cursor > 0);
            return list;
        } catch (Exception ex) {
            logger.error("scanHSet error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return null;
    }

    /**
     * 返回 domain 指定的哈希集中所有字段的value值
     * @param domain
     * @return
     */

    public List<String> hvals(String domain) {
        ShardedJedis shardedJedis = null;
        List<String> retList = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            retList = shardedJedis.hvals(domain);
        } catch (Exception ex) {
            logger.error("hvals error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return retList;
    }

    /**
     * 返回 domain 指定的哈希集中所有字段的key值
     * @param domain
     * @return
     */
    public Set<String> hkeys(String domain) {
        ShardedJedis shardedJedis = null;
        Set<String> retList = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            retList = shardedJedis.hkeys(domain);
        } catch (Exception ex) {
            logger.error("hkeys error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return retList;
    }

    /**
     * 返回 domain 指定的哈希key值总数
     * @param domain
     * @return
     */
    public long lenHset(String domain) {
        ShardedJedis shardedJedis = null;
        long retList = 0;
        try {
            shardedJedis = shardedJedisPool.getResource();
            retList = shardedJedis.hlen(domain);
        } catch (Exception ex) {
            logger.error("hkeys error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return retList;
    }

    /**
     * 设置排序集合
     * @param key
     * @param score
     * @param value
     * @return
     */
    public boolean setSortedSetObject(String key, long score, T value) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            shardedJedis.zadd(key, score, JacksonUtils.beanToJson(value));
            return true;
        } catch (Exception ex) {
            logger.error("setSortedSet error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return false;
    }

    /**
     * 获得排序集合
     * @param key
     * @param startScore
     * @param endScore
     * @param orderByDesc
     * @return
     */
    public Set<String> getSoredSet(String key, long startScore, long endScore, boolean orderByDesc) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            if (orderByDesc) {
                return shardedJedis.zrevrangeByScore(key, endScore, startScore);
            } else {
                return shardedJedis.zrangeByScore(key, startScore, endScore);
            }
        } catch (Exception ex) {
            logger.error("getSoredSet error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return null;
    }

    /**
     * 计算排序长度
     * @param key
     * @param startScore
     * @param endScore
     * @return
     */
    public long countSoredSet(String key, long startScore, long endScore) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            Long count = shardedJedis.zcount(key, startScore, endScore);
            return count == null ? 0L : count;
        } catch (Exception ex) {
            logger.error("countSoredSet error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return 0L;
    }

    /**
     * 删除排序集合
     * @param key
     * @param value
     * @return
     */
    public boolean delSortedSetObject(String key, T value) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            long count = shardedJedis.zrem(key, JacksonUtils.beanToJson(value));
            return count > 0;
        } catch (Exception ex) {
            logger.error("delSortedSet error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return false;
    }

    /**
     * 获得排序集合
     * @param key
     * @param startRange
     * @param endRange
     * @param orderByDesc
     * @return
     */
    public Set<String> getSoredSetByRange(String key, int startRange, int endRange, boolean orderByDesc) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            if (orderByDesc) {
                return shardedJedis.zrevrange(key, startRange, endRange);
            } else {
                return shardedJedis.zrange(key, startRange, endRange);
            }
        } catch (Exception ex) {
            logger.error("getSoredSetByRange error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return null;
    }

    /**
     * 获得排序打分
     * @param key
     * @return
     */
    public Double getScore(String key, String member) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.zscore(key, member);
        } catch (Exception ex) {
            logger.error("getSoredSet error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return null;
    }
    
    public boolean set(String key, String value, int second) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            shardedJedis.setex(key, second, value);
            return true;
        } catch (Exception ex) {
            logger.error("set error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return false;
    }

    public boolean setObject(String key, T value, int second) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            shardedJedis.setex(key, second, JacksonUtils.beanToJson(value));
            return true;
        } catch (Exception ex) {
            logger.error("set error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return false;
    }
    
    public boolean set(String key, String value) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            shardedJedis.set(key, value);
            return true;
        } catch (Exception ex) {
            logger.error("set error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return false;
    }


    public boolean setObject(String key, T value) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            shardedJedis.set(key, JacksonUtils.beanToJson(value));
            return true;
        } catch (Exception ex) {
            logger.error("set error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return false;
    }
    
    public String get(String key) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.get(key);
        } catch (Exception ex) {
            logger.error("get error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
            return null;
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
    }
    
    public T getObject(String key,Class<T> clazz) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return JacksonUtils.jsonToBean(shardedJedis.get(key),clazz);
        } catch (Exception ex) {
            logger.error("get error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
            return null;
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
    }
    
    public List<T> getListObject(String key, Class<T[]> clazzArray) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return JacksonUtils.jsonToList(shardedJedis.get(key), clazzArray);
        } catch (Exception ex) {
            logger.error("get error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
            return null;
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
    }

    public String get(String key, String defaultValue) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.get(key) == null ? defaultValue : shardedJedis.get(key);
        } catch (Exception ex) {
            logger.error("get error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return defaultValue;
    }

    public boolean del(String key) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            shardedJedis.del(key);
            return true;
        } catch (Exception ex) {
            logger.error("del error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return false;
    }

    public long incr(String key) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.incr(key);
        } catch (Exception ex) {
            logger.error("incr error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return 0;
    }

    public long decr(String key) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            return shardedJedis.decr(key);
        } catch (Exception ex) {
            logger.error("incr error.", ex);
            shardedJedisPool.returnBrokenResource(shardedJedis);
        } finally {
            shardedJedisPool.returnResource(shardedJedis);
        }
        return 0;
    }
}
