package com.woowacourse.javaracingcarwithoutif.domain;

import com.woowacourse.javaracingcar.domain.TestNumberGenerator;
import com.woowacourse.javaracingcar.interfaces.NumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingcarModelTest {
    private NumberGenerator numberGenerator;
    private RacingcarModel racingcarModel;
    private List<String> carNameList;

    @BeforeEach
    void setUp() {
        carNameList = Arrays.asList("pobi", "crong", "honux");
    }

    @Test
    void 자동차_전진() {
        int[] numsToGenerate = {1, 2, 5};
        numberGenerator = new TestNumberGenerator(numsToGenerate);

        racingcarModel = new RacingcarModel(numberGenerator, Collections.singletonList("pobi"));

        loopGame(racingcarModel, numsToGenerate.length);
        assertThat(racingcarModel.getWinners().get(0).getPosition()).isEqualTo(1);
    }

    @Test
    void 정상_게임_종료_우승자반환() {
        int[] numsToGenerate = {1, 2, 3, 1, 2, 4, 4, 5, 6};
        numberGenerator = new TestNumberGenerator(numsToGenerate);

        racingcarModel = new RacingcarModel(numberGenerator, carNameList);

        loopGame(racingcarModel, numsToGenerate.length / carNameList.size());
        assertThat(racingcarModel.getWinners().get(0).getName()).isEqualTo("honux");
    }

    @Test
    void 정상_게임_종료_공동_우승자반환() {
        int[] numsToGenerate = {4, 1, 4, 5, 2, 5, 6, 4, 6};
        numberGenerator = new TestNumberGenerator(numsToGenerate);
        List<String> expectedWinnerNameList = Arrays.asList(carNameList.get(0), carNameList.get((2)));

        racingcarModel = new RacingcarModel(numberGenerator, carNameList);
        loopGame(racingcarModel, 3);
        List<String> actualWinnerList = racingcarModel.getWinners()
            .stream()
            .map(CarDto::getName)
            .collect(Collectors.toList());

        for (int i = 0; i < expectedWinnerNameList.size(); i++) {
            assertThat(expectedWinnerNameList.get(i)).isEqualTo(actualWinnerList.get(i));
        }
    }

    void loopGame(RacingcarModel g, int loops) {
        for (int i = 0; i < loops; i++) {
            g.loop();
        }
    }
}
