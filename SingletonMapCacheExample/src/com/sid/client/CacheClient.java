package com.sid.client;

import com.sid.myCache.SingletonMapCache;
import static com.sid.myCache.SingletonMapCache.getInstance;

public class CacheClient {

	public SingletonMapCache m_SingletonMapCache = getInstance();
	
	public static void setMapCacheWeight(String mapKey, String weightRule, double weight){
  	SingletonMapCache.put(mapKey, weightRule, weight);
  	System.out.println("setMapCacheWeight: SingletonMapCache.mapCache for mapKey: \""+mapKey+"\" :"  + SingletonMapCache.get(mapKey));
  }
	
	public static void main(String[] args) {
		setMapCacheWeight("one", "abc", 1.0);
		setMapCacheWeight("one", "pqr", 2.2);
		setMapCacheWeight("two", "xyz", 5.2);
		setMapCacheWeight("two", "abc", 7.9);
    	System.out.println("after putting into MapCache:26: SingletonMapCache.mapCache for mapKey: \"one\":"  + SingletonMapCache.get("one"));
    	System.out.println("after putting into MapCache:27: SingletonMapCache.mapCache for mapKey: \"two\":"  + SingletonMapCache.get("two"));
	}
}
