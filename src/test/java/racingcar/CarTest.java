package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarTest {
    static final String nameDefault = "asdf";
    Car testCar;
    CarList carList;

    @BeforeEach
    void setup() {
        testCar = new Car(nameDefault);
        carList = new CarList();
        carList.addCar(testCar);
    }

    @Test
    void 객체생성() {
        Car car = new Car("abc");
        assertThat(car.getName()).isEqualTo("abc");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 이름길이짧음() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Car("");
        }).withMessage(Car.NAME_IS_EMPTY);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Car(" ");
        }).withMessage(Car.NAME_IS_EMPTY);
    }

    @Test
    void 이름길이초과() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Car("abcdef");
        }).withMessage(Car.NAME_TOO_LONG);
    }

    @Test
    void 이름trim() {
        Car car = new Car(" abcde ");
        assertThat(car.getName()).doesNotContainAnyWhitespaces();
    }

    @Test
    void 위치() {
        assertThat(testCar.getPosition()).isEqualTo(0);
        testCar.moveForward(carList);
        assertThat(testCar.getPosition()).isEqualTo(1);
        testCar.moveForward(carList);
        assertThat(testCar.getPosition()).isEqualTo(2);
    }

    @Test
    void 랜덤포워드() {
        assertThat(testCar.getPosition()).isEqualTo(0);
        testCar.randomForward(false, carList);
        assertThat(testCar.getPosition()).isEqualTo(0);
        testCar.randomForward(true, carList);
        assertThat(testCar.getPosition()).isEqualTo(1);
    }

    @Test
    void 투스트링() {
        assertThat(testCar.toString()).isEqualTo("asdf : ");
        for (int i = 0; i < 3; i++) {
            testCar.moveForward(carList);
        }
        assertThat(testCar.toString()).isEqualTo("asdf : ---");
    }
}
