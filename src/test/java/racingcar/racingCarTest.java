package racingcar;

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

public class racingCarTest {
    @Test
    @DisplayName("게임 클래스를 검사")
    void gameTest() {
        Game game = new Game(5);
    }

    @Test
    @DisplayName("Car 클래스를 검사")
    void carTest() {
        Car car = new Car("pobi");
    }

    @Test
    @DisplayName("car가 4 이상의 숫자를 받을 때만 전진한다")
    void doesCarProceed() {
        Game game = new Game(0);
        Car car = new Car("hiro");
        for(int i = 0; i <= 3; i++) {
            assertFalse(game.checkMove(i));
        }
        for (int i = 4; i <= 9; i++) {
            assertTrue(game.checkMove(i));
        }
        assertThat(game.announceWinner().get("hiro")).isEqualTo(6);
    }

    @ParameterizedTest
    @DisplayName("car의 전진 여부를 결정하는 난수 범위를 체크한다.")
    @ValueSource(ints = {10, -1})
    void randomGeneratorTest(int number) {
        Game game = new Game(0);
        Car car = new Car("hiro");
        Random random = new Random();
        assertThatThrownBy(() -> {
            game.checkMove(number);
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
    @DisplayName("자동차 이름을 처리하는 부분")
    void splitCarsNameTest() {
        Game game = new Game(0);
        assertThat(game.spiltCarsName(" alan,bart,carol,daisy ,eddy")
                .equals(new String[]{"alan", "bart", "carol", "daisy", "eddy"}));
    }
}