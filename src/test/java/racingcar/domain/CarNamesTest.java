/*
 * Copyright (c) 2020 by 티거, 제이미
 * All rights reserved.
 *
 * @author      티거, 제이미
 * @version     1.0
 * @date        11 Feb 2020
 *
 */

package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNamesTest {

    @DisplayName("문자열을 리스트로 나누는지 확인")
    @Test
    void split() {
        String input = "aaa,bbb,ccc,ddd";
        CarNames car = new CarNames(input);
        List<CarName> inputList = car.getCarNames();
        assertThat(inputList.get(0).toString()).isEqualTo("aaa");
        assertThat(inputList.get(1).toString()).isEqualTo("bbb");
        assertThat(inputList.get(2).toString()).isEqualTo("ccc");
        assertThat(inputList.get(3).toString()).isEqualTo("ddd");
    }
}
