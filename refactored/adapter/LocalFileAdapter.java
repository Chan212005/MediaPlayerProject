// src/refactored/adapter/LocalFileAdapter.java
package refactored.adapter;

import refactored.core.MediaSource;

public class LocalFileAdapter implements MediaSource {
    private String filePath;
    
    public LocalFileAdapter(String filePath) {
        this.filePath = filePath;
    }
    
    @Override
    public void play() {
        System.out.println("LocalFileAdapter: Opening file: " + filePath);
        System.out.println("LocalFileAdapter: Reading file data...");
        System.out.println("LocalFileAdapter: Decoding media...");
        System.out.println("LocalFileAdapter: Playing: " + filePath);
    }
    
    @Override
    public void pause() {
        System.out.println("LocalFileAdapter: Paused file: " + filePath);
    }
    
    @Override
    public void stop() {
        System.out.println("LocalFileAdapter: Stopped file: " + filePath);
    }
    
    @Override
    public String getSourceInfo() {
        return "Local File: " + filePath;
    }
}