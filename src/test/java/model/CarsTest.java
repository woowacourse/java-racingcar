package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 중복된_자동차가_존재하지_않으면_예외가_발생하지_않는다() {
        // given
        Car car1 = new Car(new Name("pobi"));
        Car car2 = new Car(new Name("crong"));
        Car car3 = new Car(new Name("honux"));
        List<Car> cars = List.of(car1, car2, car3);

        // when & then
        assertDoesNotThrow(() -> new Cars(cars));
    }

    @Test
    void 중복된_자동차가_존재하면_예외가_발생한다() {
        // given
        Car car1 = new Car(new Name("pobi"));
        Car car2 = new Car(new Name("crong"));
        Car car3 = new Car(new Name("pobi"));
        List<Car> cars = List.of(car1, car2, car3);

        // when & then
        assertThatThrownBy(() -> new Cars(cars))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}