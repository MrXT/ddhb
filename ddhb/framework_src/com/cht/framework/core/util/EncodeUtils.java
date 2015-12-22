package com.cht.framework.core.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.web.util.HtmlUtils;

public abstract class EncodeUtils {

	static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	public static String encode2HtmlUnicode(String str) {
		if (str == null) {
			return null;
		}

		StringBuilder sb = new StringBuilder(str.length() * 2);
		for (int i = 0; i < str.length(); i++) {
			sb.append(encode2HtmlUnicode(str.charAt(i)));
		}
		return sb.toString();
	}

	public static String encode2HtmlUnicode(char character) {
		if (character > 'ÿ') {
			return new StringBuilder().append("&#").append(character & 0xFFFF)
					.append(";").toString();
		}
		return HtmlUtils.htmlEscape(String.valueOf(character));
	}

	public static String encode2HtmlUnicode(Character character) {
		if (character == null)
			return null;
		return encode2HtmlUnicode(character.charValue());
	}

	public static void encode2HtmlUnicode(String[] value) {
		if ((value == null) || (value.length < 1)) {
			return;
		}

		for (int i = 0; i < value.length; i++)
			value[i] = encode2HtmlUnicode(value[i]);
	}

	public static String encrypt(String text, String algorithm) {
		if (text == null) {
			return null;
		}
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			messageDigest.update(text.getBytes());
			return getFormattedText(messageDigest.digest());
		} catch (NoSuchAlgorithmException e) {
		}
		throw new SecurityException();
	}

	public static String encrypt(String password) {
		return encrypt(password, "MD5");
	}

	private static String getFormattedText(byte[] bytes) {
		StringBuilder buf = new StringBuilder(bytes.length * 2);

		for (int j = 0; j < bytes.length; j++) {
			buf.append(HEX_DIGITS[(bytes[j] >> 4 & 0xF)]);
			buf.append(HEX_DIGITS[(bytes[j] & 0xF)]);
		}
		return buf.toString();
	}
}