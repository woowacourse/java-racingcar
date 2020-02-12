import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingGame.Input;
import racingGame.RacingGame;

public class RacingGameTest {
    Input input;
    private final String NAMES = "pobi,crong,honux";
    private final String REPEAT= "5";

    @BeforeEach
    void initInput(){
        input = new Input(NAMES, REPEAT);
    }
    @ParameterizedTest
    @CsvSource(value = {"7, true", "4, true", "3, false", "0, false", "9,true"})
    void 이동_테스트(int random, boolean expected){
        boolean result = RacingGame.move(random);

        Assertions.assertThat(result).isEqualTo(expected);
    }

}
