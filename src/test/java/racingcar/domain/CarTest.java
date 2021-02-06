package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {

    @DisplayName("주어진 숫자에 따라 자동차가 움직이는지 테스트")
    @ParameterizedTest
    @CsvSource({"2, false","3,false", "4,true", "5,true"})
    void 자동차가_움직이는지(int given, boolean result){
        Car car = new Car("TEST");
        car.move(given);

        assertThat(car.getPosition() == 1).isEqualTo(result);
    }
}
