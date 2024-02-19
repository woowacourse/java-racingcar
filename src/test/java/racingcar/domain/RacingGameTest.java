package racingcar.domain;

import static java.util.Collections.nCopies;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.dto.RoundResult;

class RacingGameTest {

    private static final int REQUIRED_NUMBER_OF_POWER = 4;

    @DisplayName("라운드 만큼 자동차 경주를 진행하고, 각 라운드 별 이동한 거리를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideCarsAndRound")
    void testSimulateCarsInRound(Cars cars, int round) {
        RacingGame racingGame = new RacingGame(cars, new Round(String.valueOf(round)), new CustomNumberOfPower());
        List<RoundResult> roundResults = racingGame.simulateCarsInRound();

        for (int i = 0; i < roundResults.size(); i++) {
            int expectedDistance = i + 1;
            RoundResult roundResult = roundResults.get(i);
            assertTrue(
                    roundResult.getCarPerformances()
                    .stream()
                    .allMatch(carPerformance -> carPerformance.getDistance() == expectedDistance)
            );
        }
    }

    private static Stream<Arguments> provideCarsAndRound() {
        return Stream.of(
                Arguments.of(createCarsWithName(List.of("조조네조", "감쟈감쟈", "조조")), 6),
                Arguments.of(createCarsWithName(List.of("우테코", "들어와서", "너무좋아", "짱")), 3)
        );
    }

    private static Cars createCarsWithName(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(collectingAndThen(toList(), Cars::new));
    }

    static class CustomNumberOfPower implements NumberOfPower {

        @Override
        public List<Integer> generateNumbersOfPower(int size) {
            return nCopies(size, REQUIRED_NUMBER_OF_POWER);
        }
    }
}
