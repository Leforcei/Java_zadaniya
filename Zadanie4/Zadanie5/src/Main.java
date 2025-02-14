public class Main {
    public static void main(String[] args) {
        Square square = new Square(new Point(0, 0), 4, "Blue");
        System.out.println("Исходный квадрат: " + square);

        square.resize(1.5);
        System.out.println("После увеличения: " + square);

        square.changeColor("Red");
        System.out.println("После смены цвета: " + square);
    }
}