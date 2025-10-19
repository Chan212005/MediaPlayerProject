// src/legacy/LegacyDemo.java
package legacy;

public class LegacyDemo {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║  LEGACY MESSY MEDIA PLAYER DEMO       ║");
        System.out.println("╚════════════════════════════════════════╝\n");
        
        MediaPlayer player = new MediaPlayer();
        
        // Enable features (baked in, not flexible)
        player.enableSubtitles(true);
        player.enableWatermark(true);
        player.setEqualizer(5);
        
        System.out.println("\n--- Test 1: Local File ---");
        player.playLocalFile("movie.mp4");
        player.pause();
        
        System.out.println("\n--- Test 2: HLS Stream ---");
        player.playHLSStream("https://example.com/stream.m3u8");
        player.stop();
        
        System.out.println("\n--- Test 3: Remote API ---");
        player.playRemoteAPI("https://api.media.com", "video123");
        player.stop();
        
        System.out.println("\n--- Test 4: Multiple Files (no proper playlist) ---");
        String[] files = {"video1.mp4", "video2.mp4"};
        player.playMultipleFiles(files);
        
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║  PROBLEMS WITH LEGACY CODE:           ║");
        System.out.println("║  - Duplicated code in each method     ║");
        System.out.println("║  - Can't add features dynamically     ║");
        System.out.println("║  - No playlist support                ║");
        System.out.println("║  - Hardcoded rendering                ║");
        System.out.println("║  - No caching mechanism               ║");
        System.out.println("╚════════════════════════════════════════╝");
    }
}