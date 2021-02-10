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
        assertThat(firstCar.getPosition()).isEqualTo(0);
        assertThat(secondCar.getName()).isEqualTo(testNames[1]);
        assertThat(secondCar.getPosition()).isEqualTo(0);
        assertThat(thirdCar.getName()).isEqualTo(testNames[2]);
        assertThat(thirdCar.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 전진 구현")
    void car_move() {
        Car filledCar1 = firstCar.fillUpGas(3);
        Car forwardedCar1 = filledCar1.forward();
        assertThat(forwardedCar1.getPosition()).isEqualTo(0);

        Car filledCar2 = firstCar.fillUpGas(4);
        Car forwardedCar2 = filledCar2.forward();
        assertThat(forwardedCar2.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("우승자 확인")
    void car_winner(){
        Car filledCar = firstCar.fillUpGas(4);
        Car forwardedCar = filledCar.forward();
        assertThat(forwardedCar.isWinner(1)).isTrue();
        assertThat(forwardedCar.isWinner(2)).isFalse();
    }
}
