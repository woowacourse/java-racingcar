package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest {
    static final String nameDefault = "alpha";
    Car testCar;
    Cars cars;

    @BeforeEach
    void setup() {
        testCar = new Car(nameDefault);
        cars = new Cars();
        cars.addCar(testCar);
    }

    @Test
    void 객체생성() {
        Car car = new Car(nameDefault);
        assertThat(car.getName()).isEqualTo(nameDefault);
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
        assertThat(testCar.toString()).isEqualTo(nameDefault + " : ");
        testCar.moveForward();
        assertThat(testCar.toString()).isEqualTo(nameDefault + " : -");
        testCar.moveForward();
        assertThat(testCar.toString()).isEqualTo(nameDefault + " : --");
    }

    @Test
    void 랜덤포워드() {
        assertThat(testCar.toString()).isEqualTo(nameDefault + " : ");
        testCar.randomForward(false);
        assertThat(testCar.toString()).isEqualTo(nameDefault + " : ");
        testCar.randomForward(true);
        assertThat(testCar.toString()).isEqualTo(nameDefault + " : -");
    }

    @Test
    void 투스트링() {
        assertThat(testCar.toString()).isEqualTo(nameDefault + " : ");
        testCar.moveForward();
        testCar.moveForward();
        testCar.moveForward();
        assertThat(testCar.toString()).isEqualTo(nameDefault + " : ---");
    }
}
