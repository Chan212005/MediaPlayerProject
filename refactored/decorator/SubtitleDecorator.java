// src/refactored/decorator/SubtitleDecorator.java
package refactored.decorator;

import refactored.core.MediaSource;

public class SubtitleDecorator extends MediaDecorator {
    private String subtitleFile;
    
    public SubtitleDecorator(MediaSource source, String subtitleFile) {
        super(source);
        this.subtitleFile = subtitleFile;
    }
    
    @Override
    public void play() {
        System.out.println("SubtitleDecorator: Loading subtitles from: " + subtitleFile);
        System.out.println("SubtitleDecorator: Rendering subtitles...");
        super.play();
    }
    
    @Override
    public String getSourceInfo() {
        return super.getSourceInfo() + " [with Subtitles: " + subtitleFile + "]";
    }
}