import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racinggame.domain.Output;
import racinggame.domain.RacingGame;

public class OutputTest {
    Output output;

    @ParameterizedTest
    @CsvSource(value = {"pobi,3,pobi : ---", "crong,4,crong : ----", "honux,0,honux : "})
    void 로그_테스트(String name, int position, String log) {
        if (position == 0) {

            /* CsvSource에서 String의 마지막이 공백인 경우 인식하지 못하여 추가 */
            log += " ";
        }
        Assertions.assertThat(output.makeCarLog(name, position)).isEqualTo(log);
    }
}
