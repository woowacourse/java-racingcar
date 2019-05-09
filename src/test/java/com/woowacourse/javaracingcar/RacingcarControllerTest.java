package com.woowacourse.javaracingcar;

import com.woowacourse.javaracingcar.domain.CarDto;
import com.woowacourse.javaracingcar.domain.TestNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingcarControllerTest {

    @Test
    void testPlay() {
        int[] numsToGenerate = new int[]{1, 2, 5, 3, 2, 5, 4, 5, 3};
        RacingcarController controller = new RacingcarController(new TestUserInterface(
            new TestUserInterface.TestUserInterfaceOutputListener() {
                @Override
                public void onPrintResult(List<CarDto> cars) {}
                @Override
                public void onPrintWinners(List<CarDto> cars) {
                    assertThat(cars).hasSize(1).contains(new CarDto("honux", 2));
                }
            }, "pobi, crong, honux", 3
        ), new TestNumberGenerator(numsToGenerate));
        controller.play();
    }
}
