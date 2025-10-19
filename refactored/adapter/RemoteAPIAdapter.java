// src/refactored/adapter/RemoteAPIAdapter.java
package refactored.adapter;

import refactored.core.MediaSource;

public class RemoteAPIAdapter implements MediaSource {
    private String apiUrl;
    private String mediaId;
    
    public RemoteAPIAdapter(String apiUrl, String mediaId) {
        this.apiUrl = apiUrl;
        this.mediaId = mediaId;
    }
    
    @Override
    public void play() {
        System.out.println("RemoteAPIAdapter: Calling API: " + apiUrl);
        System.out.println("RemoteAPIAdapter: Requesting media ID: " + mediaId);
        System.out.println("RemoteAPIAdapter: Parsing JSON response...");
        System.out.println("RemoteAPIAdapter: Getting stream URL...");
        System.out.println("RemoteAPIAdapter: Playing media: " + mediaId);
    }
    
    @Override
    public void pause() {
        System.out.println("RemoteAPIAdapter: Paused API media: " + mediaId);
    }
    
    @Override
    public void stop() {
        System.out.println("RemoteAPIAdapter: Stopped API media: " + mediaId);
    }
    
    @Override
    public String getSourceInfo() {
        return "Remote API: " + apiUrl + "/" + mediaId;
    }
}