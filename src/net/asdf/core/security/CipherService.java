package net.asdf.core.security;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CipherService {

	@Value("#{asdf['secret.salt'] ?: '1234567890123456'}")
	private String 소금;

	@Value("#{asdf['secret.key'] ?: '1234567890123456'}")
	private String 시크릿;

	@Value("#{asdf['secret.iv']} ?: '1234567890123456'}")
	private String 초기값;

	/**
	 * 512비트 (두자리 16진수 64자 두자리에 한바이트)
	 * @param 비밀번호
	 * @return
	 */
	public String password(String 비밀번호) {
		String 암호화된비밀번호 = null;
		try {
			암호화된비밀번호 = new String(Hex.encodeHex(DigestUtils.getSha512Digest().digest((비밀번호 + 소금).getBytes("UTF-8")), true));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return 암호화된비밀번호;
	}

	public String decipher(String 암호문){

		if(암호문 == null) {
			return null;
		}
		if(암호문.length() == 0) {
			return "";
		}
		String 평문 = null;
		try {
			Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
			SecretKeySpec skeySpec = new SecretKeySpec(시크릿.getBytes("UTF-8"), "AES");
			IvParameterSpec randomIvSpec = new IvParameterSpec(초기값.getBytes("UTF-8"));
			c.init(Cipher.DECRYPT_MODE, skeySpec, randomIvSpec, new SecureRandom());
			c.update(Hex.decodeHex(암호문.toCharArray()));
			평문 = new String(c.doFinal(), "UTF-8");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (DecoderException e) {
			e.printStackTrace();
		}
		return 평문;
	}

	public String cipher(String 평문) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException {

		if(평문 == null) {
			return null;
		}
		if(평문.length() == 0) {
			return "";
		}

		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		SecretKeySpec skeySpec = new SecretKeySpec(시크릿.getBytes("UTF-8"), "AES");
		IvParameterSpec randomIvSpec = new IvParameterSpec(초기값.getBytes("UTF-8"));
		c.init(Cipher.ENCRYPT_MODE, skeySpec, randomIvSpec, new SecureRandom());
		c.update(평문.getBytes("UTF-8"));
		return new String(Hex.encodeHex(c.doFinal(), true));
	}
}