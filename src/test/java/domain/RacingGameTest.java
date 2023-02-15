package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @DisplayName("car1이 우승자로 선정되는 경우")
    @ParameterizedTest
    @CsvSource({
            "3,2",
            "3,1",
            "3,0"
    })
    void test1(int position1, int position2) {
        Car car1 = new Car(Name.of("car1"), Position.of(position1));
        Car car2 = new Car(Name.of("car2"), Position.of(position2));
        Cars cars = new Cars(List.of(car1, car2));
        RacingGame racingGame = new RacingGame(cars, new TryCount(3));

        Cars winners = racingGame.decideWinners();
        assertThat(winners.getCars())
                .containsExactly(car1);
    }

    @DisplayName("car1과 car2가 공동 우승자로 선정되는 경우")
    @ParameterizedTest
    @CsvSource({
            "3,3",
            "2,2",
            "1,1",
            "0,0"
    })
    void test2(int position1, int position2) {
        Car car1 = new Car(Name.of("car1"), Position.of(position1));
        Car car2 = new Car(Name.of("car2"), Position.of(position2));
        Cars cars = new Cars(List.of(car1, car2));
        RacingGame racingGame = new RacingGame(cars, new TryCount(3));

        Cars winners = racingGame.decideWinners();
        assertThat(winners.getCars())
                .containsExactly(car1, car2);
    }
}
