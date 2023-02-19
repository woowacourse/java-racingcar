package racingcar.domain.system;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.Car;
import racingcar.domain.cars.Cars;
import racingcar.domain.record.GameRecorder;
import racingcar.domain.result.GameResultOfCar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class GameSystemTest {

    private static final int DEFAULT_POSITION = 0;
    private static final int ENOUGH_POWER_TO_MOVE = 4;
    private static final int DEFAULT_GAME_ROUND = 1;

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 100})
    @DisplayName("생성자에 자연수인 게임 시도 횟수를 입력하였을 때, 오류가 발생하지 않는지 확인")
    void create_test(final int gameRound) {
        assertDoesNotThrow(() -> new GameSystem(gameRound, new GameRecorder(new ArrayList<>())));
    }

    @ParameterizedTest
    @ValueSource(ints = {-2, -1, 0})
    @DisplayName("생성자에 자연수가 아닌 게임 시도 횟수를 입력하였을 때, 오류를 발생시키는지 확인")
    void validate_error_test(final int gameRound) {
        assertThatThrownBy(() -> new GameSystem(gameRound, new GameRecorder(new ArrayList<>())))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @MethodSource("getCarsOnSamePositionAndGameRound")
    @DisplayName("GameSystem 객체가 서로 다른 gameRound를 가질 때, executeRace 실행 시 finalRound의 값과 동일한 횟수만큼 position의 변화가 일어나는지 확인")
    void executeRace_test(final Cars cars, final int gameRound, final int expectedPosition) {
        GameSystem gameSystem = new GameSystem(gameRound, new GameRecorder(new ArrayList<>()));

        gameSystem.executeRace(cars, () -> ENOUGH_POWER_TO_MOVE);

        assertThat(getMaxPosition(gameSystem)).isEqualTo(expectedPosition);
    }

    private int getMaxPosition(final GameSystem gameSystem) {
        List<GameResultOfCar> allGameResult = gameSystem.getAllGameResult();
        return allGameResult.stream()
                .map(GameResultOfCar::getPosition)
                .max(Integer::compareTo)
                .orElse(0);
    }

    @ParameterizedTest
    @MethodSource("getCarsAndWinners")
    @DisplayName("getWinnersGameResult 메소드가 우승 자동차들의 게임결과 객체를 반환하는지 확인")
    void getWinnersGameResult_test(final Cars cars, final List<String> expectedWinnerNames) {
        GameSystem gameSystem = new GameSystem(DEFAULT_GAME_ROUND, new GameRecorder(new ArrayList<>()));
        gameSystem.executeRace(cars, () -> ENOUGH_POWER_TO_MOVE);

        List<GameResultOfCar> winnersGameResult = gameSystem.getWinnersGameResult();

        assertThat(makeWinnerNames(winnersGameResult)).isEqualTo(expectedWinnerNames);
    }

    private List<String> makeWinnerNames(final List<GameResultOfCar> winnersGameResult) {
        return winnersGameResult.stream()
                .map(GameResultOfCar::getCarName)
                .collect(Collectors.toList());
    }


    static Stream<Arguments> getCarsOnSamePositionAndGameRound() {
        return Stream.of(
                Arguments.arguments(new Cars(List.of(new Car("poy", DEFAULT_POSITION), new Car("joy", DEFAULT_POSITION))), 4, 4),
                Arguments.arguments(new Cars(List.of(new Car("poy", DEFAULT_POSITION), new Car("joy", DEFAULT_POSITION))), 5, 5),
                Arguments.arguments(new Cars(List.of(new Car("poy", DEFAULT_POSITION), new Car("joy", DEFAULT_POSITION))), 6, 6)
        );
    }

    static Stream<Arguments> getCarsAndWinners() {
        return Stream.of(
                Arguments.arguments(new Cars(List.of(new Car("poy", DEFAULT_POSITION), new Car("joy", DEFAULT_POSITION))), List.of("poy", "joy")),
                Arguments.arguments(new Cars(List.of(new Car("poy", 1), new Car("joy", DEFAULT_POSITION))), List.of("poy")),
                Arguments.arguments(new Cars(List.of(new Car("poy", DEFAULT_POSITION), new Car("joy", 1))), List.of("joy"))
        );
    }
}
