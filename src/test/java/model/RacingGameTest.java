package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class RacingGameTest {

    @DisplayName("시도 횟수 입력 값이 자연수가 아닌 경우 예외가 발생하는지 검증한다.")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"+4", "ss", "", "   ", "-1", "3.2", "0"})
    void roundValidationTest(String tryCount) {
        final List<Car> correctNames = List.of(Car.from("good") ,Car.from("yes"));
        final Cars correctCars = Cars.from(correctNames);

        System.out.println(correctCars.getCars());
        assertThatThrownBy(() -> RacingGame.from(correctCars, tryCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
