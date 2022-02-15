package racingcartest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.util.StringConst;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarListTest {
    private CarList carList;

    @BeforeEach
    public void carListSetUp() {
        String[] names = {"pobi", "jun", "jason"};
        this.carList = new CarList(names);
    }

    @Test
    public void carListCountTest() {
        assertThat(this.carList.getNameList().size()).isEqualTo(3);
    }

    @Test
    public void carListMaxPositionTest() {
        this.carList.moveCarAt(0, 5);
        this.carList.moveCarAt(0, 6);
        assertThat(this.carList.getMaxPosition()).isEqaulTo(2);
    }

    @Test
    public void carListWinnerNameTest() {
        this.carList.moveCarAt(0, 5);
        this.carList.moveCarAt(1, 6);
        ArrayList<String> winnerNameList = this.carList.getWinnerNames();
        assertThat(String.join(StringConst.WINNER_DELIMITER.getValue(), winnerNameList)).isEqualTo("pobi, jun");
    }
}
