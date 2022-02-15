package racingcar.vo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.numberGenerator.MovableNumberGenerator;
import racingcar.numberGenerator.NumberGenerator;
import racingcar.numberGenerator.UnMovableNumberGenerator;

public class CarTest {

    @DisplayName("new CarName() 테스트")
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
        String name = "name1";
        String testName = "name2";
        CarName carName = new CarName(name);
        CarName testCarName = new CarName(testName);
        Car car = new Car(carName);
        Car testCar = new Car(testCarName);
        assertThat(car.isSamePosition(testCar)).isTrue();
    }

    @DisplayName("toString() 테스트")
    @Test
    public void toString_test() throws Exception {
        String name = "name1";
        CarName carName = new CarName(name);
        Car car = new Car(carName);
        assertThat(car.toString()).contains(name, " : ");
    }

    @DisplayName("compareTo() 테스트")
    @Test
    public void compareTo_test() throws Exception {
        String name = "name1";
        String testName = "name2";
        CarName carName = new CarName(name);
        CarName testCarName = new CarName(testName);
        Position onePosition = new Position(1);
        Position zeroPosition = new Position(0);
        Car car = new Car(carName, onePosition);
        Car testCar = new Car(testCarName, zeroPosition);
        assertThat(car.compareTo(testCar)).isGreaterThan(0);
    }

    @DisplayName("move() 움직임 테스트")
    @Test
    public void move_with_movableNumber_test() throws Exception {
        String name = "name1";
        CarName carName = new CarName(name);
        Position zeroPosition = new Position(0);
        Car car = new Car(carName, zeroPosition);
        NumberGenerator numberGenerator = new MovableNumberGenerator();
        Car movedCar = car.move(numberGenerator.generate());
        assertThat(movedCar.compareTo(car)).isGreaterThan(0);
    }

    @DisplayName("move() 정지 테스트")
    @Test
    public void move_with_unMovableNumber_test() throws Exception {
        String name = "name1";
        CarName carName = new CarName(name);
        Position zeroPosition = new Position(0);
        Car car = new Car(carName, zeroPosition);
        NumberGenerator numberGenerator = new UnMovableNumberGenerator();
        Car movedCar = car.move(numberGenerator.generate());
        assertThat(movedCar.compareTo(car)).isEqualTo(0);
    }
}
