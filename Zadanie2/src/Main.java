import java.util.Scanner;

public class Main {
    // Метод для проверки, является ли число палиндромом
    public static boolean isPalindrome(int num) {
        int original = num, reversed = 0;
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return original == reversed;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество чисел: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Ошибка: количество чисел должно быть больше 0.");
            return;
        }

        int firstPalindrome = -1, secondPalindrome = -1;

        System.out.println("Введите числа:");
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            if (isPalindrome(num)) {
                if (firstPalindrome == -1) {
                    firstPalindrome = num;
                } else if (secondPalindrome == -1) {
                    secondPalindrome = num;
                }
            }
        }

        if (firstPalindrome == -1) {
            System.out.println("Палиндромов не найдено.");
        } else if (secondPalindrome == -1) {
            System.out.println("Найден только один палиндром: " + firstPalindrome);
        } else {
            System.out.println("Первый палиндром: " + firstPalindrome);
            System.out.println("Второй палиндром: " + secondPalindrome);
        }

        scanner.close();
    }
}