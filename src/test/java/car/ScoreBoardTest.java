package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreBoardTest {
    
    @Test
    @DisplayName("우승자가 한 명")
    void findWinners_UniqueMaxPosition_onlyOneWinner() {
        
        // given
        final Car pobi = new Car("pobi", 2);
        final Car honux = new Car("honux", 3);
        final Car crong = new Car("crong", 4);
        
        final Cars cars = new Cars(Arrays.asList(pobi, honux, crong));
        final ScoreBoard scoreBoard = cars.recordScore();
        
        // when
        List<String> winners = scoreBoard.findWinners();
        
        // then
        assertThat(winners).containsExactly("crong");
    }
    
    @Test
    @DisplayName("우승자가 여러 명")
    void findWinners_SameMaxPosition_Winners() {
        
        // given
        final Car pobi = new Car("pobi", 2);
        final Car honux = new Car("honux", 3);
        final Car crong = new Car("crong", 3);
        
        final Cars cars = new Cars(Arrays.asList(pobi, honux, crong));
        final ScoreBoard scoreBoard = cars.recordScore();
        
        // when
        List<String> winners = scoreBoard.findWinners();
        
        // then
        assertThat(winners).containsExactly("honux", "crong");
    }
}