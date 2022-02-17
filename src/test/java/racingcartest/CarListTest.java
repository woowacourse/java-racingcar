package racingcartest;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.CarList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
		List<String> winnerNameList = carList.getWinnerNames();
		String[] correctName = {"pobi", "jun"};
		assertTrue(winnerNameList.containsAll(Arrays.asList(correctName)));
	}
}
