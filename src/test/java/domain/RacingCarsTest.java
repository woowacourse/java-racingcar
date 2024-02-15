package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarsTest {
    private static List<Car> cars;

    @BeforeEach
    void createCars() {
        cars = new ArrayList<>();
        Car pobiCar = new Car("pobi");
        pobiCar.moveForward(4);

        Car junCar = new Car("jun");
        Car guguCar = new Car("gugu");
        guguCar.moveForward(4);

        cars.add(pobiCar);
        cars.add(junCar);
        cars.add(guguCar);
    }

    @Test
    @DisplayName("시도 횟수는 숫자여야 한다.")
    void isRoundCountsNumber() {
        RacingCars racingCars = new RacingCars(cars);
        String counts = "5번";
        assertThrows(IllegalArgumentException.class, () -> racingCars.startRounds(counts));
    }

    @Test
    @DisplayName("각 라운드 별 결과를 반환해야 한다.")
    void isValidRoundResult() {
        RacingCars racingCars = new RacingCars(cars);
        String roundResult = racingCars.startRounds("1");
        assertThat(roundResult).contains("pobi : -");
    }

    @Test
    @DisplayName("최종 자동차 경주 우승자 정보를 반환해야 한다.")
    void isValidWinnerResult() {
        RacingCars racingCars = new RacingCars(cars);
        assertEquals("pobi, gugu", racingCars.getWinners());
    }

    @Test
    @DisplayName("자동차 이름은 중복될 수 없다.")
    void isDuplicatedCarName() {
        List<Car> cars = new ArrayList<>(List.of(new Car("pobi"), new Car("pobi")));
        assertThrows(IllegalArgumentException.class, () -> new RacingCars(cars));
    }
}