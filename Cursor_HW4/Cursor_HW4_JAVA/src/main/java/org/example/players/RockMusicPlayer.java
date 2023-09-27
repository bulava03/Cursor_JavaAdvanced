package org.example.players;

import org.example.domain.MusicPlayer;
import org.example.domain.MusicTrack;

import java.util.List;

public class RockMusicPlayer implements MusicPlayer {
    private List<MusicTrack> rockTracks;

    public RockMusicPlayer(List<MusicTrack> rockTracks) {
        this.rockTracks = rockTracks;
    }

    @Override
    public void play() {
        System.out.println("Playing rock music:");
        for (MusicTrack track : rockTracks) {
            System.out.println(track.getArtist() + " - " + track.getTitle());
        }
    }
}
