package service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import controller.GamePlay;
import domain.Car;
import domain.Cars;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import genertor.FixedNumberGenerator;

class GamePlayTest {

    Cars cars;
    Car car = new Car("kim");
    GamePlay gamePlay = new GamePlay();

    @BeforeEach
    void setUp() {
        cars = new Cars(List.of(car));

    }

    @DisplayName("지정한 시도 회수만큼 게임이 진행되었는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "4:4", "9:9"}, delimiter = ':')
    void testPlay(int tryTimes, int expected) {
        gamePlay.play(cars, tryTimes, new FixedNumberGenerator());
        assertThat(cars.getCars().get(0).getPosition()).isEqualTo(expected);
    }

    @DisplayName("시도회수가 1이상이 아니라면 에러 발생")
    @Test
    void testTryTimesValidation() {
        assertThatThrownBy(
            () -> {
                gamePlay.play(cars, 0, new FixedNumberGenerator());
            }
        ).isInstanceOf(IllegalArgumentException.class);
    }
}