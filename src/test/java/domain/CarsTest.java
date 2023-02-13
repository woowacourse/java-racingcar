package domain;

import static org.assertj.core.api.Assertions.assertThat;

import genertor.FixedNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @DisplayName("생성 전략으로 부터 생성된 숫자가 4 이상일 때, 이동하는지 확인")
    @Test
    void testCycleCars() {
        Cars cars = new Cars(List.of(new Car("lee")));
        cars.moveCars(new FixedNumberGenerator());
        assertThat(cars.getCars().get(0).getPosition()).isEqualTo(1);
    }

    @DisplayName("현재 게임 참여 차량 중 가장 위치값이 높은 n명의 우승자 추출")
    @Test
    void findWinners() {
        Car carLee = new Car("lee");
        Car carKim = new Car("kim");
        Car carPark = new Car("park");
        carKim.move(4);
        carPark.move(4);
        Cars cars = new Cars(List.of(carLee, carKim, carPark));

        assertThat(cars.findWinners()).isEqualTo(List.of(carKim, carPark));
    }
}