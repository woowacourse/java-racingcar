package car;

import java.util.Scanner;

public class InputView {
    
    private static final String CAR_NAMES_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    
    private static final String ROUND_QUESTION = "시도할 회수는 몇회인가요?";
    
    private final Scanner scanner;
    
    public InputView() {
        this.scanner = new Scanner(System.in);
    }
    
    public String readCarNames() {
        return read(CAR_NAMES_QUESTION);
    }
    
    public int readRound() {
        return Integer.parseInt(read(ROUND_QUESTION));
    }
    
    private String read(String question) {
        System.out.println(question);
        
        return scanner.nextLine();
    }
}
