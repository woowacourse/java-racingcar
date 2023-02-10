package racingcar.domain.result;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @ParameterizedTest
    @MethodSource("getResult")
    void findWinners(List<Map<String, Integer>> sampleResult, List<String> expectedWinners) {
        Result result = new Result(sampleResult);

        List<String> actualWinners = result.findWinners();

        assertThat(actualWinners).containsAll(expectedWinners);
    }

    static Stream<Arguments> getResult() {
        return Stream.of(
                Arguments.arguments(List.of(Map.of("poy", 5,
                        "joy", 3,
                        "poby", 0)), List.of("poy")),
                Arguments.arguments(List.of(Map.of("poy", 5,
                        "joy", 5,
                        "poby", 5)), List.of("poy", "joy", "poby"))
        );
    }
}