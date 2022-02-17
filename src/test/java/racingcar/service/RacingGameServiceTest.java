package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.vo.Attempt;
import racingcar.domain.vo.Car;
import racingcar.domain.vo.Cars;
import racingcar.domain.vo.RoundResult;

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

        String toString = cars.toString();
        Map<String, Integer> results = stringToMap(toString);

        int maxPosition = results.values().stream().max(Comparator.comparingInt(o -> o)).get();
        List<String> namesByMap = findWinnersByMap(results, maxPosition);
        List<String> namesByCars = winners.stream()
                .map(car -> car.getName().get())
                .collect(Collectors.toList());

        assertThat(Arrays.equals(namesByMap.toArray(), namesByCars.toArray())).isTrue();
        namesByMap.forEach(name -> assertThat(results.get(name)).isEqualTo(maxPosition));
    }

    private Map<String, Integer> stringToMap(String toString) {
        Map<String, Integer> results = new LinkedHashMap<>();
        Arrays.stream(toString.substring(1, toString.length() - 1)
                .split(","))
                .map(s -> s.trim().split(":"))
                .forEach(s -> results.put(s[0], Integer.parseInt(s[1])));
        return results;
    }

    private List<String> findWinnersByMap(Map<String, Integer> results, int maxPosition) {
        return results.keySet().stream()
                .filter(s -> results.get(s) == maxPosition)
                .collect(Collectors.toList());
    }

    private static Stream<Arguments> findWinnersTestSet() {
        return Stream.of(
                Arguments.of(new String[]{"name1", "name2"}, "5"),
                Arguments.of(new String[]{"name3", "name4"}, "3"),
                Arguments.of(new String[]{"name5", "name6"}, "1")
        );
    }
}
