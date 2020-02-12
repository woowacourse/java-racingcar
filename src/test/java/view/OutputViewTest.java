package view;

import controller.GameManager;
import model.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {
    @DisplayName("포지션 값만큼 '-' 출력")
    @Test
    void visualizePosition() {
        Car car = new Car("a");
        GameManager.moveOrStay(car, 6);
        GameManager.moveOrStay(car, 6);

        String result = OutputView.printPositionBar(car);
        assertThat(result).isEqualTo("--");
    }
}
