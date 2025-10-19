// src/refactored/core/MediaSource.java
package refactored.core;

public interface MediaSource {
    void play();
    void pause();
    void stop();
    String getSourceInfo();
}