package domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {
    private Race race;
    private int roundCount = 5;

    @BeforeEach
    void setUp() {
        race = new Race(Arrays.asList("pobi", "crong", "kim"), roundCount);
    }

    @Test
    void 레이스_객체_생성() {
        assertThat(race).isEqualTo(new Race(Arrays.asList("pobi", "crong", "kim"), roundCount));
    }

    @Test
    void 레이스_시도_회수만큼_수행() {
        race.moveAllCarsByRoundCount();
    }

    @AfterEach
    void tearDown() {
        race = null;
    }
}