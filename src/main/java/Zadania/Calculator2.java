package Zadania;

public class Calculator2 {
    /*
Rozszerz klasę Calculator tak, żeby przyjmowała wartości typu Integer zamiast int.
Jeśli któryś z argumentów == null -> rzucamy wyjątek z odpowiednią wiadomością. Jeśli dzielnik == 0 -> rzucamy wyjątek z odpowiednią wiadomością.
Utwórz nową klasę z testami ExceptionsCalculatorTest.
W tej klasie użyj wszystkich trzech poznanych sposobów na testowanie wyjątków.
     */

    public static void main(String[] args) {

    }

    public  int sum(Integer czynnik1, Integer czynnik2) {
        if (czynnik1==null||czynnik2==null) throw new IllegalArgumentException("Adding non integer digits");
        return czynnik1 + czynnik2;
    }

    public  int substract(Integer czynnik1, Integer czynnik2) {
        return czynnik1 - czynnik2;
    }

    public  int multiply(Integer czynnik1, Integer czynnik2) {
        return czynnik1 * czynnik2;
    }

    public  int divide(Integer dzielna, Integer dzielnik) {
        if (dzielnik==null||dzielna==null) throw new IllegalArgumentException("Zle dane");
                if(dzielnik==0) throw new ArithmeticException("Dzielenie przez 0 - ERROR!");
       // if (czynnik1==null||czynnik2==null) throw new IllegalArgumentException("Adding non integer digits");
        return dzielna / dzielnik;
    }
}

