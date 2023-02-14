package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.NotThrownAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.controller.RacingCarController;
import racingcar.dto.CarNamesRequest;
import racingcar.dto.CarStatusResponse;
import racingcar.dto.GameResultResponse;
import racingcar.dto.GameRoundRequest;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameManagerTest {
    GameManager gameManager;

    @BeforeEach
    void setup() {
        gameManager = new GameManager(() -> 4);
    }

    @DisplayName("이름으로 자동차 목록 생성 정상 작동 테스트")
    @ParameterizedTest(name = "input = {0}")
    @MethodSource("carNamesDummy")
    void createCarsTest(List<String> inputCarNames) {
        CarNamesRequest carNamesRequest = new CarNamesRequest(inputCarNames);
        assertDoesNotThrow(() -> gameManager.createCars(carNamesRequest));
    }

    @DisplayName("게임 라운드 생성 정상 작동 테스트")
    @ParameterizedTest(name = "input = {0}")
    @ValueSource(ints = {2, 10, 100})
    void createGameRoundTest(int inputGameRound) {
        GameRoundRequest gameRoundRequest = new GameRoundRequest(inputGameRound);
        assertDoesNotThrow(() -> gameManager.createGameRound(gameRoundRequest));
    }

    @DisplayName("라운드 진행 후 라운드 상태 반환 테스트")
    @Test
    void playGameRoundTest() {
        gameManager.createCars(new CarNamesRequest(List.of("가가", "나나", "다다")));
        gameManager.createGameRound(new GameRoundRequest(5));
        List<CarStatusResponse> carStatusResponses = gameManager.playGameRound();
        assertThat(carStatusResponses).hasSize(3);
    }

    @DisplayName("모든 라운드 진행 후 끝났는지 확인하는 테스트")
    @Test
    void isEndTest() {
        gameManager.createCars(new CarNamesRequest(List.of("가가", "나나", "다다")));
        gameManager.createGameRound(new GameRoundRequest(5));
        for (int round = 0; round < 5; round++) {
            gameManager.playGameRound();
        }
        assertThat(gameManager.isEnd()).isTrue();
    }

    @DisplayName("같은 숫자를 계속 반환하여  모두가 우승자인 테스트")
    @Test
    void decideWinnerTest() {
        gameManager.createCars(new CarNamesRequest(List.of("가가", "나나", "다다")));
        gameManager.createGameRound(new GameRoundRequest(5));
        for (int round = 0; round < 5; round++) {
            gameManager.playGameRound();
        }
        GameResultResponse gameResultResponse = gameManager.decideWinner();
        assertThat(gameResultResponse.getWinnerNames()).containsExactly("가가", "나나", "다다");
    }

    static Stream<Arguments> carNamesDummy() {
        return Stream.of(
                Arguments.of(List.of("가가", "나나", "다다")),
                Arguments.of(List.of("11", "22", "33")),
                Arguments.of(List.of("aa", "bb", "cc"))
        );
    }
}
