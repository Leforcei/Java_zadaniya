import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

//исключение
class InvalidNumberFormatException extends Exception {
    public InvalidNumberFormatException(String message) {
        super(message);
    }
}

public class NumberProcessor {
    public static void main(String[] args) {
        String filePath = "numbers.txt";

        try {
            List<Double> numbers = readNumbersFromFile(filePath);
            if (numbers.isEmpty()) {
                throw new InvalidNumberFormatException("Файл не содержит корректных чисел.");
            }

            double sum = numbers.stream().mapToDouble(Double::doubleValue).sum();
            double average = sum / numbers.size();

            System.out.println("Сумма чисел: " + sum);
            System.out.println("Среднее значение: " + average);

        } catch (InvalidNumberFormatException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка: Файл не найден.");
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        } catch (OutOfMemoryError e) {
            System.err.println("Ошибка: Недостаточно памяти для обработки файла.");
        }
    }

    private static List<Double> readNumbersFromFile(String filePath) throws IOException {
        List<Double> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    numbers.add(parseNumber(line));
                } catch (InvalidNumberFormatException e) {
                    System.err.println("Пропущено некорректное значение: " + line);
                }
            }
        }
        return numbers;
    }

    private static Double parseNumber(String str) throws InvalidNumberFormatException {
        Locale[] locales = {Locale.US, Locale.GERMANY, Locale.FRANCE};
        for (Locale locale : locales) {
            try {
                NumberFormat format = NumberFormat.getInstance(locale);
                return format.parse(str).doubleValue();
            } catch (ParseException ignored) {
            }
        }
        throw new InvalidNumberFormatException("Некорректный формат числа: " + str);
    }
}