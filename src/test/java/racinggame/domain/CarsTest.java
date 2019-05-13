package racinggame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @Test
    void moveBy_메서드에_의해_차들이_제대로_움직이는지_테스트() {
        /* Given */
        List<String> carNames = Arrays.asList("a", "b", "c");
        List<Car> notMovingExpected = Arrays.asList(new Car("a", 0),
                new Car("b", 0), new Car("c", 0));
        List<Car> movingExpecetd = Arrays.asList(new Car("a", 1),
                new Car("b", 1), new Car("c", 1));

        NumberGenerator notMovingNumberGeneraotr = new ConstantGenerator(3);
        NumberGenerator movingNumberGenerator = new ConstantGenerator(4);

        Cars notMovingCars = new Cars(carNames);
        Cars movingCars = new Cars(carNames);

        /* When */
        notMovingCars.moveBy(notMovingNumberGeneraotr);
        movingCars.moveBy(movingNumberGenerator);

        /* Then */
        assertThat(notMovingCars.equals(notMovingExpected)).isTrue();
        assertThat(movingCars.equals(movingExpecetd)).isTrue();
    }

    @Test
    void trialHistory를_제대로_만드는지_테스트() {
        /* Given */
        List<Car> testCars = Arrays.asList(new Car("a"),
                new Car("b") , new Car("c"));
        TrialHistory testHistory = new TrialHistory(testCars);

        Cars cars = new Cars(Arrays.asList("a", "b", "c"));

        /* Then */
        assertThat(cars.makeTrialHistory()).isEqualTo(testHistory);
    }
}