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

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnerTest {

    private static List<Car> cars1 = new ArrayList<>();
    private static List<Car> cars2 = new ArrayList<>();

    @BeforeAll
    static void makeCars() {
        String input = "asd,zxc,qwe";
        cars1 = CarFactory.createCar(input);
        cars2 = CarFactory.createCar(input);

        cars1.get(1).move(3);
        cars1.get(1).move(4);
        cars1.get(1).move(4);

        cars2.get(0).move(4);
        cars2.get(0).move(4);
        cars2.get(1).move(4);
        cars2.get(1).move(4);
    }

    @DisplayName("우승자가 한명일 때")
    @Test
    void getWinner_one() {
        assertThat(Winner.getWinner(cars1)).isEqualTo("zxc");
    }

    @DisplayName("우승자가 두명일 때")
    @Test
    void getWinner_two() {
        assertThat(Winner.getWinner(cars2)).isEqualTo("asd, zxc");
    }
}
