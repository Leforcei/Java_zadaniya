import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество чисел: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Ошибка: количество чисел должно быть больше 0.");
            return;
        }

        System.out.print("Введите число 1: ");
        int num = scanner.nextInt();
        int min = num, max = num;

        for (int i = 2; i <= n; i++) {
            System.out.print("Введите число " + i + ": ");
            num = scanner.nextInt();

            if (num < min) min = num;
            if (num > max) max = num;
        }

        System.out.println("Наименьшее число: " + min);
        System.out.println("Наибольшее число: " + max);

        scanner.close();
    }
}