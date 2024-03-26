public class ConsoleView {
    public void printRequestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void printRequestTryNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printRaceResult() {
        System.out.println("\n실행 결과");
    }

    public void printCarPosition(String name, int position) {
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printWinners(String winners) {
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}

