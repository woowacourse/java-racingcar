import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingGame.RacingGame;

public class RacingGameTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobipobi", "crongcrong", "honuxisgreat", ""})
    void 한명입력시_이름길이_검증(String value){
        Assertions.assertThatThrownBy(()->{
            RacingGame.validateInput(value);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageMatching("이름의 길이는 1자 이상, 5자 이하만 가능합니다.");
    }
}