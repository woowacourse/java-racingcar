package racingcargame.view;

import com.sun.corba.se.impl.io.TypeMismatchException;
import org.omg.IOP.CodecPackage.TypeMismatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputNames() {
        return scanner.nextLine();
    }

    public static int inputRepeat() {
        return scanner.nextInt();
    }
}
