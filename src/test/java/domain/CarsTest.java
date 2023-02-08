package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.TestNumberGenerator;

public class CarsTest {

    @Test
    @DisplayName("move 메서드는 모든 자동차들을 이동시킨다.")
    void should_moveCars_when_callMove() {
        NumberGenerator numberGenerator = new TestNumberGenerator(Lists.newArrayList(4, 3, 5));
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        Cars cars = new Cars(List.of(car1, car2, car3));

        cars.move(numberGenerator);

        assertThat(car1.getPosition()).isEqualTo(1);
        assertThat(car2.getPosition()).isEqualTo(0);
        assertThat(car3.getPosition()).isEqualTo(1);
    }

}
