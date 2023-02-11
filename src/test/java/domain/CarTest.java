package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @DisplayName("자동차 이름의 길이가 1~5글자가 아니거나, null 이라면 예외를 던진다")
    @ParameterizedTest
    @CsvSource(value = {"''", "abcdef", "abcdefgh", "null"}, nullValues = "null")
    void should_ThrowIllegalArgumentException_When_NameIsInvalid(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("자동차 이름의 길이가 1~5글자라면 예외를 던지지 않는다")
    @ParameterizedTest
    @CsvSource({"a", "abc", "abcde"})
    void should_DoesNotThrowException_When_NameIsValid(String name) {
        assertThatCode(() -> new Car(name))
                .doesNotThrowAnyException();
    }

    @DisplayName("0 ~ 3의 값일때는 움직이지 않는다.")
    @ParameterizedTest
    @CsvSource({"0, 0", "1, 0", "2, 0", "3, 0"})
    void should_Stay_When_NumberIsZeroToThree(int number, int position) {
        //given
        Car car = new Car("test");

        //when
        car.move(number);

        //then
        assertThat(car.getPosition()).isEqualTo(position);
    }

    @DisplayName("4 ~ 9의 값일때는 움직인다.")
    @ParameterizedTest
    @CsvSource({"4, 1", "5, 1", "6, 1", "7, 1", "8, 1", "9, 1"})
    void should_Move_When_NumberIsFourToNine(int number, int position) {
        //given
        Car car = new Car("test");

        //when
        car.move(number);

        //then
        assertThat(car.getPosition()).isEqualTo(position);
    }
}
