package view;

public class OutputView {

    public void printResultHeader(){
        System.out.println("실행 결과");
    }

    public void printResult(String totalMovementDetails) {
        System.out.println(totalMovementDetails);
    }

    public void printWinner(String winners) {
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
