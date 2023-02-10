package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.NumberGenerator;
import racingcar.domain.RandomNumberGenerator;

public class CarTest {

    private NumberGenerator numberGenerator = new RandomNumberGenerator();

    @ParameterizedTest
    @ValueSource(strings = {"", "abcdef"})
    @DisplayName("자동차의 이름의 길이가 1이상 5이하가 아니면 오류가 발생한다.")
    void carGenerateTest(String name) {
        //When
        Throwable result = catchThrowable(() -> {
            new Car(name, numberGenerator);
        });

        //Then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:0", "4:1"}, delimiter = ':')
    @DisplayName("자동차의 전진 여부를 판단한다.")
    void goForwardTest(int randomNumber, int expectedResult) {
        //Given
        TestNumberGenerator testNumberGenerator = new TestNumberGenerator(
            new ArrayList<>(List.of(randomNumber)));
        Car car = new Car("pobi", testNumberGenerator);

        //When
        car.goForward();

        //Then
        assertThat(car.getPosition()).isEqualTo(expectedResult);
    }

    static class TestNumberGenerator implements NumberGenerator {

        private final List<Integer> numbers;

        public TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}
