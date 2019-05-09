package com.woowacourse.javaracingcar;

import com.woowacourse.javaracingcar.domain.Car;
import com.woowacourse.javaracingcar.domain.CarDto;
import com.woowacourse.javaracingcar.interfaces.NumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

class RacingcarModelTest {
    private NumberGenerator numberGenerator;
    private RacingcarModel racingcarModel;
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("crong"));
        cars.add(new Car("honux"));
    }

    @Test
    void 자동차_전진() {
        int[] numsToGenerate = {1,2,5};
        numberGenerator = new TestNumberGenerator(numsToGenerate);

        Car car = new Car("pobi");
        List<Car> cars = new ArrayList<>();
        cars.add(car);

        racingcarModel = new RacingcarModel(numberGenerator, cars);

        loopGame(racingcarModel, numsToGenerate.length);
        assertThat(racingcarModel.getWinners().get(0).getPosition()).isEqualTo(1);
    }

    @Test
    void 정상_게임_종료_우승자반환() {
       int[] numsToGenerate = {1,2,3,1,2,4,4,5,6};
       numberGenerator = new TestNumberGenerator(numsToGenerate);

       racingcarModel = new RacingcarModel(numberGenerator, cars);

       loopGame(racingcarModel, 3);
       assertThat(racingcarModel.getWinners().get(0).getName()).isEqualTo("honux");
    }

    @Test
    void 정상_게임_종료_공동_우승자반환() {
        int[] numsToGenerate ={4,1,4,5,2,5,6,4,6};
        numberGenerator = new TestNumberGenerator(numsToGenerate);
        List<CarDto> expectedWinnerList = new ArrayList<>();
        expectedWinnerList.add(new CarDto(cars.get(0).getName(), cars.get(0).getPosition()));
        expectedWinnerList.add(new CarDto(cars.get(2).getName(), cars.get(2).getPosition()));

        racingcarModel = new RacingcarModel(numberGenerator, cars);
        loopGame(racingcarModel, 3);
        List<CarDto> actualWinnerList = racingcarModel.getWinners();

        assertEachCarDto(expectedWinnerList, actualWinnerList);
    }

    void loopGame(RacingcarModel g, int loops) {
        for (int i = 0; i < loops; i++) {
            g.loop();
        }
    }

    private void assertEachCarDto(List<CarDto> expected, List<CarDto> actual) {
        for (int i = 0; i < expected.size(); i++) {
            assertThat(expected.get(i)).isEqualToIgnoringGivenFields(actual.get(i), "position");
        }
    }
}