package cal.JSEngineCal;

import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Main {
    public static void main(String[] args) throws ScriptException {
        ScriptEngine engine = getScriptEngine();
        String[] input = getStrings();
        int result = getResult(engine, input);
        System.out.println(result);
    }

    private static ScriptEngine getScriptEngine() {
        ScriptEngineManager mgr = new ScriptEngineManager();
        return mgr.getEngineByName("JavaScript");
    }

    private static String[] getStrings() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().split(" ");
    }

    private static int getResult(ScriptEngine engine, String[] input) throws ScriptException {
        int result = Integer.parseInt(input[0]);
        for (int i = 1; i < input.length; i += 2) {
            Object obj = engine.eval(String.format("%d %s %s", result, input[i], input[i + 1]));
            result = Integer.valueOf(obj.toString());
        }
        return result;
    }
}
