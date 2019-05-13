package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class RacingResultTest {
    @Test
    void addParticipantTest() {
        RacingResult racingResultA = new RacingResult();
        racingResultA.addParticipant(new Car("A"));
        RacingResult racingResultB = new RacingResult();
        racingResultB.addParticipant(new Car("A"));
        assertThat(racingResultA.equals(racingResultB)).isTrue();
    }

    @Test
    void updateResultTest() {
        RacingResult racingResultA = new RacingResult();
        RacingResult racingResultB = new RacingResult();
        racingResultA.addParticipant(new Car("A", 1), 1);
        Car testCar = new Car("A");
        racingResultB.addParticipant(testCar);
        //racingResultB.updateResult(testCar);
        assertThat(racingResultA.equals(racingResultB)).isTrue();
    }

    @Test
    void getFormattedRacingResultTest() {
        RacingResult racingResult = new RacingResult();
        racingResult.addParticipant(new Car("A"));
        racingResult.updateResult(new Car("A"), true);
        racingResult.updateResult(new Car("A"), true);
        assertThat(racingResult.getFormattedRacingResult()
                .equals(new ArrayList<>(Arrays.asList("A : -\n", "A : --\n")))
        ).isTrue();
    }

    @Test
    void getNumOfRoundTest() {
        RacingResult racingResult = new RacingResult();
        racingResult.addParticipant(new Car("A"));
        racingResult.updateResult(new Car("A"), true);
        racingResult.updateResult(new Car("A"), true);
        assertThat(racingResult.getNumOfRound()).isEqualTo(2);
    }

    @Test
    void getFormattedRoundResultTest() {
        RacingResult racingResult = new RacingResult();
        racingResult.addParticipant(new Car("A"));
        racingResult.updateResult(new Car("A"), true);
        racingResult.updateResult(new Car("A"), true);
        assertThat(racingResult.getFormattedRoundResult(1).equals("A : -\n")).isTrue();
    }

    @Test
    void drawPositionLineTest() {
        RacingResult racingResult = new RacingResult();
        assertThat(racingResult.drawPositionLine(3)).isEqualTo("---");
    }

    @Test
    void getWinnersTest() {
        RacingResult racingResult = new RacingResult();
        racingResult.addParticipant(new Car("A"));
        racingResult.addParticipant(new Car("B"));
        racingResult.updateResult(new Car("A"), true);
        racingResult.updateResult(new Car("B"), false);
        assertThat(racingResult.getWinners().equals(new ArrayList<>(Arrays.asList("A")))).isTrue();
    }

    @Test
    void isEqualResultTest1() {
        assertThat(new RacingResult().isEqualResult(
                new ArrayList<>(Arrays.asList(1, 2, 3)), new ArrayList<>(Arrays.asList(1, 2, 3)))
        ).isTrue();
    }

    @Test
    void isEqualResultTest2() {
        assertThat(new RacingResult().isEqualResult(
                new ArrayList<>(Arrays.asList(1, 2, 3)), new ArrayList<>(Arrays.asList(1, 2, 2)))
        ).isFalse();
    }
}