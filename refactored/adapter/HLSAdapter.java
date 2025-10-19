// src/refactored/adapter/HLSAdapter.java
package refactored.adapter;

import refactored.core.MediaSource;

public class HLSAdapter implements MediaSource {
    private String streamUrl;
    
    public HLSAdapter(String streamUrl) {
        this.streamUrl = streamUrl;
    }
    
    @Override
    public void play() {
        System.out.println("HLSAdapter: Connecting to: " + streamUrl);
        System.out.println("HLSAdapter: Fetching m3u8 playlist...");
        System.out.println("HLSAdapter: Downloading segments...");
        System.out.println("HLSAdapter: Streaming: " + streamUrl);
    }
    
    @Override
    public void pause() {
        System.out.println("HLSAdapter: Paused stream: " + streamUrl);
    }
    
    @Override
    public void stop() {
        System.out.println("HLSAdapter: Stopped stream: " + streamUrl);
    }
    
    @Override
    public String getSourceInfo() {
        return "HLS Stream: " + streamUrl;
    }
}