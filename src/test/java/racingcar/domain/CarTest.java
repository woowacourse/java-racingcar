package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @DisplayName("주어진 숫자에 따라 자동차가 움직이는지 테스트")
    @ParameterizedTest
    @CsvSource({"2, false", "3,false", "4,true", "5,true"})
    void 자동차가_움직이는지(int given, boolean result) {
        Car car = new Car("TEST");
        car.move(given);

        assertThat(car.getPosition().index() == 1).isEqualTo(result);
    }

    @DisplayName("전진 조건이 변경되는지 확인")
    @Test
    void 자동차_이동조건_변경_테스트(){
        Car car = new Car("TEST");

        car.changeMovableCondition(i -> i > 10);
        car.move(5);
        int expectZero = car.getPosition().index();

        car.move(11);
        int expectOne = car.getPosition().index();

        car.changeMovableCondition(i -> i > 4);
        car.move(5);
        int expectTwo = car.getPosition().index();

        assertThat(expectZero).isEqualTo(0);
        assertThat(expectOne).isEqualTo(1);
        assertThat(expectTwo).isEqualTo(2);
    }
}
