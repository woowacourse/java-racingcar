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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    private static final CarName carName = new CarName("가나다");

    @DisplayName("차가 제대로 생성되는지 보는 테스트")
    @Test
    void carName() {
        Car car = new Car(carName);
        assertThat(car.getName()).isEqualTo("가나다");
    }

    @DisplayName("차가 전진하는지 보는 테스트")
    @Test
    void forwardCount() {
        Car car = new Car(carName);
        car.forward();
        car.forward();
        car.forward();
        assertThat(car.getPosition()).isEqualTo(3);
    }
}
