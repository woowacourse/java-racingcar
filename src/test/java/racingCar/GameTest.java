package racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    Game game;

    @BeforeEach
    void setUp() {
        game = new Game("car1,car2", 5);
        game.run();
    }

    @Test
    @DisplayName("올바른 길이의 막대가 생성되는지 테스트")
    void bar() {
        assertThat(game.bar(3)).isEqualTo("---");
    }

    @Test
    @DisplayName("자동차가 생성되는지 테스트")
    void makeCars() {
        String[] carNames = {"car1", "car2"};
        List<Car> cars = game.makeCars(carNames);
        assertThat(cars.get(0).getName()).isEqualTo("car1");
        assertThat(cars.get(1).getName()).isEqualTo("car2");
    }
}
