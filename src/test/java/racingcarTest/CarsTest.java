package racingcarTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private final int intOverRandomCondition = 5;
    private final int intRandomCondition = 4;
    private final int intUnderRandomCondition = 3;

    private void makeCarMoveCountTimes(Car car, int count) {
        for (int i = 0; i < count; i++) {
            car.goForward(intOverRandomCondition);
        }
    }

    @DisplayName("랜덤값이_4이상_일_때_전진")
    @Test
    void randomNum_is4OrOver_carGoForward() {
        Car testCar = new Car("test");

        // 랜덤값이 4일 때 전진
        testCar.goForward(intRandomCondition);
        assertThat(testCar.getPosition()).isEqualTo(1);

        //랜덤값이 5일 때 전진
        testCar.goForward(intOverRandomCondition);
        assertThat(testCar.getPosition()).isEqualTo(2);
    }

    @DisplayName("랜덤값이_4미만_일_때_전진하지_않음")
    @Test
    void randomNum_isUnder4_carDontGoForward() {
        Car testCar = new Car("test");

        // 랜덤값이 3일 때 전진하지 않음
        testCar.goForward(intUnderRandomCondition);
        assertThat(testCar.getPosition()).isEqualTo(0);
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
