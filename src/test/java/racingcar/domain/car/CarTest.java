package racingcar.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    private String[] testNames;
    private Car firstCar;
    private Car secondCar;
    private Car thirdCar;

    @BeforeEach
    void setUp() {
        testNames = new String[]{"샐리", "현구막", "휴"};
        firstCar = Car.enrollWithName(testNames[0]);
        secondCar = Car.enrollWithName(testNames[1]);
        thirdCar = Car.enrollWithName(testNames[2]);
    }

    @Test
    @DisplayName("자동차 생성 확인")
    void car_create() {
        assertThat(firstCar.getName()).isEqualTo(testNames[0]);
        assertThat(firstCar.getPosition().length()).isEqualTo(0);
        assertThat(secondCar.getName()).isEqualTo(testNames[1]);
        assertThat(secondCar.getPosition().length()).isEqualTo(0);
        assertThat(thirdCar.getName()).isEqualTo(testNames[2]);
        assertThat(thirdCar.getPosition().length()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 전진 구현")
    void car_move() {
        firstCar.fillUpGas(4);
        firstCar.forward();
        assertThat(firstCar.getPosition().length()).isEqualTo(1);

        secondCar.fillUpGas(3);
        secondCar.forward();
        assertThat(secondCar.getPosition().length()).isEqualTo(0);
    }
}
