// src/refactored/decorator/EqualizerDecorator.java
package refactored.decorator;

import refactored.core.MediaSource;

public class EqualizerDecorator extends MediaDecorator {
    private int level;
    
    public EqualizerDecorator(MediaSource source, int level) {
        super(source);
        this.level = level;
    }
    
    @Override
    public void play() {
        System.out.println("EqualizerDecorator: Setting equalizer level: " + level);
        System.out.println("EqualizerDecorator: Adjusting audio frequencies...");
        super.play();
    }
    
    @Override
    public String getSourceInfo() {
        return super.getSourceInfo() + " [with Equalizer: Level " + level + "]";
    }
}