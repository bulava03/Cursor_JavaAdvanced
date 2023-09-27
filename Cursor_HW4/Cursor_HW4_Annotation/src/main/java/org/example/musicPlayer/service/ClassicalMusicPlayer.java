package org.example.musicPlayer.service;

import java.util.List;

import org.example.musicPlayer.domain.MusicTrack;

import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

import java.util.ArrayList;

@Component
public class ClassicalMusicPlayer {
    private List<MusicTrack> classicalTracks;

    public void playClassicalMusic() {
        System.out.println("Playing classical music:");
        for (MusicTrack track : classicalTracks) {
            System.out.println("Title: " + track.getTitle() + ", Artist: " + track.getArtist());
        }
    }

    @PostConstruct
    public void init() {
        this.classicalTracks = new ArrayList<MusicTrack>();
        classicalTracks.add(new MusicTrack("Symphony No. 5", "Ludwig van Beethoven"));
        classicalTracks.add(new MusicTrack("The Four Seasons", "Antonio Vivaldi"));
    }
}
