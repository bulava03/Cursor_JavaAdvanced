package org.example;

public class MusicPlayer {
    private ClassicalMusicPlayer classicalMusicPlayer;
    private RockMusicPlayer rockMusicPlayer;

    public MusicPlayer(ClassicalMusicPlayer classicalMusicPlayer, RockMusicPlayer rockMusicPlayer) {
        this.classicalMusicPlayer = classicalMusicPlayer;
        this.rockMusicPlayer = rockMusicPlayer;
    }

    public void playClassical() {
        classicalMusicPlayer.play();
    }

    public void playRock() {
        rockMusicPlayer.play();
    }
}
