package racingcar.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.lang.reflect.Method;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {

    @ParameterizedTest
    @ValueSource(strings = {"test1,test2,test3,test3,test1", "a,b,c,d,a", "1,0,0,2,3,4,9"})
    @DisplayName("자동차 이름이 중복되는 경우 예외 테스트")
    public void check_name_input_duplicate(String inputValue)
        throws NoSuchMethodException {
        Method method = InputView.class.getDeclaredMethod("getParseNames", String.class);
        method.setAccessible(true);
        assertThatThrownBy(() -> method.invoke(null, inputValue))
            .hasCause(new IllegalArgumentException("[ERROR] 자동차 이름은 중복이 불가능합니다."));
    }

}
