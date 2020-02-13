/*
 * Copyright (c) 2020 by 티거, 제이미
 * All rights reserved.
 *
 * @author      티거, 제이미
 * @version     1.0
 * @date        12 Feb 2020
 *
 */

package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarNames;

public class WinnerTest {

    private static List<Car> cars1 = new ArrayList<>();
    private static List<Car> cars2 = new ArrayList<>();

    @BeforeAll
    static void makeCars() {
        String input = "asd,zxc,qwe";
        List<String> carNames = new CarNames(input).getCarNames();
        for (String carName : carNames) {
            cars1.add(new Car(carName));
            cars2.add(new Car(carName));
        }
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
        Assertions.assertThat(Winner.getWinnerWithDelimiter(cars1,", ")).isEqualTo("zxc");
        assertThat(Winner.getWinnerWithDelimiter(cars2, ", ")).isEqualTo("zxc, qwe");
    }
}
