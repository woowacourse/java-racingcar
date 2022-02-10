package racingcar;

import java.util.Scanner;

public class InputView {
    public String readCarNamesInput(){
        Scanner scanner=new Scanner(System.in);
        return scanner.nextLine();
    }

    public int readRoundNumberInput(){
        Scanner scanner=new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }
}
