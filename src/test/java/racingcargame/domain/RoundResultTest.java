package racingcargame.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RoundResultTest {

    @Test
    void createCarSnapShots() {
        Car carJ = new Car("제이");
        Car carLatter = new Car("라테");
        Car carPobi = new Car("포비");

        carJ.move(4);
        carJ.move(4);
        carJ.move(4);

        carLatter.move(5);
        carLatter.move(5);

        carPobi.move(4);

        List<CarSnapShot> carSnapShotList = new ArrayList<>();
        carSnapShotList.add(new CarSnapShot(carJ));
        carSnapShotList.add(new CarSnapShot(carLatter));
        carSnapShotList.add(new CarSnapShot(carPobi));

        RoundResult roundResult = new RoundResult(carSnapShotList);
        assertThat(roundResult.toString()).isEqualTo("제이 : ---\n라테 : --\n포비 : -\n");
    }
}