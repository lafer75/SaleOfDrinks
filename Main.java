import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class Main {

    private final static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        Map<Drinks, Integer> result = new HashMap<Drinks, Integer>();

        int totalPrice = 0;

        while (true) {
            System.out.println("Что желаете: ");

            System.out.println(Arrays.deepToString(Drinks.values()));

            Drinks drink = userInput(Drinks::valueOf);

            System.out.println("Ваш выбор : " + drink + "; Цена : " + drink.getPrice()+"₴");

            System.out.println("Выберите количесто : ");

            Integer drinkNumber = userInput(Integer::valueOf);

            System.out.println("Может что-то еще?(Y для согдасия, Enter для счёта) ?");

            if (result.containsKey(drink)) result.put(drink,
                    result.get(drink)
                            + drinkNumber);

            else result.put(drink, drinkNumber);

            if (!"Y".equalsIgnoreCase(userInput(String::valueOf))) break;
        }
        System.out.println("***************************************");


        for (Drinks drink : result.keySet())
        {
            System.out.println(drink + "(" + result.get(drink) + ") ---> " + result.get(drink) * drink.getPrice()+"₴");

            totalPrice += result.get(drink) * drink.getPrice();
        }
        System.out.println("Общая стоимость всех напитков : " + totalPrice+"₴");
    }

    private static <T> T userInput(Function<String, T> function) {
        while (true) {
            try {
                return function.apply(scan.nextLine().trim().toUpperCase());
            } finally {}
        }
    }

}
