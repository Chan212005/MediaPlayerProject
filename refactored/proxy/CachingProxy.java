// src/refactored/proxy/CachingProxy.java
package refactored.proxy;

import refactored.core.MediaSource;
import java.util.HashMap;
import java.util.Map;

public class CachingProxy implements MediaSource {
    private MediaSource realSource;
    private static Map<String, String> cache = new HashMap<>();
    private String cacheKey;
    
    public CachingProxy(MediaSource realSource, String cacheKey) {
        this.realSource = realSource;
        this.cacheKey = cacheKey;
    }
    
    @Override
    public void play() {
        if (cache.containsKey(cacheKey)) {
            System.out.println("CachingProxy: Loading from cache for: " + cacheKey);
            System.out.println("CachingProxy: Cache hit! Playing cached content...");
        } else {
            System.out.println("CachingProxy: Cache miss! Fetching from source...");
            realSource.play();
            cache.put(cacheKey, "cached_data_for_" + cacheKey);
            System.out.println("CachingProxy: Content cached for future use");
        }
    }
    
    @Override
    public void pause() {
        realSource.pause();
    }
    
    @Override
    public void stop() {
        realSource.stop();
    }
    
    @Override
    public String getSourceInfo() {
        return "Cached: " + realSource.getSourceInfo();
    }
    
    public static void clearCache() {
        cache.clear();
        System.out.println("CachingProxy: Cache cleared");
    }
}