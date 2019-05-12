package cal.strCal;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StrCalculator {
    private Scanner sc = new Scanner(System.in);

    public List<String> getInput() {
        return Arrays.asList(sc.nextLine().split(" "));
    }

    public int calculate(List<String> input) {
        return 0;
    }

}
