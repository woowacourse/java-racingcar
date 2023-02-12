package car.view;


import java.util.List;
import java.util.stream.Collectors;

import car.domain.CarDto;

public class OutputView {

    private static final String CAR_INFIX = " : ";
    private static final String POSITION_CHARACTER = "-";
    private static final String WINNER_DELIMITER = ", ";
    public void noticeResult() {
        System.out.println("실행 결과");
    }

    public void printCarsWith(List<CarDto> cars) {
        cars.stream().forEach(car -> printTrackWith(car));
        System.out.println();
    }

    private void printTrackWith(CarDto car) {
        System.out.print(car.getName() + CAR_INFIX);
        System.out.println(POSITION_CHARACTER.repeat(car.getPosition()));
    }


    public void printWinnersWith(List<CarDto> winners) {
        String joinedNames = String.join(WINNER_DELIMITER, getCarNameOf2(winners));
        System.out.println(joinedNames + "가 최종 우승했습니다.");
    }

    private List<String> getCarNameOf2(List<CarDto> cars) {
        return cars.stream()
                .map(CarDto::getName)
                .collect(Collectors.toList());
    }
}
