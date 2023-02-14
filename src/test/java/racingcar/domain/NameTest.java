package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

    private static final int MINIMUM_NAME_LENGTH = 1;
    private static final int MAXIMUM_NAME_LENGTH = 5;


    @DisplayName("이름 길이가 1보다 작은 경우 예외 발생")
    @Test
    void validateNameLengthLessThan1() {
        assertThatThrownBy(() -> new Name(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(
                        "[ERROR] 자동차 이름은 최소 " + MINIMUM_NAME_LENGTH + "글자, 최대 " + MAXIMUM_NAME_LENGTH + "글자까지 가능해요.");
    }

    @DisplayName("이름 길이가 5보다 큰 경우 예외 발생")
    @Test
    void validateNameLengthMoreThan5() {
        assertThatThrownBy(() -> new Name("millie"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(
                        "[ERROR] 자동차 이름은 최소 " + MINIMUM_NAME_LENGTH + "글자, 최대 " + MAXIMUM_NAME_LENGTH + "글자까지 가능해요.");
    }
}