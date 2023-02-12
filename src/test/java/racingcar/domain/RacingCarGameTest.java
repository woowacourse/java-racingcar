package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.NumberGenerator.NumberGenerator;
import racingcar.domain.NumberGenerator.TestNumberGenerator;

class RacingCarGameTest {
    @ParameterizedTest
    @MethodSource("전진_결과_데이터")
    @DisplayName("range범위에 따른 전진 결과 테스트")
    public void 전진_결과_테스트(int num, List<String> expected) {
        NumberGenerator numberGenerator = new TestNumberGenerator(num);
        AdvanceJudgement advanceJudgement = new AdvanceJudgement(numberGenerator);
        RacingCarGame racingCarGame = new RacingCarGame(advanceJudgement, RacingCars.generateByNames(List.of("car")));
        assertThat(racingCarGame.runRound()).isEqualTo(expected);
    }

    static Stream<Arguments> 전진_결과_데이터() {
        return Stream.of(
                Arguments.of(1, List.of("car : -")),
                Arguments.of(9, List.of("car : --"))
        );
    }

    @ParameterizedTest
    @MethodSource("위너_결과_데이터")
    @DisplayName("레이싱카의 포지션값에 따른 위너 결과 테스트")
    public void 위너_결과_테스트(List<RacingCar> racingCars, List<String> expected) {
        AdvanceJudgement advanceJudgement = new AdvanceJudgement(new TestNumberGenerator(5));
        RacingCarGame racingCarGame = new RacingCarGame(advanceJudgement, RacingCars.of(racingCars));
        assertThat(racingCarGame.getWinnerNames()).isEqualTo(expected);
    }

    static Stream<Arguments> 위너_결과_데이터() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                new RacingCar("first", 3),
                                new RacingCar("second", 2),
                                new RacingCar("third", 1)
                        ),
                        List.of("first")
                ),
                Arguments.of(
                        List.of(
                                new RacingCar("first1", 2),
                                new RacingCar("first2", 2),
                                new RacingCar("second", 1)
                        ),
                        List.of("first1", "first2"))
        );
    }
}