package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("정상적인 Cars 객체 생성")
    void createCars() {
        assertDoesNotThrow(() -> new Cars("pobi,crong,honux"));
    }

    @Test
    @DisplayName("겹치는 자동차 이름이 존재하면 예외")
    void createCarsWithDuplicateName() {
        assertThatThrownBy(() -> new Cars("pobi, pobi"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("우승자를 찾습니다.")
    void findWinner() {
        Cars cars = new Cars("dodo, jery, coli");
        List<Car> expectedWinner = List.of(new Car("dodo"));

        cars.getCars().get(0).moveByNumber(5);
        List<Car> actualWinners = cars.findWinners();

        assertEquals(expectedWinner.get(0).getName(),actualWinners.get(0).getName());
    }

    @Test
    @DisplayName("공동 우승자를 찾습니다.")
    void findWinners() {
        Cars cars = new Cars("dodo, jery, coli");

        Car dodo = cars.getCars().get(0);
        Car coli = cars.getCars().get(2);
        dodo.moveByNumber(5);
        coli.moveByNumber(5);
        List<Car> actualWinners = cars.findWinners();

        assertThat(actualWinners).containsExactly(dodo,coli);
    }
}