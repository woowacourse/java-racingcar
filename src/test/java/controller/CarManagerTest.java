package controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarManager;
import racingcar.domain.CarMovement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarManagerTest {
    @Test
    @DisplayName("자동차들 승리자 구하기 테스트")
    public void getWinnersTest(){
        Car car1 = new Car("푸우");
        Car car2 = new Car("에코");
        Car car3 = new Car("에푸");

        car1.move(new CarMovement(4));
        car2.move(new CarMovement(3));
        car3.move(new CarMovement(4));

        CarManager carManager = new CarManager(List.of(car1,car2,car3));

        assertThat(carManager.getWinners()).containsExactly(car1,car3);
    }
}
