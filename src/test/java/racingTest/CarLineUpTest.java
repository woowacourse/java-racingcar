package racingTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.Car;
import racing.model.CarLineUp;
import racing.model.ManualNoGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarLineUpTest {

    @Test
    @DisplayName("차 이름 중복 여부 확인")
    void checkDuplicatedNameTest() {
        assertThatThrownBy(() -> {
            String[] inputCarNames = {"토니", "작은곰", "보스독", "작은곰"};
            new CarLineUp(inputCarNames);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차 이름이 중복되었습니다.");
    }

    @Test
    @DisplayName("포지션 값 기준으로 우승자 찾기")
    void findTopPositionCarTest() {
        String[] inputCarNames = {"토니", "작은곰", "보스독"};
        int[] positions = {5, 6, 9};
        CarLineUp lineUp = new CarLineUp(inputCarNames, positions);

        assertThat(lineUp.findTopPositionCar()).isEqualTo(new Car("보스독"));
    }

    @Test
    @DisplayName("공동 우승자 찾기")
    void findWinnerTest() {
        String[] inputCarNames = {"토니", "작은곰", "보스독"};
        int[] positions = {5, 7, 7};
        CarLineUp lineUp = new CarLineUp(inputCarNames, positions);
        assertThat(lineUp.findWinner()).contains(new Car("작은곰"));
        assertThat(lineUp.findWinner()).contains(new Car("보스독"));
    }

    @Test
    @DisplayName("시도횟수 1회 돌았을 때, 각 차들의 이동 여부 확인")
    void raceOneTimeTest(){
        String[] inputCarNames = {"토니"};
        CarLineUp lineUp = new CarLineUp(inputCarNames);

        lineUp.raceOneTime(new ManualNoGenerator(4));
        int currentPosition = lineUp.getLineUp().peek().getPosition();
        assertThat(currentPosition).isEqualTo(1);
    }

}
