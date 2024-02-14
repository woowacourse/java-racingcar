package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @DisplayName("자동차 이동 거리 정보를 생성한다.")
    @Test
    void getTotalMovementDetailsTest() {
        Cars cars = new Cars(List.of(new Car("명오", () -> 4), new Car("배키", () -> 3)));
        cars.moveCars();
        cars.moveCars();
        String totalMovementDetails = cars.getTotalMovementDetails();
        assertThat(totalMovementDetails).isEqualTo("명오 : --\n배키 : \n");
    }

    @Test
    @DisplayName("공동 우승자가 존재하는 경우 ,로 구분하여 반환한다.")
    void findWinnersTest() {
        Cars cars = new Cars(List.of(new Car("명오", () -> 4), new Car("배키", () -> 4)));
        cars.moveCars();
        cars.moveCars();
        String winners = cars.findWinners();
        assertThat(winners).isEqualTo("명오, 배키");
    }

    @Test
    @DisplayName("1명의 우승자가 존재하는 경우 우승자의 이름을 반환한다.")
    void findWinnerTest() {
        Cars cars = new Cars(List.of(new Car("명오", () -> 4), new Car("배키", () -> 3)));
        cars.moveCars();
        cars.moveCars();
        String winners = cars.findWinners();
        assertThat(winners).isEqualTo("명오");
    }

}