import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racinggame.controller.Output;

public class OutputTest {
    Output output;

    @BeforeEach
    void initOutput(){
        output = new Output();
    }
    @ParameterizedTest
    @CsvSource(value = {"pobi,3,pobi : ---", "crong,4,crong : ----", "honux,0,honux : "})
    void 로그_테스트(String name, int position, String log){
        if(position == 0){
            log += " ";
        }
        Assertions.assertThat(output.makeStatusLog(name, position)).isEqualTo(log);
    }
}
