package stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	public String[] splitString(String str) {
		if (str == null || str.length() == 0)
			return new String[] {"0"};
		String regex = ",|:";
		CheckException.checkSplitOk(str, regex);
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(str);
		if (m.find()) {
			regex += "|" + m.group(1);
			CheckException.checkSplitOk(str, regex);
			return m.group(2).split(regex);
		}
		return str.split(regex);
	}

	public int sumString(String[] splitStringArray) {
		int sumResult = 0;
		CheckException.check(splitStringArray);
		for (String s : splitStringArray) {
			sumResult += Integer.parseInt(s);
		}
		return sumResult;
	}
	/*
	^[regex]
	((.)[regex]{2,}(.)*
	$[regex]
	**/
}