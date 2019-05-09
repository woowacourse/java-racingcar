package view;

import domain.Const;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<String> inputCarNameList(){
        System.out.println(Const.INPUT_CAR_NAME);
        return Arrays.asList(SCANNER.nextLine().split(","));
    }

    public static int inputRoundCount(){
        try{
            System.out.println(Const.INPUT_ROUND_CNT);
            return SCANNER.nextInt();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputRoundCount();
        }
    }
}
