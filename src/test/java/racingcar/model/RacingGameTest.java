package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingGameTest {

    @DisplayName("경주 횟수가 1 미만 숫자인 경우 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-10000"})
    void exceptionCreateRacingGame(int numberOfRaces) {
        //given
        Cars cars = new Cars(List.of(new Car("a")));

        //when, then
        assertThatThrownBy(() -> new RacingGame(cars, numberOfRaces))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 경주 횟수는 최소 1회 이상 입력해주세요.");
    }

    @DisplayName("게임 횟수 만큼 게임을 실행한다.")
    @Test
    void confirmNumberOfRacesOfRacingGame() {
        //given
        int numberOfRaces = 3;
        Cars cars = new Cars(List.of(new Car("a")));
        RacingGame racingGame = new RacingGame(cars, numberOfRaces);

        //when
        List<RaceResult> raceResults = racingGame.startRace();

        //then
        assertThat(raceResults).hasSize(numberOfRaces);
    }

    @DisplayName("경주의 결과는 등록된 모든 자동차들에게 받는다.")
    @Test
    void confirmRacingResultsOfRacingGame() {
        //given
        int numberOfRaces = 3;
        List<Car> cars = List.of(new Car("a"), new Car("b"));
        RacingGame racingGame = new RacingGame(new Cars(cars), numberOfRaces);

        //when
        List<RaceResult> raceResults = racingGame.startRace();
        int numberOfCars = cars.size();

        //then
        assertThat(raceResults).allMatch(result -> result.getResult().size() == numberOfCars);
    }

    @DisplayName("가장 멀리 전진한 자동차를 우승자로 선정한다.")
    @Test
    void confirmSelectWinner() {
        //given
        Car car1 = new Car("a", 2);
        Car car2 = new Car("b", 0);

        Cars cars = new Cars(List.of(car1, car2));
        RacingGame racingGame = new RacingGame(cars, 1);

        //when
        racingGame.startRace();
        List<Car> winner = racingGame.selectWinner();

        //then
        assertThat(winner).containsExactly(car1);
    }

    @DisplayName("경주를 실행하지 않으면 우승자를 선정할 수 없다.")
    @Test
    void exceptionSelectWinnerWithoutRace() {
        //given
        int numberOfRaces = 1;
        Cars cars = new Cars(List.of(new Car("a")));
        RacingGame racingGame = new RacingGame(cars, numberOfRaces);

        //when, then
        assertThatThrownBy(racingGame::selectWinner)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 경주가 실행되지 않았을때는 우승자를 선정할 수 없습니다.");
    }
}