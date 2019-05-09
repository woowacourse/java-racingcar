package com.woowacourse.javaracingcar;

import com.woowacourse.javaracingcar.domain.CarDto;
import com.woowacourse.javaracingcar.domain.TestNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingcarControllerTest {

    @Test
    void runPlayTestCases() {
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

    private List<List<CarDto>> createWinnerList() {
        return Arrays.asList(
                Arrays.asList(new CarDto("honux", 2)),
                Arrays.asList(new CarDto("pobi", 2),
                    new CarDto("honux", 2))
            );
    }

    private List<Integer> createTriesInputList() {
        return Arrays.asList(3, 4);
    }

    private List<String> createCarNameInputList() {
        return Arrays.asList(
                "pobi, crong, honux",
                "pobi, crong, honux"
            );
    }

    private List<int[]> createNumsToGenerateList() {
        return Arrays.asList(
                new int[]{1, 2, 5, 3, 2, 5, 4, 5, 3},
                new int[]{1, 2, 3, 5, 2, 6, 4, 3, 7, 3, 9, 2}
            );
    }

    void testPlay(int[] numsToGenerate, String carNameInput, int triesInput, List<CarDto> winnerList) {
        new RacingcarController(new TestUserInterface(
            new TestUserInterface.TestUserInterfaceOutputListener() {
                @Override
                public void onPrintResult(List<CarDto> carList) {}
                @Override
                public void onPrintWinners(List<CarDto> carList) {
                    assertThat(carList).hasSize(winnerList.size());
                    for (CarDto winner : winnerList) {
                        assertThat(carList).contains(winner);
                    }
                }
            }, carNameInput, triesInput), new TestNumberGenerator(numsToGenerate)).play();
    }
}
