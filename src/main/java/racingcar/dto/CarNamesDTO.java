package racingcar.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNamesDTO {
	private final List<String> carNames = new ArrayList<>();

	public CarNamesDTO(String carNames) {
		this.carNames.addAll(splitByComma(carNames));
	}

	private List<String> splitByComma(String carNames) {
		String[] splitCarNames = carNames.split("\\s*,\\s*");
		return Arrays.stream(splitCarNames).collect(Collectors.toList());
	}
}
