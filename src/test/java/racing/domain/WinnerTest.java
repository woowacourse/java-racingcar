package racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinnerTest {

    @Test
    void 위너잘나오나확인하기() {
        Winner winner = new Winner();

        winner.add(new Car("pobi"));
        winner.add(new Car("luffy"));
        winner.add(new Car("ssoss"));

        assertThat(winner.getWinners()).isEqualTo("pobi, luffy, ssoss");
    }
}