package racingcar.view;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ViewRendererTest {

    private ViewRenderer renderer = new ViewRenderer();

    @Test
    void renderRoundResultTest() {
        Map<String, Integer> roundResults = new LinkedHashMap<>();
        roundResults.put("test1", 3);
        roundResults.put("test2", 1);
        roundResults.put("test3", 5);

        String expectedOutput = "test1 : ---\n" +
                "test2 : -\n" +
                "test3 : -----\n\n";

        assertThat(renderer.renderRoundResult(roundResults)).isEqualTo(expectedOutput);
    }

    @Test
    void renderWinnersTest() {
    }
}