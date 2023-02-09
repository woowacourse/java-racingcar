package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class RoundManagerTest {
    @ParameterizedTest
    @MethodSource("전진_결과_데이터")
    @DisplayName("range범위에 따른 전진 결과 테스트")
    public void 전진_결과_테스트(int num, List<String> expected) {
        Range range = new Range(4, 9);
        NumberGenerator numberGenerator = new DefaultNumberGenerator(num);
        AdvanceJudgement advanceJudgement = new AdvanceJudgement(range, numberGenerator);

        RoundManager roundManager = new RoundManager(advanceJudgement);
        roundManager.addRacingCar(new RacingCar("car"));
        Assertions.assertEquals(expected, roundManager.runRound());
    }

    static Stream<Arguments> 전진_결과_데이터() {
        return Stream.of(
                Arguments.of(1, Arrays.asList("car : -")),
                Arguments.of(9, Arrays.asList("car : --"))
        );
    }
}