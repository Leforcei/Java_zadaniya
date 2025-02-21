import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TextCleaner {
    public static void main(String[] args) {
        String filePath = "text.txt";

        try {
            // Читаем весь текст из файла
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            // Вводим символы, между которыми удаляем текст
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите начальный символ: ");
            char startChar = scanner.next().charAt(0);
            System.out.print("Введите конечный символ: ");
            char endChar = scanner.next().charAt(0);
            scanner.close();

            // Удаляем текст между символами
            String regex = Pattern.quote(String.valueOf(startChar)) + ".*?" + Pattern.quote(String.valueOf(endChar));
            String cleanedText = content.replaceAll(regex, "");

            // Выводим результат
            System.out.println("Очищенный текст:");
            System.out.println(cleanedText);

        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
    }
}