package com.manzz.framework.core.util;

import java.security.SecureRandom;
import java.util.Collection;
import java.util.UUID;

import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

public class StringUtils {
	public static final char[] NUMBERS;
	public static final char[] LOWER_CASE_LETTERS;
	public static final char[] UPPER_CASE_LETTERS;
	public static final char[] NUMBERS_LETTERS;
	private static final String[] UPPER_YUAN_NUMBERS;
	private static final String[] LOWER_YUAN_NUMBERS;
	private static final String[] UPPER_IUNIT;
	private static final String[] LOWER_IUNIT;
	private static final String[] DUNIT;

    /**
     * 首字母转换成大写
     * @param str 
     * @return
     */
    public static String capitalize(String str){
        char ch[];
        ch = str.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char) (ch[0] - 32);
        }
        return new String(ch);
        //以下算法耗时是上面算法耗时的7倍多 
        //return str.substring(0,1).toUpperCase()+str.substring(1,str.length());
    }
	
	public static String safeToUpperCase(String str, String ifNullDefaultValue) {
		return str == null ? ifNullDefaultValue : str.toUpperCase();
	}

	public static String safeToUpperCase(String str) {
		return safeToUpperCase(str, null);
	}

	public static String safeToLowerCase(String str, String ifNullDefaultValue) {
		return str == null ? ifNullDefaultValue : str.toLowerCase();
	}

	public static String safeToLowerCase(String str) {
		return safeToLowerCase(str, null);
	}

	public static String arrayToStringIgnoreNullElement(Object[] arr,
			String delim) {
		if (ObjectUtils.isEmpty(arr)) {
			return "";
		}
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			Object obj = arr[i];
			if (obj != null) {
				if (i > 0)
					result.append(delim);
				result.append(obj);
			}
		}
		return result.toString();
	}

	public static String collectionToStringIgnoreNullElement(
			Collection<?> collection, String delim) {
		if (CollectionUtils.isEmpty(collection)) {
			return "";
		}
		return arrayToStringIgnoreNullElement(collection.toArray(), delim);
	}

	public static String repeatString(int repeat, String repeatString) {
		if (repeat < 0) {
			throw new IndexOutOfBoundsException(new StringBuilder().append(
					"Cannot pad a negative amount: ").append(repeat).toString());
		}
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < repeat; i++) {
			result.append(repeatString);
		}
		return result.toString();
	}

	public static String leftPad(String str, int size, char padChar) {
		if (str == null) {
			return null;
		}
		int pads = size - str.length();
		if (pads <= 0) {
			return str;
		}
		return repeatString(pads, String.valueOf(padChar)).concat(str);
	}

	public static String rightPad(String str, int size, char padChar) {
		if (str == null) {
			return null;
		}
		int pads = size - str.length();
		if (pads <= 0) {
			return str;
		}
		return str.concat(repeatString(pads, String.valueOf(padChar)));
	}

	public static String replaceNullString(String value) {
		return replaceNullString(value, "");
	}

	public static String replaceNullString(String value, String replaceString) {
		if (value == null)
			return replaceString;
		return value;
	}

	public static String getPackagePath(Class<?> cls) {
		return getPackagePath(cls, false);
	}

	public static String getPackagePath(Class<?> cls, boolean includeClassName) {
		if (cls == null)
			return null;
		String path = cls.getName().replaceAll("\\.", "/");
		if (includeClassName)
			return path;
		int lastStart = path.lastIndexOf("/");
		return lastStart > -1 ? path.substring(0, lastStart) : "";
	}

	public static String getClassName(Class<?> cls) {
		if (cls == null)
			return null;
		String name = cls.getName();
		int lastStart = name.lastIndexOf(".");
		return lastStart > -1 ? name.substring(lastStart + 1) : name;
	}

	public static String getWholeFileName(String path) {
		String value = path;

		if (isBlank(value))
			return value;

		int lastStart = value.lastIndexOf("/");
		return lastStart > -1 ? value.substring(lastStart + 1) : value;
	}

	public static String getOnlyFileName(String path) {
		if (isBlank(path))
			return null;
		String longFileName = getWholeFileName(path);
		int lastStart = longFileName.lastIndexOf(".");
		return lastStart > -1 ? longFileName.substring(0, lastStart) : path;
	}

	public static String[] tokenizeToStringArray(String str) {
		return org.springframework.util.StringUtils.tokenizeToStringArray(str, ",", true, true);
	}
	
    public static boolean hasText(String string) {
        return org.springframework.util.StringUtils.hasText(string);
    }

	public static boolean isBlank(String value) {
		return !hasText(value);
	}

	public static String generateRandomSequence(char[] sequenceArr, int length) {
		SecureRandom rnd = new SecureRandom(UUID.randomUUID().toString()
				.getBytes());

		StringBuilder sequence = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			sequence.append(sequenceArr[rnd.nextInt(sequenceArr.length)]);
		}

		return sequence.toString();
	}

	public static String generateNumberSequence(int length) {
		return generateRandomSequence(NUMBERS, length);
	}

	public static String generateNumberLetterSequence(int length) {
		return generateRandomSequence(NUMBERS_LETTERS, length);
	}

	public static String cleanNumberString(String number) {
		if ((number == null) || (number.length() < 1))
			return number;
		return number.trim().replaceFirst("\\+", "").replaceAll(",", "");
	}

	public static boolean isLetter(String value) {
		String test = value;

		if (test == null)
			return false;

		char[] valueChars = test.toCharArray();
		for (int i = 0; i < valueChars.length; i++) {
			if (!Character.isLetter(valueChars[i])) {
				return false;
			}
		}
		return true;
	}

	public static boolean isDigit(String value, boolean ignoreSign) {
		String test = value;

		if (isBlank(value))
			return false;

		if ((ignoreSign) && ((test.startsWith("+")) || (test.startsWith("-")))) {
			test = test.substring(1);
		}

		char[] valueChars = test.toCharArray();
		for (int i = 0; i < valueChars.length; i++) {
			if (!Character.isDigit(valueChars[i])) {
				return false;
			}
		}
		return true;
	}

	public static boolean isDigit(String value) {
		return isDigit(value, false);
	}

	public static String toChineseMoney(String money) {
		return convertToChineseMoney(money, LOWER_YUAN_NUMBERS, LOWER_IUNIT);
	}

	public static String toUpperChineseMoney(String money) {
		return convertToChineseMoney(money, UPPER_YUAN_NUMBERS, UPPER_IUNIT);
	}

	private static String convertToChineseMoney(String money,
			String[] yuanNumbers, String[] iunit) {
		if (isBlank(money)) {
			throw new IllegalArgumentException(
					"The money must not be null or empty.");
		}

		money = money.replaceAll(",", "");
		String decimalStr = "";
		String integerStr = "";
		if (money.indexOf(".") > 0) {
			integerStr = money.substring(0, money.indexOf("."));
			decimalStr = money.substring(money.indexOf(".") + 1);
		} else {
			if (money.indexOf(".") == 0) {
				decimalStr = money.substring(1);
			} else {
				integerStr = money;
				decimalStr = "";
			}
		}
		if (org.springframework.util.StringUtils.hasText(integerStr)) {
			integerStr = cutLeftCharacter(integerStr, '0');
		}

		if (integerStr.length() > iunit.length) {
			throw new IllegalArgumentException(new StringBuilder().append(
					"Integer of money max length is ").append(iunit.length)
					.append(", but is [").append(money).append("].").toString());
		}
		if (decimalStr.length() > DUNIT.length) {
			throw new IllegalArgumentException(new StringBuilder().append(
					"Demcimal of money max length is ").append(DUNIT.length)
					.append(", but is [").append(money).append("].").toString());
		}
		int[] integers = toArray(integerStr);
		boolean isMust5 = isMust5(integerStr);
		int[] decimals = toArray(decimalStr);
		String resultInteger = getChineseInteger(integers, isMust5,
				yuanNumbers, iunit);
		String resultDecimal = getChineseDecimal(decimals, yuanNumbers);
		return org.springframework.util.StringUtils.hasText(resultDecimal) ? new StringBuilder().append(
				resultInteger).append(resultDecimal).toString()
				: new StringBuilder().append(resultInteger).append("整")
						.toString();
	}

	private static String cutLeftCharacter(String src, char character) {
		StringBuilder dist = new StringBuilder();
		for (int i = 0; i < src.length(); i++) {
			if (src.charAt(i) != character) {
				dist.append(src.substring(i));
				break;
			}
		}
		return dist.toString();
	}

	private static int[] toArray(String number) {
		int[] array = new int[number.length()];
		for (int i = 0; i < number.length(); i++) {
			array[i] = Integer.parseInt(number.substring(i, i + 1));
		}
		return array;
	}

	private static String getChineseInteger(int[] integers, boolean isMust5,
			String[] yuanNumbers, String[] iunit) {
		StringBuilder chineseInteger = new StringBuilder("");
		int length = integers.length;
		for (int i = 0; i < length; i++) {
			String key = "";
			if (integers[i] == 0) {
				if (length - i == 13)
					key = iunit[4];
				else if (length - i == 9)
					key = iunit[8];
				else if ((length - i == 5) && (isMust5))
					key = iunit[4];
				else if (length - i == 1) {
					key = iunit[0];
				}
				if ((length - i > 1) && (integers[(i + 1)] != 0))
					key = new StringBuilder().append(key)
							.append(yuanNumbers[0]).toString();
			}
			chineseInteger.append(integers[i] == 0 ? key : new StringBuilder()
					.append(yuanNumbers[integers[i]]).append(
							iunit[(length - i - 1)]).toString());
		}
		return chineseInteger.toString();
	}

	private static String getChineseDecimal(int[] decimals, String[] yuanNumbers) {
		StringBuilder chineseDecimal = new StringBuilder("");
		for (int i = 0; i < decimals.length; i++) {
			chineseDecimal.append(decimals[i] == 0 ? "" : new StringBuilder()
					.append(yuanNumbers[decimals[i]]).append(DUNIT[i])
					.toString());
		}
		return chineseDecimal.toString();
	}

	private static boolean isMust5(String integerStr) {
		int length = integerStr.length();
		if (length > 4) {
			String subInteger = "";
			if (length > 8) {
				subInteger = integerStr.substring(length - 8, length - 4);
			} else
				subInteger = integerStr.substring(0, length - 4);

			return Integer.parseInt(subInteger) > 0;
		}
		return false;
	}

	public static long ip2Long(String strIp) {
		String[] segments = strIp.split("\\.");
		if (segments.length == 4) {
			return (Long.parseLong(segments[0]) << 24)
					+ (Long.parseLong(segments[1]) << 16)
					+ (Long.parseLong(segments[2]) << 8)
					+ Long.parseLong(segments[3]);
		}

		throw new IllegalArgumentException(new StringBuilder().append(
				"Invalid ip address ").append(strIp).toString());
	}

	public static String long2IP(long longIp) {
		StringBuilder sb = new StringBuilder("");

		sb.append(longIp >>> 24);
		sb.append(".");

		sb.append((longIp & 0xFFFFFF) >>> 16);
		sb.append(".");

		sb.append((longIp & 0xFFFF) >>> 8);
		sb.append(".");

		sb.append(longIp & 0xFF);
		return sb.toString();
	}

	static {
		int index = 0;
		NUMBERS = new char[10];
		for (char i = '0'; i <= '9'; i = (char) (i + '\001')) {
			NUMBERS[(index++)] = i;
		}
		index = 0;
		LOWER_CASE_LETTERS = new char[26];
		for (char i = 'a'; i <= 'z'; i = (char) (i + '\001')) {
			LOWER_CASE_LETTERS[(index++)] = i;
		}
		index = 0;
		UPPER_CASE_LETTERS = new char[26];
		for (char i = 'A'; i <= 'Z'; i = (char) (i + '\001')) {
			UPPER_CASE_LETTERS[(index++)] = i;
		}
		NUMBERS_LETTERS = new char[NUMBERS.length + LOWER_CASE_LETTERS.length
				+ UPPER_CASE_LETTERS.length];
		System.arraycopy(NUMBERS, 0, NUMBERS_LETTERS, 0, NUMBERS.length);
		System.arraycopy(LOWER_CASE_LETTERS, 0, NUMBERS_LETTERS,
				NUMBERS.length, LOWER_CASE_LETTERS.length);
		System.arraycopy(UPPER_CASE_LETTERS, 0, NUMBERS_LETTERS, NUMBERS.length
				+ LOWER_CASE_LETTERS.length, UPPER_CASE_LETTERS.length);

		UPPER_YUAN_NUMBERS = new String[] { "零", "壹", "贰", "叁", "肆", "伍", "陆",
				"柒", "捌", "玖" };
		LOWER_YUAN_NUMBERS = new String[] { "零", "一", "二", "三", "四", "五", "六",
				"七", "八", "九" };

		UPPER_IUNIT = new String[] { "元", "拾", "佰", "仟", "万", "拾", "佰", "仟",
				"亿", "拾", "佰", "仟", "万", "拾", "佰", "仟" };
		LOWER_IUNIT = new String[] { "元", "十", "百", "千", "万", "十", "百", "千",
				"亿", "十", "百", "千", "万", "十", "百", "千" };

		DUNIT = new String[] { "角", "分", "厘" };
	}
}