package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @Test
    public void Car_객체_생성이_잘_되는지_확인한다() {
        String correctName = "pobi";
        assertThatCode(() -> {new Car(correctName);}).doesNotThrowAnyException();
    }

    @Test
    public void 이름이_길_때_예외가_제대로_발생하는지_확인한다() {
        String wrongName = "abcdefg";
        assertThatThrownBy(() -> {new Car(wrongName);}).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 공백만_있을_때_예외가_제대로_발생하는지_확인한다() {
        String wrongName = "        ";
        assertThatThrownBy(() -> {new Car(wrongName);}).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 문자열이_비었을_때_예외가_제대로_발생하는지_확인한다() {
        String wrongName = "";
        assertThatThrownBy(() -> {new Car(wrongName);}).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 이름이_null일_때_예외가_제대로_발생하는지_확인한다() {
        String wrongName = null;
        assertThatThrownBy(() -> {new Car(wrongName);}).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 이동해야_할_때_이동하는지_확인한다() {
        Car car = new Car("pobi");

        car.move(4);
        assertThat(car.matchPosition(1)).isEqualTo(true);
    }

    @Test
    public void 이동하지_않아야_할_때_이동하지_않는지_확인한다() {
        Car car = new Car("pobi");

        car.move(0);
        assertThat(car.matchPosition(0)).isEqualTo(true);

        car.move(3);
        assertThat(car.matchPosition(0)).isEqualTo(true);
    }
}
