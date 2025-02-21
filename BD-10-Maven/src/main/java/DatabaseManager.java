import java.sql.*;

public class DatabaseManager {
    private static final String URL = "jdbc:sqlite:database.db";

    public static void connect() {
        try (Connection conn = DriverManager.getConnection(URL)) {
            if (conn != null) {
                System.out.println("Подключение к базе данных успешно!");
                createTable();
            }
        } catch (SQLException e) {
            System.out.println("Ошибка подключения: " + e.getMessage());
        }
    }

    private static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL, " +
                "age INTEGER NOT NULL)";
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Таблица создана или уже существует.");
        } catch (SQLException e) {
            System.out.println("Ошибка создания таблицы: " + e.getMessage());
        }
    }

    public static void addUser(String name, int age) {
        String sql = "INSERT INTO users(name, age) VALUES(?, ?)";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.executeUpdate();
            System.out.println("Пользователь добавлен: " + name);
        } catch (SQLException e) {
            System.out.println("Ошибка добавления пользователя: " + e.getMessage());
        }
    }

    public static void updateUser(int id, String newName, int newAge) {
        String sql = "UPDATE users SET name = ?, age = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newName);
            pstmt.setInt(2, newAge);
            pstmt.setInt(3, id);
            int updated = pstmt.executeUpdate();
            if (updated > 0) {
                System.out.println("Пользователь обновлён: ID " + id);
            } else {
                System.out.println("Пользователь не найден.");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка обновления: " + e.getMessage());
        }
    }

    public static void deleteUser(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int deleted = pstmt.executeUpdate();
            if (deleted > 0) {
                System.out.println("Пользователь удалён: ID " + id);
            } else {
                System.out.println("Пользователь не найден.");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка удаления: " + e.getMessage());
        }
    }

    public static void showUsers() {
        String sql = "SELECT * FROM users";
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("📋 Список пользователей:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        " | Имя: " + rs.getString("name") +
                        " | Возраст: " + rs.getInt("age"));
            }
        } catch (SQLException e) {
            System.out.println("Ошибка вывода данных: " + e.getMessage());
        }
    }
}