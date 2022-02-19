package carracinggame.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNamesControllerTest {

    CarNamesController carNamesController = new CarNamesController();

    @DisplayName("자동차 이름 정상 입력")
    @Test
    void TestCarNames() {
        String[] carNames = carNamesController.createCarNames("a,b,c");
        assertThat(carNames).isEqualTo(new String[]{"a", "b", "c"});
    }

    @DisplayName("자동차 이름 중복 확인")
    @Test
    void TestCarNamesOverlap() {
        String[] names = carNamesController.createCarNames("a,a,c");
        assertThat(names).isEqualTo(new String[]{"a", "a", "c"});
    }

    @DisplayName("자동차 이름이 6자 이상일 때 에러 확인")
    @Test
    void TestCarNamesLengthError() {
        assertThatThrownBy(() -> carNamesController.createCarNames("techCourse"))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("자동차 이름이 공백또는 null 일 때 에러 확인")
    @ParameterizedTest
    @NullAndEmptySource
    void TestCarNamesBlankOrNullError(String value) {
        assertThatThrownBy(() -> carNamesController.createCarNames(value))
                .isInstanceOf(RuntimeException.class);
    }

}
