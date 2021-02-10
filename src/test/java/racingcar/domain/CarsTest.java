package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static racingcar.domain.Cars.ERROR_MESSAGE_OF_DUPLICATED_NAME;

class CarsTest {
    @Test
    @DisplayName("이름 리스트 생성 확인")
    void carNames() {
        final Cars cars = new Cars("1,2,3");
        assertTrue(cars.toList().containsAll(Arrays.asList(new Car("1"), new Car("2"), new Car("3"))));
    }

    @ParameterizedTest
    @DisplayName("이름이 중복되는 경우")
    @ValueSource(strings = {"1,1,2,3", "1,2,3,2", "1,,2,3", "1,,,,2,3"})
    void carNames_duplicated() {
        assertThatThrownBy(() -> new Cars("1,1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE_OF_DUPLICATED_NAME);
    }

    @ParameterizedTest
    @DisplayName("양 끝에 쉼표가 있는 경우")
    @ValueSource(strings = {",샐리", "샐리,df,", ",샐리,"})
    void carNames_both_end(final String value) {
        assertThatThrownBy(() -> new Cars(value)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("총합테스트")
    @ValueSource(strings = {",", " ", " , ", ", ,  ,"})
    void carNames_comma_blank(final String value) {
        assertThatThrownBy(() -> new Cars(value)).isInstanceOf(IllegalArgumentException.class);
    }
}