package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WinnerTest {
    private Winner winner = null;
    private List<Car> testCars = new ArrayList<>();

    @BeforeEach
    void setUp() {
        testCars.add(new Car("a", 1));
        testCars.add(new Car("b", 4));

        winner = new Winner(testCars);
    }

    @Test
    void create() {
        assertThat(new Winner(testCars).equals(new Winner(testCars))).isTrue();
    }

    @Test
    void 우승자목록이_제대로_리턴되는지_테스트() {
        assertThat(winner.getWinner()).isEqualTo("b");
    }

    @Test
    void 우승자가_2명이상일때_제대로_리턴되는지_테스트() {
        testCars.add(new Car("c", 4));
        assertThat(winner.getWinner()).isEqualTo("b,c");
    }


}