package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.client.OutputClient;
import racingcar.dto.CarDTO;

public class OutputView {

    private static final String CAR_DELIMITER = " : ";
    private static final String CAR_PROGRESS = "-";
    private static final String WINNER_DELIMITER = ", ";

    private final OutputClient outputClient;

    public OutputView(OutputClient outputClient) {
        this.outputClient = outputClient;
    }

    public void printProcessPrompt() {
        outputClient.output("실행 결과\n");
    }

    public void printCarsPosition(List<CarDTO> dtos) {
        dtos.forEach(this::printCarPosition);
        outputClient.output("\n");
    }

    private void printCarPosition(CarDTO dto) {
        outputClient.output(dto.getName() + CAR_DELIMITER);
        for (int i = 0; i < dto.getPosition(); i++) {
            outputClient.output(CAR_PROGRESS);
        }
        outputClient.output("\n");
    }

    public void printWinners(List<CarDTO> dtos) {
        List<String> nameList = toNames(dtos);
        System.out.println(String.join(WINNER_DELIMITER, nameList) + "가 최종 우승했습니다.\n");
    }

    private List<String> toNames(List<CarDTO> dtos) {
        return dtos.stream()
            .map(CarDTO::getName)
            .collect(Collectors.toList());
    }

}
