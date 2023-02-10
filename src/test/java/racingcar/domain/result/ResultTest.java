package racingcar.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @ParameterizedTest
    @MethodSource("getResult")
    @DisplayName("임의로 레이싱 결과를 설정했을 때, 정상적으로 최종 우승자의 이름이 선별되는지 확인")
    void findWinners(List<Map<String, Integer>> sampleResult, Set<String> expectedWinners) {
        Result result = new Result(sampleResult);

        Set<String> actualWinners = result.findWinners();

        assertThat(actualWinners).isEqualTo(expectedWinners);
    }


    static Stream<Arguments> getResult() {
        return Stream.of(
                Arguments.arguments(List.of(Map.of("poy", 5,
                        "joy", 3,
                        "poby", 0)), Set.of("poy")),
                Arguments.arguments(List.of(Map.of("poy", 5,
                        "joy", 5,
                        "poby", 5)), Set.of("poy", "joy", "poby"))
        );
    }
}
