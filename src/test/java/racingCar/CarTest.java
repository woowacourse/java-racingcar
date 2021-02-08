package racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class CarTest {
    private Car car1;
    private Car car2;

    @BeforeEach
    void setUp() {
        car1 = new Car("test");
        car2 = new Car("car2");

        car2.move(4);
        car2.move(5);
    }

    @ParameterizedTest
    @ValueSource(strings={"","banana"})
    void validate(String input) {
        assertThatThrownBy(() -> {
            new Car(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("길이가 1에서 5사이의 이름을 입력해주세요.");
    }

    @ParameterizedTest
    @CsvSource(value={"3:0","4:1"},delimiter=':')
    public void move(int input, int expected) {
        Car car3 = new Car("car3");
        car3.move(input);
        assertThat(car3.getDistance()).isEqualTo(expected);
    }

    @Test
    @DisplayName("우승자의 max 이동거리를 이용하여 우승자인지 확인하는 테스트")
    public void isWinnerTest() {
        assertTrue(car1.isWinner(0));
        assertFalse(car1.isWinner(2));
        assertTrue(car2.isWinner(2));
    }

    @Test
    public void get_name(){
        String name = car1.getName();
        String name2 = car2.getName();

        assertThat(name).isEqualTo("test");
        assertThat(name2).isEqualTo("car2");
    }

    @Test
    public void get_distance(){
        int distance1 = car1.getDistance();
        int distance2 = car2.getDistance();

        assertThat(distance1).isEqualTo(0);
        assertThat(distance2).isEqualTo(2);
    }


}
