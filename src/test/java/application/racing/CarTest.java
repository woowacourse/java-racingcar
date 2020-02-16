package application.racing;

import application.racing.domain.Car;
import application.racing.domain.CarName;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {
    @DisplayName("입력값에 따라서 위치가 변하는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0,0", "3,0", "4,1", "9,1"}, delimiter = ',')
    public void positionMoveValidNumberTest(String input, String expected) {
        Car car = new Car(new CarName("test"));

        car.move(Integer.parseInt(input));
        Assertions.assertThat(car.getPosition()).isEqualTo(Integer.parseInt(expected));
    }

    @DisplayName("Car equals 메소드 오버라이드 테스트")
    @Test
    public void carConstructorTest() {
        Car input = new Car(new CarName("lavin"));

        Car expected = new Car(new CarName("lavin"));

        Assertions.assertThat(input).isEqualTo(expected);
    }
}
