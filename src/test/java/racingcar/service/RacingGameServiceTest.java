package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.vo.Attempt;
import racingcar.domain.vo.Car;
import racingcar.domain.vo.Cars;
import racingcar.dto.RoundResult;

public class RacingGameServiceTest {

    @DisplayName("racing() 테스트")
    @Test
    public void racing_test() {
        String[] nameInput = new String[]{"알린"};
        String attemptInput = "5";
        Cars cars = new Cars(nameInput);
        Attempt attempt = new Attempt("5");
        RacingGameService service = new RacingGameService(cars);
        List<RoundResult> results = service.racing(attempt).getResults();

        assertThat(results).hasSize(Integer.parseInt(attemptInput));
        assertThat(results).allSatisfy(result -> {
            assertThat(result.getNames()).hasSize(nameInput.length);
            assertThat(result.getNames()).contains(nameInput);
        });
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
