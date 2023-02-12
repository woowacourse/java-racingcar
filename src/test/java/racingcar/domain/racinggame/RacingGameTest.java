package racingcar.domain.racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.Car;
import racingcar.domain.racingcars.RacingCars;
import racingcar.domain.numbergenerator.NumberGenerator;
import racingcar.domain.gameresult.GameResult;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 100})
    @DisplayName("자연수인 시도 횟수를 입력하였을 때, 객체가 생성되는지 확인")
    void validate_test(int gameRound) {
        RacingGame racingGame = new RacingGame(gameRound, new NumberGenerator());

        assertThat(racingGame).isInstanceOf(RacingGame.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {-2, -1, 0})
    @DisplayName("자연수가 아닌 시도 횟수를 입력하였을 때, 오류를 발생시키는지 확인")
    void validate_error_test(int gameRound) {
        assertThatThrownBy(() -> new RacingGame(gameRound, new NumberGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 시도 횟수는 0 이하 일 수 없습니다.");
    }


    @ParameterizedTest
    @MethodSource("getCars")
    @DisplayName("GameSystem이 서로 다른 시도 횟수를 가질 때, 자동차 경주의 결과의 개수가 서로 다른지 확인")
    void executeRace_test(List<Car> cars, int smallGameRound, int largeGameRound) {
        RacingCars racingCars = new RacingCars(cars);
        RacingGame smallRacingGame = new RacingGame(smallGameRound, new NumberGenerator());
        RacingGame largeRacingGame = new RacingGame(largeGameRound, new NumberGenerator());

        GameResult gameResult = smallRacingGame.startRace(racingCars);
        GameResult otherGameResult = largeRacingGame.startRace(racingCars);

        assertThat(gameResult.getResults().size()).isNotEqualTo(otherGameResult.getResults().size());
    }

    static Stream<Arguments> getCars() {
        return Stream.of(
                Arguments.arguments(List.of(new Car("poy"), new Car("joy"), new Car("poby")), 1, 5)
        );
    }
}
