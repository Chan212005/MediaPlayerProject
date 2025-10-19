// src/refactored/core/MediaPlayer.java
package refactored.core;

import refactored.strategy.RenderStrategy;

public class MediaPlayer implements MediaSource {
    private MediaSource source;
    private RenderStrategy renderStrategy;
    private boolean isPlaying;
    
    public MediaPlayer(MediaSource source) {
        this.source = source;
    }
    
    public void setSource(MediaSource source) {
        this.source = source;
    }
    
    public void setRenderStrategy(RenderStrategy strategy) {
        this.renderStrategy = strategy;
    }
    
    @Override
    public void play() {
        if (renderStrategy != null) {
            renderStrategy.render();
        }
        source.play();
        isPlaying = true;
    }
    
    @Override
    public void pause() {
        source.pause();
        isPlaying = false;
    }
    
    @Override
    public void stop() {
        source.stop();
        isPlaying = false;
    }
    
    @Override
    public String getSourceInfo() {
        return source.getSourceInfo();
    }
    
    public boolean isPlaying() {
        return isPlaying;
    }
}