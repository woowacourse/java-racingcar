package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RacingGame {
    public static Scanner sc = new Scanner(System.in);
    private ArrayList<String> carNames;

    private String input(){
        return sc.nextLine();
    }

    private void inputNames() {
        String names = input();
        carNames = new ArrayList<>(Arrays.asList(names.split(",")));
    }
}
