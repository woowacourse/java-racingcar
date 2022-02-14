package racingcar.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringSeparatorTest {

    @Test
    @DisplayName("이름값들을 입력했을 때 쉼표를 기준으로 분리할 수 있는가?")
    void splitCarNameByComma() {
        String carNames = "pobi,elsa,troy";
        String[] strings = StringSeparator.splitAndTrim(carNames);
        Assertions.assertThat(strings).containsExactly("pobi", "elsa", "troy");
    }

    @Test
    @DisplayName("이름의 앞뒤로 공백이 있을 경우 제거하고 나누는가?")
    void splitCarNameWithSpace() {
        String carNames = "pobi , elsa, troy ";
        String[] strings = StringSeparator.splitAndTrim(carNames);
        Assertions.assertThat(strings).containsExactly("pobi", "elsa", "troy");
    }
}