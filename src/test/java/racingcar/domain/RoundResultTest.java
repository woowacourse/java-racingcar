package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class RoundResultTest {
    @Test
    void createTest1() {
        assertThat(new RoundResult(new ArrayList<>(Arrays.asList(new Car("A", 3))))
                .equals(new RoundResult(new ArrayList<>(Arrays.asList(new Car("A", 3)))))
        ).isTrue();
    }

    @Test
    void createTest2() {
        assertThat(new RoundResult(new ArrayList<>(Arrays.asList(new Car("A", 3))))
                .equals(new RoundResult(new ArrayList<>(Arrays.asList(new Car("B", 3)))))
        ).isFalse();
    }

    @Test
    void getFormattedRoundResultTest() {
        RoundResult roundResult = new RoundResult(new ArrayList<>(
                Arrays.asList(new Car("A", 1), new Car("B", 2))
        ));
        assertThat(roundResult.getFormattedRoundResult().equals("A : -\nB : --\n")).isTrue();
    }

    @Test
    void drawPositionLineTest() {
        assertThat(RoundResult.drawPositionLine(3)).isEqualTo("---");
    }

    @Test
    void getWinnersTest() {
        RoundResult roundResult = new RoundResult(new ArrayList<>(
                Arrays.asList(
                        new Car("A", 1), new Car("B", 2), new Car("C", 2)
                )
        ));
        assertThat(roundResult.getWinners().equals(new ArrayList<>(Arrays.asList("B", "C")))).isTrue();
    }
}