package racingcar.domain.gamewinner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class RacingGameWinnersTest {
    private final static String WINNER_DELIMITER = ", "; 
    @Nested
    class Feature {

        @Test
        @DisplayName("공동 우승은 \", \"로 구분한다.")
        void testMultipleWinner(){
            RacingGameWinners givenWinners = new RacingGameWinners(List.of("포케","폭포"));
            
            String winner = givenWinners.getWinner();
            assertThat(winner).contains(WINNER_DELIMITER);
        }

        @Test
        @DisplayName("단독 우승은 \", \"가 존재하지 않는다.")
        void testSingleWinner(){
            RacingGameWinners givenWinners = new RacingGameWinners(List.of("포케"));
            
            String winner = givenWinners.getWinner();
            assertThat(winner).doesNotContain(WINNER_DELIMITER);
        }
    }
}
