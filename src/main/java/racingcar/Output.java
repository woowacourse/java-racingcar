package racingcar;

import java.util.List;

public class Output {

    public void inputCarNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void inputCoinMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void printPosition(List<Car> cars) {
        for (Car car : cars) {
            String position = makePositionString(car.getPosition());
            System.out.printf("%-5s : %s\n", car.getName(), position);
        }
        System.out.println();
    }

    private String makePositionString(int position) {
        String positionFlag = "-";
        return positionFlag.repeat(position);
    }

    public void printWinner(List<String> winnerNames) {
        System.out.print(String.join(", ", winnerNames));
        System.out.println("가 최종 우승했습니다.");
    }
}
