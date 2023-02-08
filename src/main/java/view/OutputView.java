package view;

import dto.CarStatusDto;

import java.util.List;

public class OutputView {
    void printEachRound(List<CarStatusDto> carStatusDtos) {
        carStatusDtos.forEach(carStatusDto -> printEachCarStatus(carStatusDto));
        System.out.println("");
    }

    private static void printEachCarStatus(CarStatusDto carStatusDto) {
        System.out.println(carStatusDto.getName() + " : " + "-".repeat(carStatusDto.getPosition()));
    }
}
