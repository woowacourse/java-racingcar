import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingGame.RacingGame;

import java.util.List;

public class RacingGameTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobipobi", "crongcrong", "honuxisgreat", ""})
    void 한명_입력시_이름길이_검증(String value){
        Assertions.assertThatThrownBy(()->{
            RacingGame.validateInput(value);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageMatching("이름의 길이는 1자 이상, 5자 이하만 가능합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux:pobi", "a,b,c:c"}, delimiter = ':')
    void 여러명_입력시_split_검증(String value, String expected){
        List<String> list = RacingGame.splitInput(value);
        Assertions.assertThat(list).contains(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honuxs", "a,b,ccccccc", "a,,b", ""})
    void 여러명_입력시_이름길이_검증(String value){
        Assertions.assertThatThrownBy(()->{
            List<String> list = RacingGame.splitInput(value);
            RacingGame.validateInputList(list);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageMatching("이름의 길이는 1자 이상, 5자 이하만 가능합니다.");
    }
}