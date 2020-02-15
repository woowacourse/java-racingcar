package application.racing;

import application.racing.domain.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @DisplayName("Car equals 메소드 오버라이드 테스트")
    @Test
    public void carConstructorTest() {
        Car input = new Car("lavin");

        Car expected = new Car("lavin");

        Assertions.assertThat(input).isEqualTo(expected);
    }
}
