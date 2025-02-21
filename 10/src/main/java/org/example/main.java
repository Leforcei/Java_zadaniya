import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseManager.connect();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n📌 Выберите действие:");
            System.out.println("1️⃣ Добавить пользователя");
            System.out.println("2️⃣ Редактировать пользователя");
            System.out.println("3️⃣ Удалить пользователя");
            System.out.println("4️⃣ Показать всех пользователей");
            System.out.println("5️⃣ Выйти");
            System.out.print("👉 Введите номер: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1:
                    System.out.print("Введите имя: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите возраст: ");
                    int age = scanner.nextInt();
                    DatabaseManager.addUser(name, age);
                    break;
                case 2:
                    System.out.print("Введите ID пользователя: ");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Введите новое имя: ");
                    String newName = scanner.nextLine();
                    System.out.print("Введите новый возраст: ");
                    int newAge = scanner.nextInt();
                    DatabaseManager.updateUser(idToUpdate, newName, newAge);
                    break;
                case 3:
                    System.out.print("Введите ID пользователя для удаления: ");
                    int idToDelete = scanner.nextInt();
                    DatabaseManager.deleteUser(idToDelete);
                    break;
                case 4:
                    DatabaseManager.showUsers();
                    break;
                case 5:
                    System.out.println("👋 Выход...");
                    scanner.close();
                    return;
                default:
                    System.out.println("⚠️ Неверный ввод! Попробуйте снова.");
            }
        }
    }
}