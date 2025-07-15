package com.jarvis.texttospeech.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TextRequest {
  @Size(min = 1, message = "Text cannot be empty if provided")
  private String text;

  private String ssml;
  private String voice;
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public String getSsml() {
	return ssml;
}
public void setSsml(String ssml) {
	this.ssml = ssml;
}
public String getVoice() {
	return voice;
}
public void setVoice(String voice) {
	this.voice = voice;
}

}
