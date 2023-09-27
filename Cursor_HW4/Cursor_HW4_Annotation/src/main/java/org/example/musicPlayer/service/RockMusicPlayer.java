package org.example.musicPlayer.service;
import org.example.musicPlayer.domain.MusicTrack;

import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class RockMusicPlayer {
    private List<MusicTrack> rockTracks;

    public void playRockMusic() {
        System.out.println("Playing rock music:");
        for (MusicTrack track : rockTracks) {
            System.out.println("Title: " + track.getTitle() + ", Artist: " + track.getArtist());
        }
    }

    @PostConstruct
    public void init() {
        this.rockTracks = new ArrayList<MusicTrack>();
        rockTracks.add(new MusicTrack("Bohemian Rhapsody", "Queen"));
        rockTracks.add(new MusicTrack("Stairway to Heaven", "Led Zeppelin"));
    }
}
