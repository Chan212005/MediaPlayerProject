// src/refactored/RefactoredDemo.java
package refactored;

import refactored.core.*;
import refactored.adapter.*;
import refactored.decorator.*;
import refactored.composite.*;
import refactored.strategy.*;
import refactored.proxy.*;

public class RefactoredDemo {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║  REFACTORED MEDIA PLAYER - ALL PATTERNS     ║");
        System.out.println("╚══════════════════════════════════════════════╝\n");
        
        // DEMO 1: ADAPTER PATTERN
        System.out.println("\n========== DEMO 1: ADAPTER PATTERN ==========");
        System.out.println("Playing from different sources using common interface\n");
        
        MediaSource localFile = new LocalFileAdapter("movie.mp4");
        MediaSource hlsStream = new HLSAdapter("https://example.com/stream.m3u8");
        MediaSource apiMedia = new RemoteAPIAdapter("https://api.media.com", "video123");
        
        MediaPlayer player = new MediaPlayer(localFile);
        player.play();
        player.stop();
        
        System.out.println();
        player.setSource(hlsStream);
        player.play();
        player.stop();
        
        // DEMO 2: DECORATOR PATTERN
        System.out.println("\n\n========== DEMO 2: DECORATOR PATTERN ==========");
        System.out.println("Adding features dynamically with decorators\n");
        
        MediaSource decoratedSource = new LocalFileAdapter("video.mp4");
        decoratedSource = new SubtitleDecorator(decoratedSource, "subtitles.srt");
        decoratedSource = new WatermarkDecorator(decoratedSource, "© 2025 MyCompany");
        decoratedSource = new EqualizerDecorator(decoratedSource, 7);
        
        System.out.println("Source info: " + decoratedSource.getSourceInfo());
        player.setSource(decoratedSource);
        player.play();
        player.stop();
        
        // DEMO 3: STRATEGY PATTERN
        System.out.println("\n\n========== DEMO 3: STRATEGY PATTERN ==========");
        System.out.println("Switching rendering strategy at runtime\n");
        
        player.setSource(new LocalFileAdapter("hd_movie.mp4"));
        
        System.out.println("--- Using Hardware Rendering ---");
        player.setRenderStrategy(new HardwareRenderStrategy());
        player.play();
        player.stop();
        
        System.out.println("\n--- Switching to Software Rendering ---");
        player.setRenderStrategy(new SoftwareRenderStrategy());
        player.play();
        player.stop();
        
        // DEMO 4: PROXY PATTERN
        System.out.println("\n\n========== DEMO 4: PROXY PATTERN ==========");
        System.out.println("Caching remote content with proxy\n");
        
        MediaSource remoteSource = new RemoteAPIAdapter("https://api.cdn.com", "stream456");
        MediaSource cachedSource = new CachingProxy(remoteSource, "stream456");
        
        System.out.println("--- First play (cache miss) ---");
        player.setSource(cachedSource);
        player.play();
        player.stop();
        
        System.out.println("\n--- Second play (cache hit) ---");
        player.play();
        player.stop();
        
        // DEMO 5: COMPOSITE PATTERN
        System.out.println("\n\n========== DEMO 5: COMPOSITE PATTERN ==========");
        System.out.println("Creating nested playlists\n");
        
        // Create individual files
        MediaItem file1 = (MediaItem) new MediaFile("Song1", new LocalFileAdapter("song1.mp3"));
        MediaItem file2 = (MediaItem) new MediaFile("Song2", new LocalFileAdapter("song2.mp3"));
        MediaItem file3 = (MediaItem) new MediaFile("Video1", new HLSAdapter("https://stream.com/v1.m3u8"));
        
        // Create sub-playlist
        Playlist rockPlaylist = new Playlist("Rock Classics");
        rockPlaylist.add(file1);
        rockPlaylist.add(file2);
        
        // Create main playlist with nested playlist
        Playlist mainPlaylist = new Playlist("My Favorites");
        mainPlaylist.add(rockPlaylist);
        mainPlaylist.add(file3);
        
        System.out.println("Playlist structure:");
        mainPlaylist.displayInfo();
        
        System.out.println("\nPlaying entire playlist:");
        mainPlaylist.play();
        
        // DEMO 6: COMBINING ALL PATTERNS
        System.out.println("\n========== DEMO 6: ALL PATTERNS COMBINED ==========");
        System.out.println("Decorated source + Proxy + Strategy in Playlist\n");
        
        MediaSource complexSource = new RemoteAPIAdapter("https://api.live.com", "live789");
        complexSource = new CachingProxy(complexSource, "live789");
        complexSource = new SubtitleDecorator(complexSource, "live.srt");
        complexSource = new WatermarkDecorator(complexSource, "LIVE");
        
        MediaItem liveStream = (MediaItem) new MediaFile("Live Event", complexSource);
        
        Playlist eventPlaylist = new Playlist("Live Event Package");
        eventPlaylist.add(liveStream);
        
        player.setRenderStrategy(new HardwareRenderStrategy());
        player.setSource(complexSource);
        
        System.out.println("Playing with all patterns:");
        player.play();
        player.stop();
        
        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║  BENEFITS OF REFACTORED CODE:               ║");
        System.out.println("║  ✓ No code duplication                      ║");
        System.out.println("║  ✓ Easy to add new sources (Adapter)        ║");
        System.out.println("║  ✓ Dynamic features (Decorator)             ║");
        System.out.println("║  ✓ Nested playlists (Composite)             ║");
        System.out.println("║  ✓ Switchable rendering (Strategy)          ║");
        System.out.println("║  ✓ Transparent caching (Proxy)              ║");
        System.out.println("╚══════════════════════════════════════════════╝");
    }
}