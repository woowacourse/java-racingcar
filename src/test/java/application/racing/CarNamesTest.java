package application.racing;

import application.racing.domain.CarNames;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNamesTest {
    @DisplayName("잘못된 문자열로 자동차를 생성할 때 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", ",asd", "asdfrq,pobi", "pobi,pobi", "pobi,,crong", "pobi, ,crong", "  ,pobi"})
    public void validateCarNameTest(String input) {
        Assertions.assertThatThrownBy(() -> {
            new CarNames(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
