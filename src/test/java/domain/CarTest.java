package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;


class CarTest {
    private Car car1;
    private Car car2;

    @BeforeEach
    void init() {
        car1 = new Car(Name.of("car1"), Position.create());
        car2 = new Car(Name.of("car2"), Position.create());
    }

    @DisplayName("차를 생성하면 position은 0이다.")
    @Test
    void test1() {
        assertThat(car1.getPosition()).isEqualTo(Position.of(0));
        assertThat(car2.getPosition()).isEqualTo(Position.of(0));
    }


    @DisplayName("차를 move하면 position을 1 증가시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void test2(int value) {
        for (int i = 0; i < value; i++) {
            car1.move(true);
        }
        assertThat(car1.getPosition()).isEqualTo(Position.of(value));
    }
}
