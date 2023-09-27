package org.example.musicPlayer;

import org.example.musicPlayer.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MusicPlayer musicPlayer = context.getBean(MusicPlayer.class);
        musicPlayer.playClassical();
        musicPlayer.playRock();

        context.close();
    }
}
