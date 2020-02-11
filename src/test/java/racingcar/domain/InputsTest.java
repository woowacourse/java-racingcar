package racingcar.domain;/*
 * Copyright (c) 2019 by 이름
 * All rights reserved.
 *
 * 클래스명.java
 * 클래스 설명
 *
 * @author      이름
 * @version     1.0
 * @date        dd mm yyyy
 *
 */

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputsTest {

    @DisplayName("공백 포함시 예외발생")
    @ParameterizedTest
    @ValueSource(strings = {"asd ,qwe,zxc", " asd,qwe,zxc", "asd,qwe,zxc ", "asd ,qwe ,z x c"})
    void hasBlankException(String input) {
        assertThatThrownBy(() -> new Inputs(input)).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("공백");
    }

    @DisplayName("문자열을 리스트로 나누는지 확인")
    @Test
    void split() throws Exception {
        String input = "aaa,bbb,ccc,ddd";
        new Inputs(input);
        List<String> inputList = Inputs.getInputs();
        assertThat(inputList.get(0)).isEqualTo("aaa");
        assertThat(inputList.get(1)).isEqualTo("bbb");
        assertThat(inputList.get(2)).isEqualTo("ccc");
        assertThat(inputList.get(3)).isEqualTo("ddd");
    }
}
