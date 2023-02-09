package view;

import domain.CarDTO;
import java.util.List;

public class OutputView {
    //TODO : 적절한 네이밍 변경하기
    public void printResultTitle() {
        System.out.println("실행 결과");
    }

    public void printStatus(List<CarDTO> cars) {
        for (CarDTO car : cars) {
            String status = String.format("%s : %s", car.name, "-".repeat(car.position));
            System.out.println(status);
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.print(String.join(", ", winners));
        System.out.print("가 최종 우승했습니다.");
    }
}
