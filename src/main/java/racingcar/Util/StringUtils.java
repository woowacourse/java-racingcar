package racingcar.Util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 클래스 이름 : StringUtils.java
 *
 * @author 보스독
 * @author 작은곰
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020/02/13
 */

public class StringUtils {
	private static final String DELIMITER = ",";

	public static List<String> splitCarNames(String carNameInput) {
		return Arrays.asList(carNameInput.split(DELIMITER));
	}

	public static List<String> trimCarNames(List<String> carNamesInput) {
		return carNamesInput.stream()
				.map(String :: trim)
				.collect(Collectors.toList());
	}

}
