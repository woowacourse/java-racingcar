package view;

import domain.Const;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Heebg
 * User: heebg
 * Date: 2019-05-08
 */
public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String inputCarNames() {
        System.out.println(Const.INPUT_CAR_NAME);
        return SCANNER.nextLine();
    }

    public static int inputRoundCount() {
        try{
            System.out.println(Const.INPUT_ROUND_CNT);
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e){
            System.out.println(Const.EX_ROUND_COUNT);
            return inputRoundCount();
        }
    }
}
