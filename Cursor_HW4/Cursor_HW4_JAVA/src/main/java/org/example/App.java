package org.example;

import org.example.config.MusicPlayerConfig;
import org.example.service.MusicPlayerService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MusicPlayerConfig.class);

        MusicPlayerService musicPlayerService = context.getBean(MusicPlayerService.class);

        musicPlayerService.playClassicalMusic();
        musicPlayerService.playRockMusic();

        context.close();
    }
}
