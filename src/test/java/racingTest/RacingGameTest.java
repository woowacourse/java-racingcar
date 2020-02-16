package racingTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.controller.RacingGame;
import racing.model.Car;
import racing.model.CarLineUp;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {

    private RacingGame game = new RacingGame();
    private CarLineUp lineUp  = new CarLineUp();

    @BeforeEach
    void setUp(){
        lineUp.add(new Car("포비"));
        lineUp.add(new Car("코난"));
        lineUp.add(new Car("보스독"));
        lineUp.add(new Car("엘사"));
    }

    @Test
    void 차이름_중복될_경우_예외처리(){
        assertThatThrownBy(() -> {
            game.checkNameDuplicate(lineUp, "포비");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차이름이 중복되었습니다.");
    }

}
