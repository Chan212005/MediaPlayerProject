// src/refactored/decorator/MediaDecorator.java
package refactored.decorator;

import refactored.core.MediaSource;

public abstract class MediaDecorator implements MediaSource {
    protected MediaSource wrappedSource;
    
    public MediaDecorator(MediaSource source) {
        this.wrappedSource = source;
    }
    
    @Override
    public void play() {
        wrappedSource.play();
    }
    
    @Override
    public void pause() {
        wrappedSource.pause();
    }
    
    @Override
    public void stop() {
        wrappedSource.stop();
    }
    
    @Override
    public String getSourceInfo() {
        return wrappedSource.getSourceInfo();
    }
}