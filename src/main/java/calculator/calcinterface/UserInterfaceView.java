package calculator.calcinterface;

import java.util.Scanner;

public class UserInterfaceView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public String inputFormula() {
        return SCANNER.nextLine();
    }

    public String[] splitFormula(String formula) {
        return formula.split(" ");
    }

    public void outputResult(int result){
        System.out.println(result);
    }
}
