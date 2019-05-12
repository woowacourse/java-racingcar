package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class RoundResultTest {
    @Test
    void addParticipantTest() {
        RoundResult roundResultA = new RoundResult();
        roundResultA.addParticipant(new Car("A"));
        RoundResult roundResultB = new RoundResult();
        roundResultB.addParticipant(new Car("A"));
        assertThat(roundResultA.equals(roundResultB)).isTrue();
    }

    @Test
    void updateResultTest() {
        RoundResult roundResultA = new RoundResult();
        RoundResult roundResultB = new RoundResult();
        roundResultA.addParticipant(new Car("A", 1), 1);
        Car testCar = new Car("A");
        roundResultB.addParticipant(testCar);
        roundResultB.updateResult(testCar);
        assertThat(roundResultA.equals(roundResultB)).isTrue();
    }

    @Test
    void drawPositionLineTest() {
        RoundResult roundResult = new RoundResult();
        assertThat(roundResult.drawPositionLine(3).toString()).isEqualTo("---");
    }

    @Test
    void getFormattedRoundResult() {
        RoundResult roundResult = new RoundResult();
        roundResult.addParticipant(new Car("A", 2), 2);
        roundResult.addParticipant(new Car("B"));
        assertThat(roundResult.getFormattedRoundResult()).isEqualTo(Arrays.asList("A : --", "B : "));
    }
}