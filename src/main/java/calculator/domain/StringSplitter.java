package calculator.domain;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 계산 클래스
 *
 * @version 1.0.0
 * @author K.S.KIM
 * @author HyoChan
 * @since 2020/02/11
 */
public class StringSplitter {
	public static final String DELIMITER = ",|:";
	public static final String OR = "|";
	public static final int DELIMITER_POSITION = 1;
	public static final int EXPRESSION_POSITION = 2;
	public static final String CUSTOM_DELIMITER_PATTERN = "//(.)\\n(.*)";
	public static final String INVALID_INPUT_MESSAGE = "유효한 입력이 아니다.";

	public static List<Operand> splitByDelimiter(String input) {
		String delimiter = DELIMITER;
		Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
		if (matcher.find()) {
			delimiter += OR + matcher.group(DELIMITER_POSITION);
			input = matcher.group(EXPRESSION_POSITION);
		}
		return Stream.of(input.split(delimiter))
				.map(Operand::valueOf)
				.collect(Collectors.toList());
	}
}
