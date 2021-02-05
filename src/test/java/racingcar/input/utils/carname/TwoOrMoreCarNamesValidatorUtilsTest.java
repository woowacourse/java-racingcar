package racingcar.input.utils.carname;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.input.utils.carname.exception.LessThanTwoCarNamesException;

public class TwoOrMoreCarNamesValidatorUtilsTest {

    @DisplayName("자동차 이름이 2개 이상이면 예외가 발생하지 않는다.")
    @Test
    void twoOrMoreCarNames() {
        List<String> carNames = new ArrayList<>();
        carNames.add("111");
        carNames.add("222");
        assertDoesNotThrow(() -> TwoOrMoreCarNamesValidatorUtils.isTwoOrMoreCarNames(carNames));
    }

    @DisplayName("자동차 이름이 2개 미만이면 예외가 발생한다.")
    @Test
    void invalidLessThanTwoCarNamesException() {
        List<String> carNames = new ArrayList<>();
        carNames.add("111");
        assertThrows(LessThanTwoCarNamesException.class,
            () -> TwoOrMoreCarNamesValidatorUtils.isTwoOrMoreCarNames(carNames));
    }
}
