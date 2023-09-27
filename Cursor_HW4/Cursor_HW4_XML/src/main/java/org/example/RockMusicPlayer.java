package org.example;

import java.util.List;

public class RockMusicPlayer {
    private List<MusicComposition> compositions;

    public RockMusicPlayer(List<MusicComposition> compositions) {
        this.compositions = compositions;
    }

    public void play() {
        System.out.println("Playing rock music:");
        for (MusicComposition composition : compositions) {
            System.out.println(composition.getTitle() + " by " + composition.getArtist());
        }
    }
}
