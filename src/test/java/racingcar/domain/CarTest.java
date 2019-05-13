package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    public void Car_객체_생성시_예외가_제대로_발생하는지_확인한다() {
        String userInput1 = "pobi";
        assertThatCode(() -> new Car(userInput1)).doesNotThrowAnyException();
    }

    @Test
    void 비정상적인_Car객체_생성시_예외발생_확인() {
        String userInput1 = "abcdefg";
        String userInput2 = "        ";
        String userInput3 = "";
        String userInput4 = null;

        assertThatThrownBy(() -> new Car(userInput1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Car(userInput2)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Car(userInput3)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Car(userInput4)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 값에따라_정지하는지_확인() {
        Car car = new Car("pobi");
        car.move(3);
        assertThat(car.matchPosition(0)).isEqualTo(true);
    }

    @Test
    public void 값에따라_이동하는지_확인() {
        Car car = new Car("pobi");
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
