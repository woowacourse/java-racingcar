package racingcartest;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.CarList;

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
		assertThat(this.carList.getTotalCount()).isEqualTo(3);
	}

	@Test
	public void carListWinnerNameTest() {
		this.carList.moveCarAt(0, 5);
		this.carList.moveCarAt(1, 6);
		ArrayList<String> winnerNameList = carList.getWinnerNames();
		String[] correctNameList = {"pobi", "jun"};
		assertThat(winnerNameList).isEqualTo(new ArrayList<String>(Arrays.asList(correctNameList)));
	}
}
