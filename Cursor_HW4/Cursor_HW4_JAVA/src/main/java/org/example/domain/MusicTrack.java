package org.example.domain;

public class MusicTrack {
    private String title;
    private String artist;

    public MusicTrack(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return this.title;
    }

    public String getArtist() {
        return this.artist;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
