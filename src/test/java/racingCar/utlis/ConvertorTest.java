package racingCar.utlis;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConvertorTest {

	@Test
	public void 쉼표_기준으로_이름_분리() {
		//given
		String names = "pobi,crong,honux";
		//when
		String[] nameArray = Convertor.separate(names);
		//then
		assertArrayEquals(nameArray, new String[] {"pobi", "crong", "honux"});
	}
}