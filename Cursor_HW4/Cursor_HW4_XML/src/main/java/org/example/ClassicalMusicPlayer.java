package org.example;

import java.util.List;

public class ClassicalMusicPlayer {
    private List<MusicComposition> compositions;

    public ClassicalMusicPlayer(List<MusicComposition> compositions) {
        this.compositions = compositions;
    }

    public void play() {
        System.out.println("Playing classical music:");
        for (MusicComposition composition : compositions) {
            System.out.println(composition.getTitle() + " by " + composition.getArtist());
        }
    }
}
