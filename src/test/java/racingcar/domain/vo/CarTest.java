package racingcar.domain.vo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.strategy.MovableNumberGenerator;
import racingcar.strategy.NonMovableNumberGenerator;

public class CarTest {

    @DisplayName("CarName() 테스트")
    @Test
    public void constructor_test() throws Exception {
        String name = "name1";
        CarName carName = new CarName(name);
        Car car = new Car(carName);
        Car testCar = new Car(carName);
        assertThat(car.isSameName(testCar)).isTrue();
    }

    @DisplayName("isSamePosition() 테스트")
    @Test
    public void isSamePosition_test() throws Exception {
        CarName carName1 = new CarName("name1");
        CarName carName2 = new CarName("name2");
        CarName moveCarName = new CarName("name3");
        Car car1 = new Car(carName1);
        Car car2 = new Car(carName2);
        Car moveCar = new Car(moveCarName);
        MovableNumberGenerator generator = new MovableNumberGenerator();
        moveCar.move(generator.generate());
        assertThat(car1.isSamePosition(car2)).isTrue();
        assertThat(car1.isSamePosition(moveCar)).isFalse();
        assertThat(car2.isSamePosition(moveCar)).isFalse();
    }

    @DisplayName("compareTo() 테스트")
    @Test
    public void compareTo_test() throws Exception {
        Car carPositionZero = new Car(new CarName("name1"));
        Car carPositionOne = new Car(new CarName("name2"));
        MovableNumberGenerator generator = new MovableNumberGenerator();
        carPositionOne.move(generator.generate());
        assertThat(carPositionZero.compareTo(carPositionZero)).isEqualTo(0);
        assertThat(carPositionZero.compareTo(carPositionOne)).isLessThan(0);
        assertThat(carPositionOne.compareTo(carPositionZero)).isGreaterThan(0);
    }

    @DisplayName("move() 이동이 성공하는 테스트")
    @Test
    public void move_success_test() throws Exception {
        String name = "name1";
        CarName carName = new CarName(name);
        Car car = new Car(carName);
        MovableNumberGenerator movable = new MovableNumberGenerator();
        car.move(movable.generate());
        assertThat(car).extracting("position").extracting("position").isEqualTo(1);
    }

    @DisplayName("move() 이동이 실패하는 테스트")
    @Test
    public void move_fail_test() throws Exception {
        String name = "name1";
        CarName carName = new CarName(name);
        Car car = new Car(carName);
        NonMovableNumberGenerator movable = new NonMovableNumberGenerator();
        car.move(movable.generate());
        assertThat(car).extracting("position").extracting("position").isEqualTo(0);
    }
}
