package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 자동차 이름을 나누는 클래스
 *
 * @version 1.0.0
 * @author K.S.KIM
 * @author HyoChan
 * @since 2020/02/13
 */
public class CarNameSplitter {
    private static final String DELIMETER = ",";

    public static List<Car> split(String input) {
        return Arrays.stream(input.split(DELIMETER))
                .map(String::trim)
                .map(Name::new)
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
