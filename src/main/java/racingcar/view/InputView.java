package racingcar.view;

import racingcar.util.InputHandler;

import java.util.Scanner;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    public static String[] inputCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return validateNames(sc.nextLine());
    }

    public static String[] validateNames(String s){
        String[] names = s.split(",");

        InputHandler.validateCarCount(names.length);

        for(String name : names){
            InputHandler.validateNullOrEmpty(name);
            InputHandler.validateNameLength(name);
        }
        return names;
    }

}
