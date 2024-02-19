package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("자동차")
class CarTest {
    @Test
    @DisplayName("생성에 성공한다.")
    public void createCarTest() {
        //given
        String name = "choco";
        int defaultForward = 0;

        //when
        Car car = new Car(name);

        //then
        assertEquals(car.getName(), name);
        assertEquals(car.getForward(), defaultForward);

    }

    @DisplayName("적절하지 않은 이름은 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"chocochip", "aaaaaa"})
    public void testInvalidName(String name) {
        //given & when & then
        assertThrows(IllegalArgumentException.class, () -> new Car(name));
    }

    @Test
    @DisplayName("멈춘 상태를 출력한다.")
    void printNotForwardStatusTest() {
        //given
        String name = "choco";
        int defaultForward = 0;

        //when
        Car car = new Car(name);

        //then
        assertThat(car.getForward()).isEqualTo(defaultForward);
    }

    @Test
    @DisplayName("전진한 상태를 출력한다.")
    public void printStatusTest() {
        //given
        String name = "choco";
        int defaultForward = 0;
        int movedForward = 1;

        //when
        Car car = new Car(name);
        car.move();

        //then
        assertThat(car.getForward()).isBetween(defaultForward, movedForward);
    }
}
