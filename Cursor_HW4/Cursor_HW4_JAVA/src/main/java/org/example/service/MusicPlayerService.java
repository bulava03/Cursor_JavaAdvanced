package org.example.service;

import org.example.domain.MusicPlayer;

public class MusicPlayerService {
    private MusicPlayer classicalMusicPlayer;
    private MusicPlayer rockMusicPlayer;

    public MusicPlayerService(MusicPlayer classicalMusicPlayer, MusicPlayer rockMusicPlayer) {
        this.classicalMusicPlayer = classicalMusicPlayer;
        this.rockMusicPlayer = rockMusicPlayer;
    }

    public void playClassicalMusic() {
        classicalMusicPlayer.play();
    }

    public void playRockMusic() {
        rockMusicPlayer.play();
    }
}
