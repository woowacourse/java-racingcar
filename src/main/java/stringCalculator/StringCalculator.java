package stringCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	public String[] splitString(String str) {
		String regex = ",|:";
		Matcher m= Pattern.compile("//(.)\n(.*)").matcher(str);
		if (m.find()){
			regex += "|" + m.group(1);
		}
		return m.group(2).split(regex);
	}
	//https://m.blog.naver.com/bb_/220863282423
	//https://regexr.com/5mhou
}
