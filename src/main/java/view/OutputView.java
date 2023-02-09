package view;

import dto.response.CarStatusDto;
import dto.response.WinnersNameDto;

import java.util.List;

public class OutputView {
    public void printEachRound(List<CarStatusDto> carStatusDtos) {
        carStatusDtos.forEach(carStatusDto -> printEachCarStatus(carStatusDto));
        System.out.println("");
    }

    public void printWinners(WinnersNameDto winnersNameDto) {
        System.out.println(getFormattedName(winnersNameDto.getWinnersNames()) + "가 최종 우승했습니다.");
    }

    private void printEachCarStatus(CarStatusDto carStatusDto) {
        System.out.println(carStatusDto.getName() + " : " + "-".repeat(carStatusDto.getPosition()));
    }

    private String getFormattedName(List<String> names) {
        return String.join(", ", names);
    }
}
