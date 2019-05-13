package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

public class RacingGameTest {
    RacingGame racingGame;
    List<String> carNames;
    
    @BeforeEach
    void setup() {
    	carNames = new ArrayList<String>();
    	carNames.add("bmo");
    	racingGame = new RacingGame(carNames.stream().toArray(String[]::new));
    }
    
    @Test
    void 생성() {
    	String[] names1 = {"amo"};
    	RacingGame racingGame1 = new RacingGame(names1);
    	assertThat(racingGame).isNotEqualTo(racingGame1);

    	String[] names2 = {"bmo"};
    	RacingGame racingGame2 = new RacingGame(names2);
    	assertThat(racingGame).isEqualTo(racingGame2);
    }
    
    @Test
    void 난수() {
    	for(int i = Math.min(RacingGame.RANDOM_MAX * 2, Integer.MAX_VALUE); i >= 0 ; i--) {
    		assertThat(racingGame.getRandomNumber()).isBetween(0, 9);		
    	}
    }
    
    @Test
    void 이름중복() {
    	assertThat(racingGame.hasDuplicatedNames(carNames.stream().toArray(String[]::new))).isEqualTo(false);
    	carNames.add("bmo");
    	assertThat(racingGame.hasDuplicatedNames(carNames.stream().toArray(String[]::new))).isEqualTo(true);
    }
    
    @AfterEach
    void tearDown() {
    	carNames = null;
    	racingGame = null;
    }
}
