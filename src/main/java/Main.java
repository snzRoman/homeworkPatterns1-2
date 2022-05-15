import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");

        System.out.println("Введите размер списка:");
        Scanner scanner = new Scanner(System.in);
        int listSize = scanner.nextInt();
        System.out.println("Введите верхнюю границу для значений:");
        int maxValue = scanner.nextInt();

        logger.log("Создаём и наполняем список");
        List<Integer> ourList = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            ourList.add(new Random().nextInt(maxValue));
        }
        System.out.print("Вот случайный список: ");
        ourList.stream()
                .map(value -> value.toString() + " ")
                .forEach(System.out::print);
        System.out.println();

        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.println("Введите порог для фильтра: ");
        int treshold = scanner.nextInt();
        logger.log("Запускаем фильтрацию");

        Filter filter = new Filter(treshold);
        List<Integer> result = filter.filterOut(ourList);
        logger.log("Прошло фильтр " + result.size() + " элемента из " + listSize);
        logger.log("Выводим результат на экран");
        System.out.println("Отфильтрованный список: ");
        result.stream()
                .map(value -> value.toString() + " ")
                .forEach(System.out::print);
        System.out.println();


        logger.log("Завершаем программу");
    }
}
