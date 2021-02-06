package car.domain;

import car.domain.engine.Engine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreBoardTest {
    
    private final Engine mockEngine = new MockEngine(4);
    
    @Test
    @DisplayName("우승자가 한 명")
    void findWinners_UniqueMaxPosition_onlyOneWinner() {
        
        // given
        final Car pobi = new Car("pobi", 2, mockEngine);
        final Car honux = new Car("honux", 3, mockEngine);
        final Car crong = new Car("crong", 4, mockEngine);
        
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
        final Car pobi = new Car("pobi", 2, mockEngine);
        final Car honux = new Car("honux", 3, mockEngine);
        final Car crong = new Car("crong", 3, mockEngine);
        
        final Cars cars = new Cars(Arrays.asList(pobi, honux, crong));
        
        final ScoreBoard scoreBoard = cars.recordScore();
        
        // when
        List<String> winners = scoreBoard.findWinners();
        
        // then
        assertThat(winners).containsExactly("honux", "crong");
    }
}