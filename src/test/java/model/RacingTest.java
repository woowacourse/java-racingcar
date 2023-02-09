package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @Test
    @DisplayName("자동차 이동 결과 확인")
    void moveAll() {
        Racing racing = new Racing(List.of("pobi", "crong", "honux"), createRandom(4));
        racing.moveAllCars();

        assertThat(racing.toString()).isEqualTo("pobi : -\n"
                + "crong : -\n"
                + "honux : -\n");
    }

    @Test
    @DisplayName("경주 우승자 확인")
    void winner() {
        Racing racing = new Racing(List.of("pobi", "crong", "honux"), createRandom(4));
        racing.moveAllCars();

        assertThat(racing.winner()
                .stream()
                .map(Car::toString)
                .collect(toList()))
                .contains("pobi", "crong", "honux");
    }

    public RandomNumberGenerator createRandom(int returnValue) {
        return new RandomNumberGenerator(new Random() {
            public int nextInt(int bound) {
                return returnValue;
            }
        });
    }
}
