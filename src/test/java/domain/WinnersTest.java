package domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinnersTest {
    private Winners winners;
    private List<CarDto> carsOnFinishedRace;

    @BeforeEach
    void setUp() {
        carsOnFinishedRace = Arrays.asList(
                new CarDto("pobi", 2),
                new CarDto("crong", 3),
                new CarDto("honux", 1)
        );
        winners = new Winners(carsOnFinishedRace);
    }

    @Test
    void 우승자_이름_구하기() {
        assertThat(winners.getRaceWinners()).isEqualTo("crong");
    }

    @AfterEach
    void tearDown() {
        carsOnFinishedRace = null;
        winners = null;
    }
}