package racingcargame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    Cars cars;

    @BeforeEach
    void setUp() {
        List<Car> rawCars = new ArrayList<>();
        rawCars.add(new Car("car1"));
        rawCars.add(new Car("car2"));
        rawCars.add(new Car("car3"));
        cars = new Cars(rawCars);
        cars.getCars().get(1).move(4);
        cars.getCars().get(2).move(4);
    }

    @Test
    @DisplayName("우승자의 이름을 잘 가져오는지 테스트")
    void getWinnerNames() {
        List<Car> winners = cars.winners();
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0).getName()).isEqualTo("car2");
        assertThat(winners.get(1).getName()).isEqualTo("car3");
        cars.getCars().get(2).move(4);
        winners = cars.winners();
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0).getName()).isEqualTo("car3");
    }
}
