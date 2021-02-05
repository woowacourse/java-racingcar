package racingcar.input.utils.carname;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.input.utils.carname.validators.exceptions.DuplicateCarNamesException;
import racingcar.input.utils.carname.validators.CarNamesNotDuplicateValidatorUtils;

public class CarNamesNotDuplicateValidatorUtilsTest {

    @DisplayName("자동차 이름들 중에 중복된 이름이 없을 경우 정상")
    @Test
    void allCarNamesNotDuplicate() {
        List<String> carNames = new ArrayList<>();
        carNames.add("111");
        carNames.add("222");
        carNames.add("333");
        assertThatCode(
            () -> CarNamesNotDuplicateValidatorUtils.validateAllCarNamesNotDuplicate(carNames))
            .doesNotThrowAnyException();

    }

    @DisplayName("자동차 이름들 중에 중복된 이름이 있을 경우 예외 발생")
    @Test
    void allCarNamesDuplicateException() {
        List<String> carNames = new ArrayList<>();
        carNames.add("111");
        carNames.add("222");
        carNames.add("111");
        assertThatThrownBy(
            () -> CarNamesNotDuplicateValidatorUtils.validateAllCarNamesNotDuplicate(carNames))
            .isInstanceOf(DuplicateCarNamesException.class);
    }
}
