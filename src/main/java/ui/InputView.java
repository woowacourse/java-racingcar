package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public List<String> requestCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNameLine = scanner.nextLine();
        StringTokenizer tokenizer = new StringTokenizer(carNameLine, ",");
        List<String> carNames = new ArrayList<>();
        while (tokenizer.hasMoreTokens()){
            carNames.add(tokenizer.nextToken());
        }
        return carNames;
    }
}
