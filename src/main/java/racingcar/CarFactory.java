package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
	public static List<Car> of(String names) {
		return Arrays.stream(names.split(","))
			.map(name -> new Car(name.trim()))
			.collect(Collectors.toList());
	}
}
