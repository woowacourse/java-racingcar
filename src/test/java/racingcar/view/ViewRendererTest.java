package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.dto.RoundResultResponseDTO;
import racingcar.dto.WinnersResponseDTO;

class ViewRendererTest {

    private final ViewRenderer renderer = new ViewRenderer();

    @Test
    @DisplayName("라운드 결과 렌더링 테스트")
    void renderRoundResultTest() {
        Map<String, Integer> roundResults = new LinkedHashMap<>();
        roundResults.put("test1", 3);
        roundResults.put("test2", 1);
        roundResults.put("test3", 5);

        String expectedOutput = "test1 : ---\n" +
            "test2 : -\n" +
            "test3 : -----\n";

        assertThat(renderer.renderRoundResult(new RoundResultResponseDTO(roundResults))).isEqualTo(expectedOutput);
    }

    @Test
    @DisplayName("우승자 결과 렌더링 테스트")
    void renderWinnersTest() {
        List<String> winners = List.of("test1", "test2");

        String expectedOutput = "test1, test2";

        assertThat(renderer.renderWinners(new WinnersResponseDTO(winners))).isEqualTo(expectedOutput);
    }
}