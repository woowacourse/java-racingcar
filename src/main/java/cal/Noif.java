package cal;

import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Noif {
    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");

        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");

        int result = Integer.parseInt(input[0]);
        for (int i = 1; i < input.length; i += 2) {
            Object obj = engine.eval(String.format("%d %s %s", result, input[i], input[i + 1]));
            result = Integer.valueOf(obj.toString());
        }
        System.out.println(result);
    }
}
