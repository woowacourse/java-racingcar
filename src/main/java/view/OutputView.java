package view;

import dto.response.CarStatusDto;
import dto.response.WinnersNameDto;

import java.util.List;

public class OutputView {

    private static final String POSITION_MARK = "-";

    public void printGameResult(List<List<CarStatusDto>> result) {
        result.forEach(this::printEachRoundResult);
    }

    private void printEachRoundResult(List<CarStatusDto> carStatusDtos) {
        carStatusDtos.forEach(this::printEachCarsPosition);
        System.out.println("");
    }

    private void printEachCarsPosition(CarStatusDto carStatusDto) {
        System.out.println(carStatusDto.getName() + " : " + POSITION_MARK.repeat(carStatusDto.getPosition()));
    }

    public void printWinners(WinnersNameDto winnersNameDto) {
        System.out.println(getFormattedName(winnersNameDto.getWinnersNames()) + "가 최종 우승했습니다.");
    }

    private String getFormattedName(List<String> names) {
        return String.join(", ", names);
    }
}
