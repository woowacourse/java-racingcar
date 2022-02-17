package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.utils.StubNumberGenerator;

import java.util.List;

import static org.assertj.core.api.SoftAssertions.*;

public class CarsTest{

    private StubNumberGenerator stubNumberGenerator = new StubNumberGenerator();

    @Test
    void 자동차_우승_1명_성공() {
        Cars cars = new Cars(new String[]{"jae","rick"});
        stubNumberGenerator.prepareStubNumbers(2, 3, 4);
        cars.moveCars(stubNumberGenerator);

        assertSoftly(softAssertions -> {
            List<String> winners = cars.findWinners();
            softAssertions.assertThat(winners).contains("rick");
            softAssertions.assertThat(winners.size()).isEqualTo(1);
        });
    }

    @Test
    void 자동차_우승_2명_성공() {
        Cars cars = new Cars(new String[]{"jae", "rick"});

        stubNumberGenerator.prepareStubNumbers(2, 4, 4);
        cars.moveCars(stubNumberGenerator);

        assertSoftly(softAssertions -> {
            List<String> winners = cars.findWinners();
            softAssertions.assertThat(winners).contains("rick");
            softAssertions.assertThat(winners).contains("jae");
            softAssertions.assertThat(winners.size()).isEqualTo(2);
        });
    }
}