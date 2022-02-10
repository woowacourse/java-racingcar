package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;
import static racingcar.Validator.*;

public class ValidatorTest {

    // todo 이름의 중복, 이름의 빈칸, 이름이 5자 이상, 자동차 개수 5개

    @Test
    void 이름_입력_성공() {
        String[] names = {"ab", "cd", "efg"};

        try (MockedStatic<Validator> mockValidator = mockStatic(Validator.class)){
            mockValidator.verify(() -> validateCarCount(names));
            mockValidator.verify(() -> validateNameLength(names));
            mockValidator.verify(() -> validateBlank(names));
            mockValidator.verify(() -> validateDuplicateName(names));
        }
    }

    @Test
    void 자동차_개수_초과_실패() {
        assertThatThrownBy(() ->
                validateCarCount(new String[]{"jae ","hun", "ab", "cd", "ef", "gh"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차는 5대 이하이어야 합니다.");
    }

    @Test
    void 이름_길이_초과_실패() {
        assertThatThrownBy(() ->
                validateNameLength(new String[]{"jae ","hunnnnnn","jake"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름은 5자 미만이어야 합니다.");
    }

    @Test
    void 이름_빈칸_실패() {
        assertThatThrownBy(() ->
                validateBlank(new String[]{"jae ","hun","jake"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름에 공백이 존재합니다.");
    }

    @Test
    void 이름_중복_실패() {
        assertThatThrownBy(() ->
                validateDuplicateName(new String[]{"jae","hun","jae"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 이름입니다.");
    }
}
