package com.woowacourse.javaracingcar;

import com.woowacourse.javaracingcar.domain.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingcarControllerTest {

    @Test
    void testNormalPlayCases() {
        // 테스트 케이스 생성
        List<int[]> numsToGenerateList = createNumsToGenerateList();
        List<String> carNameInputList = createCarNameInputList();
        List<Integer> triesInputList = createTriesInputList();
        List<List<CarDto>> winnerList = createWinnerList();

        for (int i = 0; i < winnerList.size(); i++) {
            testPlay(
                numsToGenerateList.get(i),
                carNameInputList.get(i),
                triesInputList.get(i),
                winnerList.get(i));
        }
    }

    private List<int[]> createNumsToGenerateList() {
        return Arrays.asList(
            new int[]{1, 2, 5, 3, 2, 5, 4, 5, 3},
            new int[]{1, 2, 3, 5, 2, 6, 4, 3, 7, 3, 9, 2}
        );
    }

    private List<String> createCarNameInputList() {
        return Arrays.asList(
            "pobi, crong, honux",
            "pobi, crong, honux"
        );
    }

    private List<Integer> createTriesInputList() {
        return Arrays.asList(3, 4);
    }

    private List<List<CarDto>> createWinnerList() {
        return Arrays.asList(
            Arrays.asList(new CarDto("honux", 2)),
            Arrays.asList(new CarDto("pobi", 2),
                new CarDto("honux", 2))
        );
    }

    void testPlay(int[] numsToGenerate, String carNameInput, int triesInput, List<CarDto> winnerList) {
        RacingcarController controller = new RacingcarController(RacingcarUtil.splitIntoNames(carNameInput),
            new TestNumberGenerator(numsToGenerate));

        for (int i = 0; i < triesInput; i++) {
            controller.play();
        }

        assertThat(controller.retrieveWinners().getWinners()).isEqualTo(winnerList);
    }
}
