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
import racingcar.domain.CarFactory;
import racingcar.domain.CarNameFactory;

public class WinnerTest {

    private static CarFactory carFactory1;
    private static CarFactory carFactory2;

    @BeforeAll
    static void makeCars() {
        String input = "asd,zxc,qwe";
        carFactory1 = new CarFactory(new CarNameFactory(input));
        carFactory2 = new CarFactory(new CarNameFactory(input));

        List<Car> cars1 = carFactory1.getCars();
        List<Car> cars2 = carFactory2.getCars();
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
        assertThat(Winner.getWinners(carFactory1)).contains("zxc");
        assertThat(Winner.getWinners(carFactory2)).contains("zxc").contains("qwe");
    }
}
