package com.example.Cursor_HW12;

import com.example.Cursor_HW12.config.DatabaseInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(DatabaseInitializer.class)
public class CursorHw12Application {

	public static void main(String[] args) {
		SpringApplication.run(CursorHw12Application.class, args);
	}

}
