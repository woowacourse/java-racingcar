package racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static racingcar.Utils.enrollCars;

public class racingCarTest {

    private static Game game;

    @BeforeAll
    public static void init() {
        game = new Game(enrollCars(new String[]{"alan", "bart", "carol"}), 5);
    }

    @Test
    @DisplayName("Car 클래스를 검사")
    void carTest() {
        Car car = new Car("pobi");
    }

    @Test
    @DisplayName("car가 4 이상의 숫자를 받을 때만 전진한다")
    void doesCarProceed() {
        Car car = new Car("hiro");
        for(int i = 0; i <= 3; i++) {
            assertFalse(Utils.checkMove(i));
        }
        for (int i = 4; i <= 9; i++) {
            assertTrue(Utils.checkMove(i));
        }
        assertThat(game.announceWinner().get("hiro")).isEqualTo(6);
    }

    @DisplayName("car의 전진 여부를 결정하는 난수 범위를 체크한다.")
    @ValueSource(ints = {10, -1})
    void randomGeneratorTest(int number) {
        Car car = new Car("hiro");
        Random random = new Random();
        assertThatThrownBy(() -> {
            Utils.checkMove(number);
        }).isInstanceOf(NumberFormatException.class);
    }

    @ParameterizedTest
    @DisplayName("이름의 5자 제한을 체크하는 부분")
    @ValueSource(strings = {"abcdef", ""})
    void checkCarNameException(String name) {
        assertThatThrownBy(() -> {
            Car car = new Car(name);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 1자 이상 5자 이하여야 합니다.");
    }

    @Test
    @DisplayName("Car의 Proceed 테스트")
    void carProceedTest() {
        Car car = new Car("hiro");
        for(int i = 0; i < 4; i++) {
            car.proceed();
        }
        assertThat(car.displayNameAndPosition()[1].equals("4"));
    }
}