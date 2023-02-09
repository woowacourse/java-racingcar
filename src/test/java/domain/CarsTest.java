package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.TestNumberGenerator;

public class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        cars = new Cars(List.of(car1, car2, car3));
    }

    @Test
    @DisplayName("move 메서드는 모든 자동차들을 이동시킨다.")
    void should_moveCars_when_move() {
        NumberGenerator numberGenerator = new TestNumberGenerator(Lists.newArrayList(4, 3, 5));

        cars.move(numberGenerator);

        assertThat(cars.getCars())
                .extracting("position")
                .containsExactly(1, 0, 1);
    }

    @Test
    @DisplayName("findWinners 메서드는 우승자 이름 목록을 반환한다.")
    void should_returnWinnersName_when_findWinners() {
        NumberGenerator numberGenerator = new TestNumberGenerator(Lists.newArrayList(4, 3, 5));
        cars.move(numberGenerator);

        List<String> result = cars.findWinners();

        assertThat(result).containsExactly("car1", "car3");
    }
}
