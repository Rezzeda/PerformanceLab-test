import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        System.out.print("Задайте массив от 1 до n: ");
//        int n = scanner.nextInt();
//
//        System.out.print("Введите длину обхода m: ");
//        int m = scanner.nextInt();
//
//        if (n <= 0 || m <= 0) {
//            System.out.println("Числа m и n должны быть натуральными");
//            return;
//        }

        int n = 0;
        int m = 0;

        while (true) {
            System.out.print("Задайте массив от 1 до n: ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n > 0) {
                    break;
                } else {
                    System.out.println("Число n должно быть натуральным");
                }
            } else {
                System.out.println("Введите верную длину массива n:");
                scanner.next();
            }
        }

        while (true) {
            System.out.print("Введите длину обхода m: ");
            if (scanner.hasNextInt()) {
                m = scanner.nextInt();
                if (m > 0) {
                    break;
                } else {
                    System.out.println("Число m должно быть натуральным");
                }
            } else {
                System.out.println("Введите верную длину обхода m: ");
                scanner.next();
            }
        }

        int[] circularArray = new int[n];
        for (int i = 0; i < n; i++) {
            circularArray[i] = i + 1;
        }

        // выводим массив
//        System.out.println(Arrays.toString(circularArray));

        StringBuilder path = new StringBuilder();
        int currentIndex = 0;

        do {
            path.append(circularArray[currentIndex]);
            currentIndex = (currentIndex + (m-1)) % n;
        } while (currentIndex != 0);

        System.out.println("Путь: " + path);
    }
}