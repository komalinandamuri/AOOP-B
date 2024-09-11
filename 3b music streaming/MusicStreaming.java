// MusicStreamingApp.java

// Common Interface for Music Playback
interface MusicPlayer {
    void play();
}

// Bridge Pattern: Abstraction for Music Playback
interface MusicPlayback {
    void playMusic();
}

// Concrete Implementations for Different Music Sources
class LocalMusicPlayer implements MusicPlayback {
    private String filePath;

    public LocalMusicPlayer(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void playMusic() {
        System.out.println("Playing local file: " + filePath);
    }
}

class OnlineStreamingPlayer implements MusicPlayback {
    private String streamUrl;

    public OnlineStreamingPlayer(String streamUrl) {
        this.streamUrl = streamUrl;
    }

    @Override
    public void playMusic() {
        System.out.println("Streaming online from: " + streamUrl);
    }
}

class RadioStationPlayer implements MusicPlayback {
    private String stationName;

    public RadioStationPlayer(String stationName) {
        this.stationName = stationName;
    }

    @Override
    public void playMusic() {
        System.out.println("Tuning in to radio station: " + stationName);
    }
}

// Adapter Pattern: Adapting Music Sources to MusicPlayer Interface
class LocalMusicAdapter implements MusicPlayer {
    private MusicPlayback localMusicPlayer;

    public LocalMusicAdapter(String filePath) {
        this.localMusicPlayer = new LocalMusicPlayer(filePath);
    }

    @Override
    public void play() {
        localMusicPlayer.playMusic();
    }
}

class OnlineStreamingAdapter implements MusicPlayer {
    private MusicPlayback onlineStreamingPlayer;

    public OnlineStreamingAdapter(String streamUrl) {
        this.onlineStreamingPlayer = new OnlineStreamingPlayer(streamUrl);
    }

    @Override
    public void play() {
        onlineStreamingPlayer.playMusic();
    }
}

class RadioStationAdapter implements MusicPlayer {
    private MusicPlayback radioStationPlayer;

    public RadioStationAdapter(String stationName) {
        this.radioStationPlayer = new RadioStationPlayer(stationName);
    }

    @Override
    public void play() {
        radioStationPlayer.playMusic();
    }
}

// Decorator Pattern: Base Decorator for Adding Features
abstract class MusicPlayerDecorator implements MusicPlayer {
    protected MusicPlayer decoratedPlayer;

    public MusicPlayerDecorator(MusicPlayer decoratedPlayer) {
        this.decoratedPlayer = decoratedPlayer;
    }

    @Override
    public void play() {
        decoratedPlayer.play();
    }
}

// Concrete Decorators
class EqualizerDecorator extends MusicPlayerDecorator {
    public EqualizerDecorator(MusicPlayer decoratedPlayer) {
        super(decoratedPlayer);
    }

    @Override
    public void play() {
        decoratedPlayer.play();
        setEqualizer();
    }

    private void setEqualizer() {
        System.out.println("Applying equalizer settings...");
    }
}

class VolumeControlDecorator extends MusicPlayerDecorator {
    private int volume;

    public VolumeControlDecorator(MusicPlayer decoratedPlayer, int volume) {
        super(decoratedPlayer);
        this.volume = volume;
    }

    @Override
    public void play() {
        decoratedPlayer.play();
        setVolume();
    }

    private void setVolume() {
        System.out.println("Setting volume to: " + volume);
    }
}
