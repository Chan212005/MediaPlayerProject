// src/refactored/composite/MediaFile.java
package refactored.composite;

import java.util.ArrayList;
import java.util.List;

import refactored.core.MediaSource;

public class Playlist implements MediaItem {
    private String name;
    private List<MediaItem> items = new ArrayList<>();
    private Object source;
    
    public Playlist(String name) {
        this.name = name;
        this.source = source;
    }
    
    @Override
    public void play() {
        System.out.println("Playing file: " + name);
        ((MediaSource) source).play();
    }
    
    @Override
    public void displayInfo() {
        System.out.println("  - File: " + name + " (" + ((MediaSource) source).getSourceInfo() + ")");
    }

    public void add(MediaItem file1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }
}