package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("공동 우승자가 존재하는 경우 공동 우승자 모두를 반환한다.")
    void findWinnersTest() {
        Car myungOh = new Car("명오");
        Car baeky = new Car("배키");
        Cars cars = new Cars(List.of(myungOh, baeky));
        myungOh.move(true);
        baeky.move(true);
        List<Car> result = cars.findWinners();
        List<Car> expected = List.of(myungOh, baeky);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("1명의 우승자가 존재하는 경우 우승자를 반환한다.")
    void findWinnerTest() {
        Car myungOh = new Car("명오");
        Car baeky = new Car("배키");
        Cars cars = new Cars(List.of(myungOh, baeky));
        myungOh.move(true);
        baeky.move(false);
        List<Car> result = cars.findWinners();
        List<Car> expected = List.of(myungOh);


        assertThat(result).isEqualTo(expected);
    }
}
