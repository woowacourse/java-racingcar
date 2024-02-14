package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @DisplayName("자동차 이동 거리 정보를 생성한다.")
    @Test
    void getTotalMovementDetailsTest() {
        Cars cars = new Cars(List.of(new Car("명오"), new Car("배키")));
        cars.moveCars(List.of(5,2));
        cars.moveCars(List.of(6,3));

        String result = cars.getTotalMovementDetails();
        String expected = "명오 : --\n배키 : \n";

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("공동 우승자가 존재하는 경우 ,로 구분하여 반환한다.")
    void findWinnersTest() {
        Cars cars = new Cars(List.of(new Car("명오"), new Car("배키")));
        cars.moveCars(List.of(6,5));
        cars.moveCars(List.of(3,2));

        String result = cars.findWinners();
        String expected = "명오, 배키";

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("1명의 우승자가 존재하는 경우 우승자의 이름을 반환한다.")
    void findWinnerTest() {
        Cars cars = new Cars(List.of(new Car("명오"), new Car("배키")));
        cars.moveCars(List.of(5,2));
        cars.moveCars(List.of(6,3));

        String result = cars.findWinners();
        String expected = "명오";

        assertThat(result).isEqualTo(expected);
    }

}