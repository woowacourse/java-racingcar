package racingGame.domain.game;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingGame.domain.racingCar.Car;
import racingGame.domain.racingCar.Cars;
import racingGame.domain.racingCar.Name;

import java.util.Arrays;

public class RacingGameTest {

    @DisplayName("자동차가 한 대 뿐인 경우 게임이 성립하지 않음")
    @Test
    void hasDuplicatedCars() {
        Cars cars = new Cars(Arrays.asList(new Car(Name.create("pobi"))));
        Rounds round = Rounds.create(3);

        assertThatThrownBy(() -> {
            new RacingGame(cars, round);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수가 0인 경우 게임이 성립하지 않음")
    @Test
    void isRoundsZero() {
        Cars cars = new Cars(Arrays.asList(new Car(Name.create("pobi")), new Car(Name.create("corgi"))));
        Rounds round = Rounds.create(0);

        assertThatThrownBy(() -> {
            new RacingGame(cars, round);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차, 시도 횟수가 유효한 경우 RacingGame 정상 생성")
    @Test
    void isValidRacingGame() {
        Cars cars = new Cars(Arrays.asList(new Car(Name.create("pobi")), new Car(Name.create("corgi"))));
        Rounds round = Rounds.create(1);

        new RacingGame(cars, round);
    }
}
