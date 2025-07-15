package com.jarvis.texttospeech.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jarvis.texttospeech.dto.TextRequest;
import com.jarvis.texttospeech.service.TextToSpeechService;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/tts")
@RequiredArgsConstructor
@Slf4j
public class TTSController {

	private static final Logger log = LoggerFactory.getLogger(MultipartConfig.class);

	@Autowired
	TextToSpeechService textToSpeechService;

	@PostMapping
	public ResponseEntity<?> synthesize(@Valid @RequestBody TextRequest request,
			@RequestHeader(value = "X-Correlation-ID", required = false) String correlationId,
			@RequestParam(defaultValue = "false") boolean returnBuffer) {
		log.info("📥 TTS Request received | correlationId={} | buffer={} | voice={}", correlationId, returnBuffer,
				request.getVoice());

		if (returnBuffer) {
			byte[] audio = textToSpeechService.synthesizeToBuffer(request.getText(), request.getSsml(), correlationId,
					request.getVoice());

			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"tts.mp3\"")
					.contentType(MediaType.APPLICATION_OCTET_STREAM).body(new ByteArrayResource(audio));
		} else {
			String audioUrl = textToSpeechService.synthesizeAndStore(request.getText(), request.getSsml(),
					correlationId, request.getVoice());

			return ResponseEntity.ok(Map.of("audioUrl", audioUrl));
		}
	}
}
