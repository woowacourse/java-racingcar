import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
	public static int calculate(String s) {
		String regex = "";
		Pattern p = Pattern.compile("//(.)\n");
		Matcher matcher = p.matcher(s);
		while (matcher.find()) {
			regex = matcher.group(1);
		}

		if(!regex.equals("")) {
			s = s.substring(4);
		}

		String[] split = s.split("[" + regex + ",:]");
		int result = 0;


		for (int i = 0; i < split.length; i++) {
			result += Integer.parseInt(split[i]);
		}

		return result;
	}
}
