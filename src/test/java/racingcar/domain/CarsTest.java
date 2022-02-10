package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.ExceptionMessage;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class CarsTest {

    @Test
    @DisplayName("자동차 이름 간 중복이 있을 경우 예외를 발생시킵니다.")
    void create_duplicatedCarNames() {
        List<String> duplicatedCarNames = Arrays.asList("a", "a", "b");
        assertThatThrownBy(() -> new Cars(duplicatedCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.DUPLICATED_CAR_NAMES);
    }

}