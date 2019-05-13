package cal.string;

enum Operators {
    PLUS("+", 0), MINUS("-", 1), DIV("/", 2), MUL("*", 3);
    public String operator;
    public int constant;

    Operators(String operator, int constant) {
        this.operator = operator;
        this.constant = constant;
    }
}

public class Operation {
    public static int getOperator(String inputOperator) {
        for(Operators o : Operators.values()){
            if(inputOperator.equals(o.operator)){
                return o.constant;
            }
        }
        throw new IllegalArgumentException();
    }

    public static int makeFormular(int a, int b, int op) {
        if (op == Operators.PLUS.constant) {
            return a + b;
        }
        if (op == Operators.MINUS.constant) {
            return a - b;
        }
        if (op == Operators.DIV.constant) {
            return a / b;
        }
        if (op == Operators.MUL.constant) {
            return a * b;
        }

        throw new IllegalArgumentException();
    }
}
