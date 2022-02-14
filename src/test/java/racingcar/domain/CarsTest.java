package racingcar.domain;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.utils.NumberGenerator;
import racingcar.utils.StubNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.SoftAssertions.*;

public class CarsTest{

    NumberGenerator numberGenerator;

    @BeforeEach
    void setUp() {
        numberGenerator = new StubNumberGenerator();
    }

    @Test
    void 자동차_우승_1명_성공() {
        Cars cars = new Cars(new String[]{"jae","rick"});
        cars.moveCars(numberGenerator);

        assertSoftly(softAssertions -> {
            List<String> winners = cars.getWinners();
            softAssertions.assertThat(winners).contains("rick");
            softAssertions.assertThat(winners.size()).isEqualTo(1);
        });
    }

    @Test
    void 자동차_우승_2명_성공() {
        Cars cars = new Cars(new String[]{"jae", "rick"});
        for (int i = 0; i < 2; i++) {
            cars.moveCars(numberGenerator);
        }
        assertSoftly(softAssertions -> {
            List<String> winners = cars.getWinners();
            softAssertions.assertThat(winners).contains("rick");
            softAssertions.assertThat(winners).contains("jae");
            softAssertions.assertThat(winners.size()).isEqualTo(2);
        });
    }

}