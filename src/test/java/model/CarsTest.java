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

}