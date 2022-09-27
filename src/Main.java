import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.instance.getCalc();

        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1, 1);
        int c = calc.devide.apply(a, b);
        calc.println.accept(c);
        /* ArithmeticException —
        базовый класс для следующих исключений:
        DivideByZeroException, который вызывается в
        целочисленном делении, если делитель равен 0. */
    }
}

interface Supplier<Calculator> {
    Calculator getCalc();
}

class Calculator implements Supplier {
    static Supplier<Calculator> instance = Calculator::new;

    @Override
    public Calculator getCalc() {
        return (Calculator) instance;
    }

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> devide = (x, y) -> {
        if (y != 0) return x / y;
        else return 0;
    };
    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;
    Predicate<Integer> isPositive = x -> x > 0;
    Consumer<Integer> println = System.out::println;
}