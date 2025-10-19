// src/refactored/decorator/WatermarkDecorator.java
package refactored.decorator;

import refactored.core.MediaSource;
import refactored.decorator.MediaDecorator;

@SuppressWarnings("unused")
public class WatermarkDecorator extends MediaDecorator {
    private String watermarkText;
    
    public WatermarkDecorator(MediaSource source, String watermarkText) {
        super(source);
        this.watermarkText = watermarkText;
    }
    
    @Override
    public void play() {
        System.out.println("WatermarkDecorator: Adding watermark: " + watermarkText);
        System.out.println("WatermarkDecorator: Positioning watermark overlay...");
        super.play();
    }
    
    @Override
    public String getSourceInfo() {
        return super.getSourceInfo() + " [with Watermark: " + watermarkText + "]";
    }
}