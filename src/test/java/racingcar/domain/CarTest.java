package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CarTest {

    @Test
    void 이름의_길이가_기준치에_맞지않으면_예외발생하는지_검사() {
        String name = "banana";

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            Car car = new Car(name);
        });
    }

    @Test
    void 이름이_빈_칸일_경우_예외발생하는지_검사() {
        String name1 = "";
        String name2 = " ";

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            Car car = new Car(name1);
        });

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            Car car = new Car(name2);
        });
    }
}