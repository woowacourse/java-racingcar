package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import output.Output;
import output.Outputs;

class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void init() {
        Names names = new Names("pobi,crong,honux");
        RepeatCount repeatCount = new RepeatCount("1");
        RandomGenerator randomGenerator = new TestRandomGenerator();

        racingGame = new RacingGame(names, repeatCount, randomGenerator);
    }

    @Test
    void canRaceTest() {
        assertThat(racingGame.canRace()).isTrue();
        assertThat(racingGame.canRace()).isFalse();
    }

    @Test
    void raceTest() {
        Outputs outputs = racingGame.race();
        List<Integer> positions = outputs.getOutputs()
                .stream()
                .map(Output::getPosition)
                .collect(Collectors.toList());

        assertThat(positions).containsExactly(0, 1, 1);
    }
}
