package com.sid.myCache;

import java.util.HashMap;
import java.util.Map;

public class SingletonMapCache {

	protected static Map<String, Map<String, Double>> mapCache = new HashMap<String, Map<String, Double>>();
    
	private static volatile SingletonMapCache mapCacheInstance = null;
	
	private SingletonMapCache() 
	{
		mapCache = new HashMap<String, Map<String, Double>>();
	}
	
	//Only once instance is kept during the lifecycle of the application
	public static SingletonMapCache getInstance() 
	{
		if (mapCacheInstance == null) {
            synchronized (SingletonMapCache.class) {
                // Double check
                if (mapCacheInstance == null) {
                	mapCacheInstance = new SingletonMapCache();
                }
            }
        }
		return mapCacheInstance;
	}
	
	public static void put(String mapKey, String weightName, Double weight) 
	{
		System.out.println("SingletonMapCache:: put() execution:34: mapKey :"  + mapKey+" weightName: "+weightName +" weight :"+weight);
		if(mapCache.containsKey(mapKey)) {
			Map submap = mapCache.get(mapKey);
			submap.put(weightName, weight);
			System.out.println("SingletonMapCache:: put() execution:46: submap "  + submap.get(weightName));
		} else {
			Map submap = new HashMap();
			submap.put(weightName, weight);
			mapCache.put(mapKey, submap);
			System.out.println("SingletonMapCache:: put() execution:51: SingletonMapCache.mapCache "  + SingletonMapCache.get(mapKey));
		}		
	}
 
	public static Map get(String key) 
	{
		return mapCache.get(key);
	}
	
	public static void emptyCache() {
    	mapCache.clear();
    }
}
