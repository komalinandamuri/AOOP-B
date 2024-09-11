// Main.java

public class Online {
    public static void main(String[] args) {
        // Create MusicPlayer instances with different sources
        MusicPlayer localPlayer = new LocalMusicAdapter("song.mp3");
        MusicPlayer onlinePlayer = new OnlineStreamingAdapter("http://example.com/stream");
        MusicPlayer radioPlayer = new RadioStationAdapter("Classic Rock FM");

        // Add decorators to the local music player
        MusicPlayer equalizedLocalPlayer = new EqualizerDecorator(localPlayer);
        MusicPlayer volumeControlledLocalPlayer = new VolumeControlDecorator(equalizedLocalPlayer, 75);

        // Demonstrate functionality
        System.out.println("Playing local music:");
        volumeControlledLocalPlayer.play();

        System.out.println("\nPlaying online stream:");
        onlinePlayer.play();

        System.out.println("\nPlaying radio station:");
        radioPlayer.play();
    }
}
