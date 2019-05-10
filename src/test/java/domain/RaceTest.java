package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RaceTest {
    private Race race;
    private int roundCount = 5;

    @BeforeEach
    void setUp() {
        race = new Race(new Cars(Arrays.asList("pobi", "crong", "kim")).createCars(), roundCount);
    }

    @Test
    void 레이스_객체_생성() {
        assertThat(race).isEqualTo(new Race(new Cars(Arrays.asList("pobi", "crong", "kim")).createCars(), roundCount));
    }

    @Test
    void 레이스_시되_회수만큼_수행() {
        race.moveAllCarsByRoundCount();
        System.out.println(race.toString());
    }
}