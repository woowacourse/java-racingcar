package racingcar.view;

import java.util.List;

import racingcar.dto.CarDTO;
import racingcar.dto.RoundResultDTO;

public class OutputView {
	private static final String RESULT_MESSAGE = "실행결과";
	private static final String PATH = "-";
	public void printResultMessage() {
		System.out.println(RESULT_MESSAGE);
	}
	public void printRoundResult(RoundResultDTO roundResultDTO) {
		List<CarDTO> carDTOs = roundResultDTO.getRoundResult();
		for (CarDTO carDTO : carDTOs) {
			String carName = carDTO.getCarName();
			int carPosition = carDTO.getCarPosition();
			String carPath = createCarPath(carPosition);
			System.out.printf("%s : %s %s", carName, carPath, System.lineSeparator());

		}
	}

	private String createCarPath(int carPosition) {
		StringBuilder carPath = new StringBuilder();
		for (int length = 0; length < carPosition; length++) {
			carPath.append(PATH);
		}

		return carPath.toString();
	}

}
