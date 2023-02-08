package view;

public class InputView {

    private static final String inputCarNameMessage = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String inputTryCountMessage = "시도할 회수는 몇회인가요?";

    public void printInputCarNameGuide() {
        System.out.println(inputCarNameMessage);
    }

    public void printInputTryCountGuide() {
        System.out.println(inputTryCountMessage);
    }
}
