package com.yctu.sms.util;

import org.apache.commons.codec.binary.Hex;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

public class MD5Util {


	public static String MD5(String input) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			return "check jdk";
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		char[] charArray = input.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();

	}	 

		public static String generate(String password) {
			
	 		String salt = "***********";
	 		password = md5Hex(salt + password);
			return password;
		}


		public static boolean verify(String password, String md5) {
	 		char[] cs1 = new char[32];
			char[] cs2 = new char[16];
			for (int i = 0; i < 48; i += 3) {
				cs1[i / 3 * 2] = md5.charAt(i);
				cs1[i / 3 * 2 + 1] = md5.charAt(i + 2);
				cs2[i / 3] = md5.charAt(i + 1);
			}
			String salt = new String(cs2);
			return md5Hex(password + salt).equals(new String(cs1));
		}


		private static String md5Hex(String src) {
			try {
				MessageDigest md5 = MessageDigest.getInstance("MD5");
				byte[] bs = md5.digest(src.getBytes());
				return new String(new Hex().encode(bs));
			} catch (Exception e) {
				return null;
			}
		}

	  
	 
	 
}
