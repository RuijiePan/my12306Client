package com.blog.utils;

import java.util.Random;

/**
 * 随机生成验证码
 * @author GZS
 */
public class EcodeUtil {
	private static Random randGen = null;
	private static char[] numbersAndLetters = null;
	/**
	 * 生成指定长度的验证码
	 * @param length
	 * @return
	 */
	public static final String getEcode(int length) {
		if (length < 1)
				return null;
		if (randGen == null) {
				randGen = new Random();
				numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyz" +
				"0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
		}
		char [] randBuffer = new char[length];
		for (int i=0; i<randBuffer.length; i++) {
		randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];
		}
		return new String(randBuffer);
	}
}
