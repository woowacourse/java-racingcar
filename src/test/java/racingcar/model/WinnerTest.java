package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.GameManager;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WinnerTest {
    private List<Car> cars = new ArrayList<>();

    @BeforeEach
    void setUp() {
        cars.add(new Car("a"));
        cars.add(new Car("b"));
        cars.add(new Car("c"));
        GameManager.moveOrStay(cars.get(0), 9);
        GameManager.moveOrStay(cars.get(0), 9);
        GameManager.moveOrStay(cars.get(1), 9);
        GameManager.moveOrStay(cars.get(1), 9);
        GameManager.moveOrStay(cars.get(1), 9);
    }

    @DisplayName("car 객체들의 최대 포지션 구하기")
    @Test
    void getMaxPosition() {
        int maxPosition = Winner.getMaxPosition(cars);
        assertThat(maxPosition).isEqualTo(3);
    }

    @DisplayName("우승자 Car 객체 리스트 구하기")
    @Test
    void setWinner() {
        List<String> result = new ArrayList<>();
        result.add("b");
        assertThat(Winner.getWinners(cars)).isEqualTo(result);
    }
}
