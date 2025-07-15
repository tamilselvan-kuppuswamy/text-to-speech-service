package com.jarvis.texttospeech;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.servlet.annotation.MultipartConfig;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class TextToSpeechServiceApplication {
	
	private static final Logger log = LoggerFactory.getLogger(MultipartConfig.class);

  public static void main(String[] args) {
    log.info("🚀 Starting Text-to-Speech Service...");
    SpringApplication.run(TextToSpeechServiceApplication.class, args);
    log.info("🚀 Started Text-to-Speech Service...");
  }
}
