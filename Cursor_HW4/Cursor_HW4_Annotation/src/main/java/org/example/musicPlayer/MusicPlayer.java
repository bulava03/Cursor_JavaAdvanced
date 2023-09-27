package org.example.musicPlayer;

import org.example.musicPlayer.service.ClassicalMusicPlayer;
import org.example.musicPlayer.service.RockMusicPlayer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MusicPlayer {
    private ClassicalMusicPlayer classicalMusicPlayer;
    private RockMusicPlayer rockMusicPlayer;

    @Autowired
    public MusicPlayer(ClassicalMusicPlayer classicalMusicPlayer, RockMusicPlayer rockMusicPlayer) {
        this.classicalMusicPlayer = classicalMusicPlayer;
        this.rockMusicPlayer = rockMusicPlayer;
    }

    public void playClassical() {
        classicalMusicPlayer.playClassicalMusic();
    }

    public void playRock() {
        rockMusicPlayer.playRockMusic();
    }
}
