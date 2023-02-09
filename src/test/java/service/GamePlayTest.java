package service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.Car;
import domain.CarRepository;
import domain.Name;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import strategy.FixedMovingStrategy;

class GamePlayTest {

    CarRepository carRepository;
    Map<Car, Integer> carBoard = new HashMap<>();
    Car car = new Car(new Name("kim"));

    @BeforeEach
    void setUp() {
        carBoard.put(car, 0);
        carRepository = new CarRepository(carBoard);
    }

    @DisplayName("지정한 시도 회수만큼 게임이 진행되었는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "4:4", "9:9"}, delimiter = ':')
    void testPlay(int tryTimes, int expected) {
        GamePlay.play(carRepository, tryTimes, new FixedMovingStrategy());
        assertThat(carRepository.getCarBoard().get(car)).isEqualTo(expected);
    }

    @DisplayName("시도회수가 1이상이 아니라면 에러 발생")
    @Test
    void testTryTimesValidation() {
        assertThatThrownBy(
            () -> {
                GamePlay.play(carRepository, 0, new FixedMovingStrategy());
            }
        ).isInstanceOf(IllegalArgumentException.class);
    }
}