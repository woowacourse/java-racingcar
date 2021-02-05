package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private static final String[] SAMPLE_CAR_LIST = {"pobi", "whyb", "bada"};
    private static final String SAMPLE_WINNER = "pobi";
    private static final int CRITERIA = 4;
    private static final int SAMPLE_POBI_POSITION = 0;
    private static final int SAMPLE_WHYB_POSITION = 1;

    @Test
    void findWinners() {
        List<String> carNameList = Arrays.asList(SAMPLE_CAR_LIST);
        Cars cars = new Cars(carNameList);
        List<Car> carList = cars.getList();
        setSamplePosition(carList);
        String testWinner = cars.findWinners();
        assertThat(SAMPLE_WINNER).isEqualTo(testWinner);
    }

    private void setSamplePosition(List<Car> carList) {
        carList.get(SAMPLE_POBI_POSITION).oneTurn(CRITERIA);
        carList.get(SAMPLE_POBI_POSITION).oneTurn(CRITERIA);
        carList.get(SAMPLE_WHYB_POSITION).oneTurn(CRITERIA);
    }
}