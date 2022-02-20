package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.vo.Attempt;
import racingcar.domain.vo.Car;
import racingcar.domain.fcc.Cars;
import racingcar.dto.RoundResult;
import racingcar.strategy.MovableNumberGenerator;
import racingcar.strategy.NonMovableNumberGenerator;

public class RacingGameServiceTest {

    @ParameterizedTest(name = "racing() 테스트 : {0}, {1}")
    @MethodSource("racingTestSet")
    public void racing_test(
            String[] nameInput,
            String attemptInput,
            List<List<Integer>> testSet,
            List<Integer> positionResult
    ) {
        Cars cars = new Cars(nameInput);
        Attempt attempt = new Attempt(attemptInput);
        RacingGameService service = new RacingGameService(cars);
        List<RoundResult> results = service.racing(attempt, testSet).getResults();

        assertThat(results).hasSize(Integer.parseInt(attemptInput));
        assertThat(results).allSatisfy(result -> {
            Set<String> names = result.getNames();
            assertThat(names).hasSize(nameInput.length);
            assertThat(names).contains(nameInput);
            names.forEach(name ->
                    assertThat(result.getPosition(name)).isEqualTo(positionResult.remove(0)));
        });
    }

    private static Stream<Arguments> racingTestSet() {
        MovableNumberGenerator movableNumberGenerator = new MovableNumberGenerator();
        NonMovableNumberGenerator nonMovableNumberGenerator = new NonMovableNumberGenerator();
        int move = movableNumberGenerator.generate();
        int stop = nonMovableNumberGenerator.generate();
        List<Integer> numbers = new ArrayList<>(Arrays.asList(move, stop));
        List<List<Integer>> testSet5 = new ArrayList<>(Arrays.asList(numbers, numbers, numbers, numbers, numbers));
        List<List<Integer>> testSet3 = new ArrayList<>(Arrays.asList(numbers, numbers, numbers));
        List<List<Integer>> testSet1 = new ArrayList<>(Arrays.asList(numbers));
        List<Integer> positionResult5 = new ArrayList<>(Arrays.asList(1, 0, 2, 0, 3, 0, 4, 0, 5, 0));
        List<Integer> positionResult3 = new ArrayList<>(Arrays.asList(1, 0, 2, 0, 3, 0));
        List<Integer> positionResult1 = new ArrayList<>(Arrays.asList(1, 0));
        return Stream.of(
                Arguments.of(new String[]{"name1", "name2"}, "5", testSet5, positionResult5),
                Arguments.of(new String[]{"name3", "name4"}, "3", testSet3, positionResult3),
                Arguments.of(new String[]{"name5", "name6"}, "1", testSet1, positionResult1)
        );
    }

    @ParameterizedTest(name = "findWinners() 테스트 : {0}, {1}")
    @MethodSource("findWinnersTestSet")
    public void findWinners_test(String[] nameInput, String attemptInput) throws Exception {
        Cars cars = new Cars(nameInput);
        Attempt attempt = new Attempt(attemptInput);
        cars.repeatRaceBy(attempt);
        RacingGameService service = new RacingGameService(cars);
        List<Car> winners = service.findWinners().getWinners();

        int position = winners.get(0).getPosition().get();

        assertThat(winners).allSatisfy(car ->
                assertThat(car.getPosition().get()).isEqualTo(position));
    }

    private static Stream<Arguments> findWinnersTestSet() {
        return Stream.of(
                Arguments.of(new String[]{"name1", "name2"}, "5"),
                Arguments.of(new String[]{"name3", "name4"}, "3"),
                Arguments.of(new String[]{"name5", "name6"}, "1")
        );
    }
}
