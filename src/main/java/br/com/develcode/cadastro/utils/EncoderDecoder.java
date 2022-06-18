package br.com.develcode.cadastro.utils;

import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class EncoderDecoder {

	public byte[] decoder(byte[] foto) throws IOException {
		byte[] decodedBytes = Base64.getDecoder().decode(foto);
		return decodedBytes;
	}

	public byte[] encoder(MultipartFile foto) throws IOException {
		byte[] encodedBytes = Base64.getEncoder().encode(foto.getBytes());

		return encodedBytes;
	}
}
