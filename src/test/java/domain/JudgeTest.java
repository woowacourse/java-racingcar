package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JudgeTest {

    private static final int MIN_FORWARD_NUMBER = 4;

    @DisplayName("우승자가 1명이다.")
    @Test
    void findWinnerTest() {
        Cars cars = new Cars(List.of("가", "나", "다"));

        cars.getCars().get(0).move(MIN_FORWARD_NUMBER);
        cars.getCars().get(1).move(MIN_FORWARD_NUMBER);
        cars.getCars().get(1).move(MIN_FORWARD_NUMBER);

        assertThat(Judge.findWinners(cars)).containsAll(List.of("나"));
    }

    @DisplayName("여러명의 우승자가 존재할 수 있다.")
    @Test
    void findWinnersTest() {
        Cars cars = new Cars(List.of("가", "나", "다"));

        cars.getCars().get(0).move(MIN_FORWARD_NUMBER);
        cars.getCars().get(0).move(MIN_FORWARD_NUMBER);
        cars.getCars().get(1).move(MIN_FORWARD_NUMBER);
        cars.getCars().get(2).move(MIN_FORWARD_NUMBER);
        cars.getCars().get(2).move(MIN_FORWARD_NUMBER);

        assertThat(Judge.findWinners(cars)).containsAll(List.of("가", "다"));
    }

    @DisplayName("모두가 우승자가 될 수 있다.")
    @Test
    void findWinnersAllTest() {
        Cars cars = new Cars(List.of("가", "나", "다"));

        cars.getCars().get(0).move(MIN_FORWARD_NUMBER);
        cars.getCars().get(0).move(MIN_FORWARD_NUMBER);
        cars.getCars().get(1).move(MIN_FORWARD_NUMBER);
        cars.getCars().get(1).move(MIN_FORWARD_NUMBER);
        cars.getCars().get(2).move(MIN_FORWARD_NUMBER);
        cars.getCars().get(2).move(MIN_FORWARD_NUMBER);

        assertThat(Judge.findWinners(cars)).containsAll(List.of("가", "나", "다"));
    }

}
