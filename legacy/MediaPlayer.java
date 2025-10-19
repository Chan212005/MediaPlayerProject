// src/legacy/MediaPlayer.java
package legacy;

public class MediaPlayer {
    private String currentFile;
    private boolean isPlaying;
    private boolean subtitlesEnabled;
    private boolean watermarkEnabled;
    private int equalizerLevel;
    
    public void playLocalFile(String path) {
        System.out.println("=== Playing Local File ===");
        this.currentFile = path;
        // Messy duplicated code for local files
        System.out.println("Opening file: " + path);
        System.out.println("Reading file data...");
        System.out.println("Decoding audio/video...");
        
        if (subtitlesEnabled) {
            System.out.println("Rendering subtitles from file...");
        }
        if (watermarkEnabled) {
            System.out.println("Adding watermark overlay...");
        }
        if (equalizerLevel > 0) {
            System.out.println("Applying equalizer level: " + equalizerLevel);
        }
        
        System.out.println("Playing: " + path);
        isPlaying = true;
    }
    
    public void playHLSStream(String url) {
        System.out.println("=== Playing HLS Stream ===");
        this.currentFile = url;
        // Duplicated code for HLS - almost same as local
        System.out.println("Connecting to HLS: " + url);
        System.out.println("Fetching m3u8 playlist...");
        System.out.println("Downloading segments...");
        System.out.println("Decoding audio/video...");
        
        if (subtitlesEnabled) {
            System.out.println("Rendering subtitles from stream...");
        }
        if (watermarkEnabled) {
            System.out.println("Adding watermark overlay...");
        }
        if (equalizerLevel > 0) {
            System.out.println("Applying equalizer level: " + equalizerLevel);
        }
        
        System.out.println("Streaming: " + url);
        isPlaying = true;
    }
    
    public void playRemoteAPI(String apiUrl, String mediaId) {
        System.out.println("=== Playing from Remote API ===");
        this.currentFile = apiUrl + "/" + mediaId;
        // More duplicated code
        System.out.println("Calling API: " + apiUrl);
        System.out.println("Requesting media ID: " + mediaId);
        System.out.println("Parsing JSON response...");
        System.out.println("Getting stream URL...");
        System.out.println("Decoding audio/video...");
        
        if (subtitlesEnabled) {
            System.out.println("Rendering subtitles from API...");
        }
        if (watermarkEnabled) {
            System.out.println("Adding watermark overlay...");
        }
        if (equalizerLevel > 0) {
            System.out.println("Applying equalizer level: " + equalizerLevel);
        }
        
        System.out.println("Playing from API: " + mediaId);
        isPlaying = true;
    }
    
    // No way to switch rendering without changing code
    public void renderWithHardware() {
        System.out.println("Using hardware acceleration (hardcoded)");
    }
    
    public void renderWithSoftware() {
        System.out.println("Using software rendering (hardcoded)");
    }
    
    // Features are baked in, not pluggable
    public void enableSubtitles(boolean enable) {
        this.subtitlesEnabled = enable;
        System.out.println("Subtitles: " + (enable ? "ON" : "OFF"));
    }
    
    public void enableWatermark(boolean enable) {
        this.watermarkEnabled = enable;
        System.out.println("Watermark: " + (enable ? "ON" : "OFF"));
    }
    
    public void setEqualizer(int level) {
        this.equalizerLevel = level;
        System.out.println("Equalizer set to: " + level);
    }
    
    public void pause() {
        if (isPlaying) {
            System.out.println("Paused: " + currentFile);
            isPlaying = false;
        }
    }
    
    public void stop() {
        System.out.println("Stopped: " + currentFile);
        isPlaying = false;
        currentFile = null;
    }
    
    // No composite pattern - can't handle playlists properly
    public void playMultipleFiles(String[] files) {
        System.out.println("=== Playing Multiple Files (crude loop) ===");
        for (String file : files) {
            playLocalFile(file);
            System.out.println("---");
        }
    }
}
