package racingcarTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.MoveStrategy;
import racingcarTest.domain.AlwaysMoveStrategy;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcarTest.domain.NoMoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    private void makeCarMoveCountTimes(Car car, int count) {
        AlwaysMoveStrategy alwaysMoveStrategy = new AlwaysMoveStrategy();
        for (int i = 0; i < count; i++) {
            car.goForward(alwaysMoveStrategy.generateNumber());
        }
    }

    private static Stream<Arguments> moveStrategyArguments() {
        return Stream.of(
                Arguments.of(new AlwaysMoveStrategy(), 1),
                Arguments.of(new NoMoveStrategy(), 0));
    }

    @DisplayName("MoveStrategy에_따른_Cars_전진_실행_여부")
    @ParameterizedTest
    @MethodSource("moveStrategyArguments")
    void moveAll_eachStrategy_makeAllCarMoveOrNot(MoveStrategy moveStrategy, int expectedPosition) {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("dog"));
        carList.add(new Car("cat"));
        carList.add(new Car("bird"));
        carList.add(new Car("mouse"));

        Cars cars = new Cars(carList);
        cars.moveAll(moveStrategy);

        for (Car car : cars.getCars()) {
            assertThat(car.getPosition()).isEqualTo(expectedPosition);
        }
    }

    @DisplayName("단일_우승자_반환")
    @Test
    void cars_hasOneWinner() {
        List<Car> carList = new ArrayList<>();

        // name: dog, position: 5
        Car carDog = new Car("dog");
        makeCarMoveCountTimes(carDog, 5);
        // name:cat, position: 3
        Car carCat = new Car("cat");
        makeCarMoveCountTimes(carCat, 3);
        // name: bird, position: 4
        Car carBird = new Car("bird");
        makeCarMoveCountTimes(carBird, 4);

        carList.add(carDog);
        carList.add(carCat);
        carList.add(carBird);

        // 우승자는 한 명, name은 dog 이어야 한다
        Cars cars = new Cars(carList);
        List<Car> winners = cars.findAllWinners();
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0).getName()).isEqualTo("dog");
    }

    @DisplayName("중복_우승자_반환")
    @Test
    void cars_hasTwoWinner() {
        List<Car> carList = new ArrayList<>();

        // name: dog, position: 5
        Car carDog = new Car("dog");
        makeCarMoveCountTimes(carDog, 5);
        // name:cat, position: 5
        Car carCat = new Car("cat");
        makeCarMoveCountTimes(carCat, 5);
        // name: bird, position: 4
        Car carBird = new Car("bird");
        makeCarMoveCountTimes(carBird, 4);

        carList.add(carDog);
        carList.add(carCat);
        carList.add(carBird);

        // 우승자는 두 명, name은 cat, dog 이어야 한다
        Cars cars = new Cars(carList);
        List<Car> winners = cars.findAllWinners();
        assertThat(winners.size()).isEqualTo(2);
        for (Car winner : winners) {
            Assertions.assertTrue(winner.getName().equals("dog") || winner.getName().equals("cat"));
        }
    }
}
