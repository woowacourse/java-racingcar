/*
 * Copyright (c) 2020 by 티거, 제이미
 * All rights reserved.
 *
 * @author      티거, 제이미
 * @version     1.0
 * @date        12 Feb 2020
 *
 */

package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.CarNames;

public class WinnerTest {

    private static Cars cars1;
    private static Cars cars2;

    @BeforeAll
    static void makeCars() {
        String input = "asd,zxc,qwe";
        cars1 = new Cars(new CarNames(input));
        cars2 = new Cars(new CarNames(input));

        List<Car> cars1 = WinnerTest.cars1.getCars();
        List<Car> cars2 = WinnerTest.cars2.getCars();
        cars1.get(0).forward();
        cars1.get(1).forward();
        cars1.get(1).forward();
        cars1.get(1).forward();
        cars1.get(2).forward();
        cars1.get(2).forward();
        cars2.get(0).forward();
        cars2.get(1).forward();
        cars2.get(1).forward();
        cars2.get(2).forward();
        cars2.get(2).forward();
    }

    @Test
    void winners() {
        assertThat(Winner.getWinners(cars1)).contains("zxc");
        assertThat(Winner.getWinners(cars2)).contains("zxc").contains("qwe");
    }
}
