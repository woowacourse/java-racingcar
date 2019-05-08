package domain;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String[] inputCarNameList(){
        System.out.println(Const.INPUT_CAR_NAME);
        return SCANNER.nextLine().split(",");
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
