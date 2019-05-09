package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    Car testCar;
    Cars carList;
    static String name = "asdf";

    @BeforeEach
    void setup() {
        testCar = new Car(name);
        carList = new Cars();
        carList.addCar(testCar);
    }

    @Test
    void 이름() {
        assertThat(testCar.getName()).isEqualTo(name);
    }

    @Test
    void 위치() {
        assertThat(testCar.getPosition()).isEqualTo(0);

        for (int i = 0; i < 10; i++) {
            testCar.moveForward(carList);
            assertThat(testCar.getPosition()).isEqualTo(i + 1);
        }
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
