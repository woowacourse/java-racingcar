package model;

import static fixture.CarFixture.자동차;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 중복된_자동차가_존재하지_않으면_예외가_발생하지_않는다() {
        // given

        Car car1 = 자동차("pobi");
        Car car2 = 자동차("crong");
        Car car3 = 자동차("honux");
        List<Car> cars = List.of(car1, car2, car3);

        // when & then
        assertDoesNotThrow(() -> new Cars(cars));
    }

    @Test
    void 중복된_자동차가_존재하면_예외가_발생한다() {
        // given
        Car car1 = 자동차("pobi");
        Car car2 = 자동차("pobi");
        Car car3 = 자동차("honux");
        List<Car> cars = List.of(car1, car2, car3);

        // when & then
        assertThatThrownBy(() -> new Cars(cars))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름의 자동차가 존재합니다.");
    }

    @Test
    void 가장_많이_전진한_자동차들을_반환한다() {
        // given
        Car car1 = 자동차("pobi");
        Car car2 = 자동차("crong");
        List<Car> cars = List.of(car1, car2);
        Cars racingCars = new Cars(cars);
        car1.moveForward();
        // when
        List<String> winners = racingCars.getWinners();

        // then
        assertEquals(winners.get(0), "pobi");
    }
}
