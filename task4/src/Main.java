import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // проверка на наличие аргумента командной строки
        if (args.length != 1) {
            System.out.println("Нужен файл input.txt");
            return;
        }

        String inputFile = args[0];
        List<Integer> numbers = new ArrayList<>();

        // чтение данных из файла
        try (Scanner scanner = new Scanner(new File(inputFile))) {
            while (scanner.hasNextInt()) {
                numbers.add(scanner.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден" + inputFile);
            return;
        }

        if (numbers.isEmpty()) {
            System.out.println("Неправильно введены данные");
            return;
        }

        // нахождение медианы
        Collections.sort(numbers);
        int median;
        int n = numbers.size();
        if (n % 2 == 0) {
            median = (numbers.get(n / 2 - 1) + numbers.get(n / 2)) / 2;
        } else {
            median = numbers.get(n / 2);
        }

        // подсчет минимального количества ходов
        int moves = 0;
        for (int num : numbers) {
            moves += Math.abs(num - median);
        }

        // вывод результата в консоль
        System.out.println("Минимальное количество ходов: "+ moves);
    }
}
