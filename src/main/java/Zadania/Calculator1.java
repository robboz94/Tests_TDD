package Zadania;

public class Calculator1 {
    /*
Zadania do samodzielnego wykonania
Utwórz klasę Calculator w której zaimplementujesz działania +, -, *, / (add, substract, multiply, divide).
Następnie utwórz klasę CalculatorTest w której przetestujesz powyższe metody.
     */
    public static void main(String[] args) {

    }

    public  int sum(int a, int b) {
        return a + b;
    }

    public  int substract(int a, int b) {
        return a - b;
    }

    public  int multiply(int a, int b) {
        return a * b;
    }

    public  int divide(int a, int b) {
        if (b < 0) return 0;
        return a / b;
    }
}

