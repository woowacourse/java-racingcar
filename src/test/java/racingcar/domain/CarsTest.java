package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.number.SpecialNumberGenerator;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static racingcar.domain.Cars.ERROR_MESSAGE_OF_DUPLICATED_NAME;

class CarsTest {
    @Test
    @DisplayName("이름 리스트 생성 확인")
    void carNamesCreate() {
        final Cars cars = new Cars("1,2,3");
        assertTrue(cars.toList().containsAll(Arrays.asList(new Car("1"), new Car("2"), new Car("3"))));
    }

    @ParameterizedTest
    @DisplayName("이름이 중복되는 경우")
    @ValueSource(strings = {"1,1,2,3", "1,2,3,2", "1,,2,3", "1,,,,2,3"})
    void carNamesDuplicated() {
        assertThatThrownBy(() -> new Cars("1,1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE_OF_DUPLICATED_NAME);
    }

    @ParameterizedTest
    @DisplayName("양 끝에 쉼표가 있는 경우")
    @ValueSource(strings = {",샐리", "샐리,df,", ",샐리,"})
    void carNamesBothEnd(final String value) {
        assertThatThrownBy(() -> new Cars(value)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("모든 자동차 이동 확인")
    @CsvSource(value = {"4:1", "3:0", "9:1", "1:0"}, delimiter = ':')
    void carsMove(int number, int position) {
        SpecialNumberGenerator numberGenerator = new SpecialNumberGenerator(number);
        Cars cars = new Cars("샐리,현구막,데이브,차자동");
        cars.moveAllCars(numberGenerator);
        assertTrue(cars.toList().stream().allMatch(car -> car.isSamePosition(position)));
    }

    @ParameterizedTest
    @DisplayName("총합테스트")
    @ValueSource(strings = {",", " ", " , ", ", ,  ,"})
    void carNamesCommaBlank(final String value) {
        assertThatThrownBy(() -> new Cars(value)).isInstanceOf(IllegalArgumentException.class);
    }
}