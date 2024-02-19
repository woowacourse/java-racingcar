package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    private static final int MIN_POWER = 4;

    @DisplayName("우승자가 1명이다.")
    @Test
    void findWinnerTest() {
        Cars cars = new Cars(List.of("가", "나", "다"));
        String expectedWinner = "나";

        cars.getCars().get(0).move(MIN_POWER);
        cars.getCars().get(1).move(MIN_POWER);
        cars.getCars().get(1).move(MIN_POWER);


        assertThat(Winners.findWinners(cars).getWinners()).containsAll(List.of(expectedWinner));
    }

    @DisplayName("여러명의 우승자가 존재할 수 있다.")
    @Test
    void findWinnersTest() {
        Cars cars = new Cars(List.of("가", "나", "다"));
        List<String> expectedWinners = List.of("가", "다");

        cars.getCars().get(0).move(MIN_POWER);
        cars.getCars().get(0).move(MIN_POWER);
        cars.getCars().get(1).move(MIN_POWER);
        cars.getCars().get(2).move(MIN_POWER);
        cars.getCars().get(2).move(MIN_POWER);

        assertThat(Winners.findWinners(cars).getWinners()).containsAll(expectedWinners);
    }

    @DisplayName("모두가 우승자가 될 수 있다.")
    @Test
    void findWinnersAllTest() {
        Cars cars = new Cars(List.of("가", "나", "다"));
        List<String> expectedWinners = List.of("가", "나", "다");

        cars.getCars().get(0).move(MIN_POWER);
        cars.getCars().get(0).move(MIN_POWER);
        cars.getCars().get(1).move(MIN_POWER);
        cars.getCars().get(1).move(MIN_POWER);
        cars.getCars().get(2).move(MIN_POWER);
        cars.getCars().get(2).move(MIN_POWER);

        assertThat(Winners.findWinners(cars).getWinners()).containsAll(expectedWinners);
    }

}
