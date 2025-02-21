import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCounter {
    public static void main(String[] args) {
        // Путь к файлу
        String filePath = "text.txt";

        String[] wordsToFind = {"слово1", "слово2", "слово3"};

        try {
            // Читаем содержимое файла
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            String content = String.join(" ", lines).toLowerCase(); // Приводим к нижнему регистру

            // Подсчет вхождений слов
            Map<String, Integer> wordCounts = new HashMap<>();
            for (String word : wordsToFind) {
                int count = countOccurrences(content, word);
                wordCounts.put(word, count);
            }

            StringBuilder result = new StringBuilder("[");
            for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
                result.append(entry.getKey()).append("-").append(entry.getValue()).append(", ");
            }
            if (!wordCounts.isEmpty()) {
                result.setLength(result.length() - 2); // Удаляем лишнюю запятую
            }
            result.append("]");

            System.out.println(result);

        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    private static int countOccurrences(String text, String word) {
        String[] words = text.split("[\\s.,!?\"()]+"); // Разбиваем текст на слова
        int count = 0;
        for (String w : words) {
            if (w.equals(word)) {
                count++;
            }
        }
        return count;
    }
}