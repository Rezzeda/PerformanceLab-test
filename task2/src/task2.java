import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class task2 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Должно быть 2 файла: circle.txt и points.txt");
            return;
        }

        String circleFilePath = args[0];
        String pointsFilePath = args[1];

        try {
            // считываем координаты центра окружности и радиус
            Scanner circleScanner = new Scanner(new File(circleFilePath));
            double circleX = circleScanner.nextDouble();
            double circleY = circleScanner.nextDouble();
            double radius = circleScanner.nextDouble();
            circleScanner.close();

            // считываем координаты точек
            Scanner pointsScanner = new Scanner(new File(pointsFilePath));

            while (pointsScanner.hasNext()) {
                double pointX = pointsScanner.nextDouble();
                double pointY = pointsScanner.nextDouble();

                // расстояние от точки до центра окружности
                double distance = Math.sqrt(Math.pow(pointX - circleX, 2) + Math.pow(pointY - circleY, 2));

                if (distance < radius) {
                    System.out.println(1); // точка внутри окружности
                } else if (distance == radius) {
                    System.out.println(0); // точка на окружности
                } else {
                    System.out.println(2); // точка снаружи окружности
                }
            }

            pointsScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}