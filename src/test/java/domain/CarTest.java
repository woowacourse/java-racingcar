package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    private static Accelerator testMoveForwardAccelerator;
    private static Accelerator testStopAccelerator;

    @BeforeAll
    static void init() {
        testMoveForwardAccelerator = new TestMoveForwardAccelerator();
        testStopAccelerator = new TestStopAccelerator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"p", "po", "poo", "pooo", "poooo"})
    @DisplayName("자동차 이름의 길이가 1 이상 5 이하로 주어지면 자동차가 정상적으로 생성된다")
    void createCarSuccess(String carName) {
        Assertions.assertThatCode(() -> new Car(carName));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "pooobi"})
    @DisplayName("자동차 이름의 길이가 1 미만 5 초과로 주어지면 자동차가 정상적으로 생성되지 않는다")
    void createCarFail(String carName) {
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 null로 주어지면 자동차가 정상적으로 생성되지 않는다")
    void createCarFailWhenInputNull() {
        assertThatThrownBy(() -> new Car(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  ", "   "})
    @DisplayName("자동차 이름이 blank로 주어지면 자동차가 정상적으로 생성되지 않는다")
    void createCarFailWhenInputBlank(String carName) {
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("4 이상 9 이하의 값을 받으면 자동차가 이동한다")
    void moveCar() {
        //given
        Car car = new Car("pobi");
        //when
        car.moveForward(testMoveForwardAccelerator);
        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 2, 3})
    @DisplayName("4 미만의 값을 받으면 자동차가 이동하지 않는다")
    void doNotMoveCar(int power) {
        //given
        Car car = new Car("pobi");
        //when
        car.moveForward(testStopAccelerator);
        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    static class TestMoveForwardAccelerator implements Accelerator {

        static final int MOVE = 4;
        @Override
        public int push() {
            return MOVE;
        }
    }

    static class TestStopAccelerator implements Accelerator {

        static final int MOVE = 3;
        @Override
        public int push() {
            return MOVE;
        }
    }
}