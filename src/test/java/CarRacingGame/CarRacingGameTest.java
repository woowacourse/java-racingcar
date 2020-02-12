package CarRacingGame;

import domain.Car;
import domain.RacingCarGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRacingGameTest {

    ArrayList<Car> cars = new ArrayList<>();
    RacingCarGame racingCarGame = new RacingCarGame();

    @ParameterizedTest
    @DisplayName("이름이 올바른지 확인")
    @ValueSource(strings = {"abcdef", ""})
    void validateCorrectName(String name) {
        assertThatThrownBy(() -> {
            Car car = new Car(name);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1자 이상 5자 이하로 해주세요.");
    }

    @Test
    @DisplayName("이름을 입력하지 않은 경우")
    void noNameInput() {
        assertThatThrownBy(() -> {
            Car car = new Car(null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 null값이 될 수 없습니다.");
    }

    @ParameterizedTest
    @DisplayName("자동차가 4,5,6,7,8,9일 때 전진하는지")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void carGo(int random) {
        Car car = new Car("car");
        int originalPosition = car.getPosition();
        car.decideGoOrStop(random);
        assertThat(car.getPosition()).isEqualTo(originalPosition + 1);
    }

    @ParameterizedTest
    @DisplayName("자동차가 0,1,2,3일 때 멈춰있는지")
    @ValueSource(ints = {0, 1, 2, 3})
    void carStop(int random) {
        Car car = new Car("car");
        int originalPosition = car.getPosition();
        car.decideGoOrStop(random);
        assertThat(car.getPosition()).isEqualTo(originalPosition);
    }

    @BeforeEach
    void setUp() {
        cars.add(new Car("car1"));
        cars.add(new Car("car2"));
        cars.add(new Car("car3"));
    }

    @Test
    @DisplayName("우승자의 이름이 제대로 추출되는지")
    void checkWinnerName() {
        cars.get(0).decideGoOrStop(8);
        cars.get(1).decideGoOrStop(1);
        cars.get(2).decideGoOrStop(0);
        assertThat(racingCarGame.getWinner(cars)).isEqualTo("car1");
    }

    @Test
    @DisplayName("우승자가 복수일 때 이름이 제대로 추출되는지")
    void checkWinnersName() {
        cars.get(0).decideGoOrStop(8);
        cars.get(1).decideGoOrStop(5);
        cars.get(2).decideGoOrStop(0);
        assertThat(racingCarGame.getWinner(cars)).isEqualTo("car1, car2");
    }
}
