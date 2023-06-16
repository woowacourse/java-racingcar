import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    @DisplayName("차량 리스트 생성 테스트")
    @Test
    void CarTest1() {
        CarFactory carFactory = new CarFactory();
        Car car = new Car();

        carFactory.makeCar(3);

        assertThat(GameStarter.carList.stream()
                .filter(carInList -> carInList.getClass().equals(car.getClass()))
                .collect(Collectors.toList()))
                .isEqualTo(GameStarter.carList);
    }

    @DisplayName("차량 리스트 크기 생성 테스트")
    @Test
    void CarTest2() {
        CarFactory carFactoryForTest = new CarFactory();

        GameStarter.carList.clear();
        carFactoryForTest.makeCar(3);

        assertThat(GameStarter.carList.size()).isEqualTo(3);
    }
}
