package racingcar.domain;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import racingcar.controller.CarsSetGenerator;
import racingcar.domain.move.FixMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    private static final String[] OVERLAPPED_SAMPLE = {"bada", "bada", "whyb"};
    private static final String[] LONGNAME_SAMPLE = {"pobi", "bada", "whybbb"};
    private static final String[] SAMPLE_CAR_LIST = {"pobi", "whyb", "bada"};
    private static final String OVERLAPPED_MESSAGE = "[ERROR] 이름을 중복하여 사용할 수 없습니다";
    private static final String SAMPLE_WINNER = "pobi";
    private static final String LENGTH_MESSAGE = "[ERROR] 이름은 5자 이하로 입력해주세요";
    private static final String NULL_MESSAGE = "[ERROR] 경주할 자동차를 1대 이상 입력해주세요";
    private static final int CRITERIA = 4;
    private static final int SAMPLE_POBI_POSITION = 0;
    private static final int SAMPLE_WHYB_POSITION = 1;
    private static final int STOP_CRITERIA = 3;
    private static final int MOVE_CRITERIA = 4;

    @Test
    @DisplayName("자동차 중복된 이름있는지 체크 테스트")
    void checkOverlappedNames() {
        List<String> falseList = Arrays.asList(OVERLAPPED_SAMPLE);
        assertThatThrownBy(() -> {
            new Cars(falseList);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(OVERLAPPED_MESSAGE);
    }

    @Test
    @DisplayName("자동차 이름 길이 체크 테스트")
    void checkNameLength() {
        List<String> falseList = Arrays.asList(LONGNAME_SAMPLE);
        assertThatThrownBy(() -> {
            new Cars(falseList);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(LENGTH_MESSAGE);
    }

    @Test
    @DisplayName("자동차 빈 이름 체크 테스트")
    void checkNull() {
        List<String> falseList = new ArrayList<>();
        assertThatThrownBy(() -> {
            new Cars(falseList);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(NULL_MESSAGE);
    }

    @Test
    @DisplayName("자동차들 이동 유효성 체크 테스트")
    void checkMoveCars() {
        List <String> carNameList = Arrays.asList(SAMPLE_CAR_LIST);
        Cars cars = new Cars(carNameList);
        checkNonMove(cars);
        checkMove(cars);
    }

    private void checkNonMove(Cars cars) {
        FixMoveStrategy nonMoveStrategy = new FixMoveStrategy(STOP_CRITERIA);
        cars.processOneTurn(nonMoveStrategy);
        assertThat(cars.getList().get(0).isSamePosition(0)).isEqualTo(true);
        assertThat(cars.getList().get(1).isSamePosition(0)).isEqualTo(true);
        assertThat(cars.getList().get(2).isSamePosition(0)).isEqualTo(true);
    }

    private void checkMove(Cars cars) {
        FixMoveStrategy moveStrategy = new FixMoveStrategy(MOVE_CRITERIA);
        cars.processOneTurn(moveStrategy);
        assertThat(cars.getList().get(0).isSamePosition(1)).isEqualTo(true);
        assertThat(cars.getList().get(1).isSamePosition(1)).isEqualTo(true);
        assertThat(cars.getList().get(2).isSamePosition(1)).isEqualTo(true);
    }

    @Test
    @DisplayName("우승자 확인 테스트")
    void findWinners() {
        List<String> carNameList = Arrays.asList(SAMPLE_CAR_LIST);
        Cars cars = new Cars(carNameList);
        List<Car> carList = cars.getList();
        setSamplePosition(carList);
        List<String> sampleWinnerList = Arrays.asList(SAMPLE_WINNER);
        List<String> testWinnerList = cars.findWinners();
        assertThat(sampleWinnerList).isEqualTo(testWinnerList);
    }

    private void setSamplePosition(List<Car> carList) {
        carList.get(SAMPLE_POBI_POSITION).oneTurn(CRITERIA);
        carList.get(SAMPLE_POBI_POSITION).oneTurn(CRITERIA);
        carList.get(SAMPLE_WHYB_POSITION).oneTurn(CRITERIA);
    }
}