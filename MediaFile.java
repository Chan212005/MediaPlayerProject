// src/refactored/composite/MediaFile.java


import refactored.composite.MediaItem;
import refactored.core.MediaSource;

public class MediaFile implements MediaItem {
    private String name;
    private MediaSource source;
    
    public MediaFile(String name, MediaSource source) {
        this.name = name;
        this.source = source;
    }
    
    @Override
    public void play() {
        System.out.println("Playing file: " + name);
        source.play();
    }
    
    @Override
    public void displayInfo() {
        System.out.println("  - File: " + name + " (" + source.getSourceInfo() + ")");
    }
}