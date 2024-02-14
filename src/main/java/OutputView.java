import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public void showResult(Winners rawWinners) { //TODO: formatter로 넣든지, dto 쓸것!
        List<Car> winners = rawWinners.getWinners();
        String result = winners.stream()
                .map(winner -> winner.getName())
                .collect(Collectors.joining(","));
        System.out.println(result + "가 최종 우승했습니다.");
    }

    public void showStatus(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
        System.out.println();
    }

    public void showStatusMessage() {
        System.out.println("실행 결과");
    }
}
