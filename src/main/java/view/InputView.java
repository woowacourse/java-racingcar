package view;

public class InputView {
    public InputView() {
    }

    public void requestCarName () {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void requestAttemptLimit() {
        System.out.println("시도할 회수는 몇회인가요?");
    }
}
