package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.MovableNumberGenerator;
import view.InputView;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarsTest {
    private static List<Car> racingCars;
    private static List<Car> winners;

    @BeforeEach
    void createCars() {
        final List<Car> cars = new ArrayList<>();

        Car pobiCar = new Car("pobi");
        pobiCar.moveForward(4);

        Car guguCar = new Car("gugu");
        guguCar.moveForward(4);

        Car junCar = new Car("jun");


        cars.add(pobiCar);
        cars.add(guguCar);
        cars.add(junCar);

        racingCars = cars;
    }

    @BeforeEach
    void addWinners() {
        final List<Car> cars = new ArrayList<>();

        Car pobiCar = new Car("pobi");
        pobiCar.moveForward(4);

        Car guguCar = new Car("gugu");
        guguCar.moveForward(4);

        cars.add(pobiCar);
        cars.add(guguCar);

        winners = cars;
    }

    @Test
    @DisplayName("시도 횟수는 숫자여야 한다.")
    void isRoundCountsNumber() {
        final String counts = "5번";
        assertThrows(IllegalArgumentException.class, () -> InputView.parseRoundCounts(counts));
    }

    @Test
    @DisplayName("각 라운드 별 결과를 반환해야 한다.")
    void isValidRoundResult() {
        Cars cars = new Cars(CarsTest.racingCars);
        MovableNumberGenerator movableNumberGenerator = new MovableNumberGenerator();

        cars.updateRaceRound(movableNumberGenerator);
        assertEquals(2, cars.getMaxDistance());
    }

    @Test
    @DisplayName("최종 자동차 경주 우승자 정보를 반환해야 한다.")
    void isValidWinnerResult() {
        Cars cars = new Cars(CarsTest.racingCars);
        int maxDistance = cars.getMaxDistance();

        List<Car> winners = cars.getWinners(maxDistance);
        assertEquals(winners, CarsTest.winners);
    }

    @Test
    @DisplayName("자동차 이름은 중복될 수 없다.")
    void isDuplicatedCarName() {
        List<Car> cars = new ArrayList<>(List.of(new Car("pobi"), new Car("pobi")));
        assertThrows(IllegalArgumentException.class, () -> new Cars(cars));
    }
}
