package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
    private static final String[] SAMPLE_CAR_LIST = {"pobi", "whyb", "bada"};
    private static final String[] OVERLAPPED_SAMPLE = {"bada", "bada", "whyb"};
    private static final String OVERLAPPED_MESSAGE = "[ERROR] 이름을 중복하여 사용할 수 없습니다";
    private static final String NULL_MESSAGE = "[ERROR] 경주할 자동차를 1대 이상 입력해주세요";
    private static final String SAMPLE_WINNER = "pobi";
    private static final int CRITERIA = 4;
    private static final int SAMPLE_POBI_POSITION = 0;
    private static final int SAMPLE_WHYB_POSITION = 1;

    @Test
    @DisplayName("중복이름 검증 테스트")
    void checkOverlappedNames() {
        List<String> falseList = Arrays.asList(OVERLAPPED_SAMPLE);
        assertThatThrownBy(() -> {
            new Cars(falseList);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(OVERLAPPED_MESSAGE);
    }

    @Test
    @DisplayName("차가 0대인지 검증하는 테스트")
    void checkNull() {
        List<String> falseList = new ArrayList<>();
        assertThatThrownBy(() -> {
            new Cars(falseList);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NULL_MESSAGE);
    }

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