package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Cars;
import racingcar.utils.ParsingUtils;

public class CarsTest {

    @ParameterizedTest
    @DisplayName("경주할 자동차 이름이 하나인 경우 예외 처리")
    @EmptySource
    @ValueSource(strings = {"한자동차", "자동차#;"})
    void parseCarNamesTest_자동차_입력_수(String input) {
        assertThatThrownBy(() -> {
            ParsingUtils.parseCarNames(input);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차는 두 대 이상 입력해야 합니다.");
    }

    @ParameterizedTest
    @DisplayName("중복되는 경주할 자동차 이름이 있는 경우 예외 처리")
    @ValueSource(strings = {"루트,소롱,루트", "루트,루트,루트"})
    void parseCarNamesTest_중복되는_자동차_입력(String input) {
        assertThatThrownBy(() -> {
            Cars cars = ParsingUtils.parseCarNames(input);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("중복되는 이름을 입력할 수 없습니다.");
    }
}
