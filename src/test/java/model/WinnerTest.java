package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {

    private Winner winner;
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        winner = new Winner();
        cars = new ArrayList<>();
        cars.add(new Car("a"));
        cars.add(new Car("b"));
        cars.add(new Car("c"));
        cars.get(0).position.move(4);
        cars.get(0).position.move(4);
        cars.get(1).position.move(4);
        cars.get(1).position.move(4);
    }

    @Test
    @DisplayName("우승자의(최대의) 포지션 구하기")
    void getMaxPosition() {
        assertThat(winner.getMaxPosition(cars)).isEqualTo(2);
    }

    @DisplayName("우승자 Car 객체 리스트 구하기")
    @Test
    void getWinner() {
        List<String> result = new ArrayList<>();
        result.add("a");
        result.add("b");
        winner.determineWinners(cars);
        assertThat(winner.getWinners()).isEqualTo(result);
    }
}
