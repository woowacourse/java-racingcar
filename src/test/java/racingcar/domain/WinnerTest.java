package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WinnerTest {
    List<Car> testCars = new ArrayList<>();

    @BeforeEach
    void setUp() {
        testCars.add(new Car("a", 1));
        testCars.add(new Car("b", 4));
    }

    @Test
    void 우승자가_1명일때_제대로_리턴되는지_테스트() {
        assertThat(Winner.getWinner(testCars)).isEqualTo(Arrays.asList("b"));
    }

    @Test
    void 우승자가_2명이상일때_제대로_리턴되는지_테스트() {
        testCars.add(new Car("c", 4));
        assertThat(Winner.getWinner(testCars)).isEqualTo(Arrays.asList("b", "c"));
    }
}