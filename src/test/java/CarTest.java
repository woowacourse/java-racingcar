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

    @DisplayName("차량 랜덤 변수 생성 테스트")
    @Test
    void CarTest3() {
        RandomNumberFactory factory = new RandomNumberFactory();

        assertThat(factory.makeRandomNumber()).isBetween(0.0, 10.0);
    }

    @DisplayName("차량 랜덤 변수 삽입 테스트")
    @Test
    void CarTest4() {
        CarFactory factory = new CarFactory();
        GameStarter.carList.forEach(car -> car.setRandomNumber(factory.insertRandomNumber()));

        assertThat(GameStarter.carList.stream()
                .filter(car -> car.getRandomNumber() < 10 && car.getRandomNumber() > 0)
                .collect(Collectors.toList()))
                .isEqualTo(GameStarter.carList);
    }
}
