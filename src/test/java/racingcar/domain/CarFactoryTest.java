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

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarFactoryTest {

    @DisplayName("문자열을 리스트로 만드는지 테스트")
    @Test
    void split() {
        String input = "aaa,bbb,ccc,ddd";
        List<Car> car = CarFactory.createCar(input);
        assertThat(car.get(0).getName()).isEqualTo("aaa");
        assertThat(car.get(1).getName()).isEqualTo("bbb");
        assertThat(car.get(2).getName()).isEqualTo("ccc");
        assertThat(car.get(3).getName()).isEqualTo("ddd");
    }
}
