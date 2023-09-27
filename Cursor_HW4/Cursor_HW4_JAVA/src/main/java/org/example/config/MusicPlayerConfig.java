package org.example.config;

import org.example.players.ClassicalMusicPlayer;
import org.example.service.MusicPlayerService;
import org.example.domain.MusicTrack;
import org.example.players.RockMusicPlayer;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

public class MusicPlayerConfig {

    @Bean
    public MusicTrack classicalTrack1() {
        return new MusicTrack("Symphony No. 5", "Ludwig van Beethoven");
    }

    @Bean
    public MusicTrack classicalTrack2() {
        return new MusicTrack("The Four Seasons", "Antonio Vivaldi");
    }

    @Bean
    public MusicTrack rockTrack1() {
        return new MusicTrack("Bohemian Rhapsody", "Queen");
    }

    @Bean
    public MusicTrack rockTrack2() {
        return new MusicTrack("Stairway to Heaven", "Led Zeppelin");
    }

    @Bean
    public ClassicalMusicPlayer classicalMusicPlayer() {
        return new ClassicalMusicPlayer(Arrays.asList(classicalTrack1(), classicalTrack2()));
    }

    @Bean
    public RockMusicPlayer rockMusicPlayer() {
        return new RockMusicPlayer(Arrays.asList(rockTrack1(), rockTrack2()));
    }

    @Bean
    public MusicPlayerService musicPlayerService() {
        return new MusicPlayerService(classicalMusicPlayer(), rockMusicPlayer());
    }
}
