package com.jarvis.texttospeech.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Configuration
@ConfigurationProperties(prefix = "azure.speech")
@Slf4j
public class AzureTTSConfig {
	
	private static final Logger log = LoggerFactory.getLogger(AzureTTSConfig.class);
  private String key;
  private String region;
  private String voice;
  private String outputFormat;

  public String getKey() {
	return key;
}

public void setKey(String key) {
	this.key = key;
}

public String getRegion() {
	return region;
}

public void setRegion(String region) {
	this.region = region;
}

public String getVoice() {
	return voice;
}

public void setVoice(String voice) {
	this.voice = voice;
}

public String getOutputFormat() {
	return outputFormat;
}

public void setOutputFormat(String outputFormat) {
	this.outputFormat = outputFormat;
}

public static Logger getLog() {
	return log;
}

public AzureTTSConfig() {
    log.info("✅ AzureTTSConfig loaded");
  }
}
