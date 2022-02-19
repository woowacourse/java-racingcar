package racingcar.vo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.numbergenerator.MovableNumberGenerator;
import racingcar.numbergenerator.NumberGenerator;
import racingcar.numbergenerator.UnMovableNumberGenerator;

class CarTest {

    @DisplayName("new CarName() 테스트")
    @Test
    void constructor_test() {
        String name = "name1";
        Car car = new Car(name);
        Car testCar = new Car(name);
        assertThat(car.isSameName(testCar)).isTrue();
    }

    @DisplayName("isSamePosition() 테스트")
    @Test
    void isSamePosition_test() {
        String name = "name1";
        String testName = "name2";
        Car car = new Car(name);
        Car testCar = new Car(testName);
        assertThat(car.isSamePosition(testCar)).isTrue();
    }

    @DisplayName("toString() 테스트")
    @Test
    void toString_test() {
        String name = "name1";
        Car car = new Car(name);
        assertThat(car.toString()).contains(name, " : ");
    }

    @DisplayName("compareTo() 테스트")
    @Test
    void compareTo_test() {
        String name = "name1";
        String testName = "name2";
        CarName carName = new CarName(name);
        CarName testCarName = new CarName(testName);
        Position onePosition = new Position(1);
        Position zeroPosition = new Position(0);
        Car car = new Car(carName, onePosition);
        Car testCar = new Car(testCarName, zeroPosition);
        assertThat(car.compareTo(testCar)).isPositive();
    }

    @DisplayName("move() 움직임 테스트")
    @Test
    void move_with_movableNumber_test() {
        String name = "name1";
        Car car = new Car(name);
        NumberGenerator numberGenerator = new MovableNumberGenerator();
        Car movedCar = car.move(numberGenerator.generate());
        assertThat(car.equals(movedCar)).isFalse();
    }

    @DisplayName("move() 정지 테스트")
    @Test
    void move_with_unMovableNumber_test() {
        String name = "name1";
        Car car = new Car(name);
        NumberGenerator numberGenerator = new UnMovableNumberGenerator();
        Car unMovedCar = car.move(numberGenerator.generate());
        assertThat(car.equals(unMovedCar)).isTrue();
    }
}
