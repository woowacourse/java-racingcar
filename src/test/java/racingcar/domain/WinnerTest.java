/*
 * Copyright (c) 2020 by 티거, 제이미
 * All rights reserved.
 *
 * @author      티거, 제이미
 * @version     1.0
 * @date        12 Feb 2020
 *
 */

package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnerTest {

    private static Cars cars1;
    private static Cars cars2;

    @BeforeAll
    static void makeCars() {
        cars1 = new Cars(
            Arrays.asList(new Car("asd", 1), new Car("zxc", 0))
        );

        cars2 = new Cars(
            Arrays.asList(new Car("asd", 1), new Car("zxc", 1))
        );
    }

    @DisplayName("우승자가 한명일 때")
    @Test
    void getWinner_one() {
        assertThat(Winner.getWinner(cars1)).isEqualTo("asd");
    }

    @DisplayName("우승자가 두명일 때")
    @Test
    void getWinner_two() {
        assertThat(Winner.getWinner(cars2)).isEqualTo("asd, zxc");
    }
}
