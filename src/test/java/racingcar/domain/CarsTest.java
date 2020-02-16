/*
 * Copyright (c) 2020 by 티거
 * All rights reserved.
 *
 * @author      티거
 * @version     1.0
 * @date        16 Feb 2020
 *
 */

package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @DisplayName("생성자를 만들어 값을 잘 불러오는지 테스트")
    @Test
    void getCars() {
        List<Car> cars = Arrays.asList(
            new Car("asd", 0), new Car("zxc", 0)
        );
        Cars carsCollection = new Cars(cars);

        assertThat(carsCollection.getCars()).isEqualTo(cars);
    }
}
