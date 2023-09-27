package org.example.players;

import org.example.domain.MusicPlayer;
import org.example.domain.MusicTrack;

import java.util.List;

public class ClassicalMusicPlayer implements MusicPlayer {
    private List<MusicTrack> classicalTracks;

    public ClassicalMusicPlayer(List<MusicTrack> classicalTracks) {
        this.classicalTracks = classicalTracks;
    }

    @Override
    public void play() {
        System.out.println("Playing classical music:");
        for (MusicTrack track : classicalTracks) {
            System.out.println(track.getArtist() + " - " + track.getTitle());
        }
    }
}
