package racingcar.domain.input.carname.validator;


import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.input.carname.validator.exception.DuplicateCarNamesException;
import racingcar.domain.input.carname.validator.exception.LessThanTwoCarNamesException;

class CarNamesValidatorTest {
    private final CarNamesValidator carNamesValidator = new CarNamesValidator();

    @DisplayName("경주할 자동차 이름이 두 대 이상이어야 하고, 중복되는 이름이 없어야 한다.")
    @Test
    void carNamesTwoOrMore() {
        List<String> carNames = new ArrayList<>();
        carNames.add("111");
        carNames.add("222");
        Assertions.assertThatCode(() -> carNamesValidator.validate(carNames))
            .doesNotThrowAnyException();
    }

    @DisplayName("경주할 자동차 이름이 두 대 미만이면 예외가 발생한다.")
    @Test
    void carNamesLessThanTwoException() {
        List<String> carNames = new ArrayList<>();
        carNames.add("111");
        Assertions.assertThatThrownBy(() -> carNamesValidator.validate(carNames))
            .isInstanceOf(LessThanTwoCarNamesException.class);
    }

    @DisplayName("경주할 자동차 이름들 중에 중복되는 이름이 있으면 예외가 발생한다.")
    @Test
    void carNamesDuplicateException() {
        List<String> carNames = new ArrayList<>();
        carNames.add("111");
        carNames.add("111");
        Assertions.assertThatThrownBy(() -> carNamesValidator.validate(carNames))
            .isInstanceOf(DuplicateCarNamesException.class);
    }
}