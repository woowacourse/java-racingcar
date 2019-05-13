package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @Test
    public void Car_객체_생성시_예외가_제대로_발생하는지_확인한다() {
        String userInput1 = "pobi";
        String userInput2 = "abcdefg";
        String userInput3 = "        ";
        String userInput4 = "";
        String userInput5 = null;

        assertThatCode(() -> {new Car(userInput1);}).doesNotThrowAnyException();
        assertThatThrownBy(() -> {new Car(userInput2);}).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {new Car(userInput3);}).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {new Car(userInput4);}).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {new Car(userInput5);}).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void moveTest() {
        Car car = new Car("pobi");

        car.move(0);
        assertThat(car.matchPosition(0)).isEqualTo(true);

        car.move(3);
        assertThat(car.matchPosition(0)).isEqualTo(true);

        car.move(4);
        assertThat(car.matchPosition(1)).isEqualTo(true);
    }

    @Test
    public void toStringTest() {
        Car car1 = new Car("whale", 0);
        assertThat(car1.toString()).isEqualTo("whale : ");

        Car car2 = new Car("cony", 3);
        assertThat(car2.toString()).isEqualTo("cony : ---");
    }
}
