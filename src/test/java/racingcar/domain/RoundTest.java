package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RoundTest {
    // TODO - 질문 : 시도할 횟수에 문자를 입력받은 경우를 테스트하려고 하는데, 컴파일 에러가 나서 테스트 조차 못함.
//    @Test
//    public void 시도할_횟수는_숫자여야한다() {
//        assertThatThrownBy(() -> {
//            Round.of("a");
//        }).isInstanceOf(Exception.class);
//    }

    @ParameterizedTest(name = "시도할_횟수는_1이상의_숫자여야_한다")
    @ValueSource(ints = {0, -1, -5})
    public void roundCountShouldBeBiggerThanOneTest(int count) {
        assertThatThrownBy(() -> {
            Round.of(count);
        }).isInstanceOf(IllegalArgumentException.class);
    }


    // TODO - 질문 : int 범위를 벗어나는 경우는 어떻게 테스트 하죠 ? 컴파일 에러가 나네요.
//    @Test
//    public void roundCountShouldBeInIntRange() {
//        assertThatThrownBy(() -> {
//            String str = "100000000000000000000";
//            Round.of(Integer.parseInt(str));
//        }).isInstanceOf(NumberFormatException.class);
//    }
}
