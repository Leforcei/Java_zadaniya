import java.util.Scanner;

class Car { // Класс Car остаётся в Main.java
    private int id;
    private String brand;
    private String model;
    private int year;
    private String color;
    private double price;
    private String regNumber;

    public Car(int id, String brand, String model, int year, String color, double price, String regNumber) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.regNumber = regNumber;
    }

    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "Car{id=" + id + ", brand='" + brand + "', model='" + model +
                "', year=" + year + ", color='" + color +
                "', price=" + price + ", regNumber='" + regNumber + "'}";
    }
}

public class Main {
    public static void main(String[] args) {
        Car[] cars = {
                new Car(1, "Toyota", "Camry", 2015, "Белый", 15000, "A123BC"),
                new Car(2, "BMW", "X5", 2018, "Черный", 35000, "B456DE"),
                new Car(3, "Audi", "A4", 2012, "Красный", 12000, "C789FG"),
                new Car(4, "Toyota", "Corolla", 2010, "Синий", 8000, "D234HI"),
                new Car(5, "BMW", "3 Series", 2020, "Серый", 40000, "E567JK")
        };

        printCarsByBrand(cars, "Toyota");
        printCarsByModelAndAge(cars, "Camry", 5);
        printCarsByYearAndPrice(cars, 2012, 10000);
    }

    public static void printCarsByBrand(Car[] cars, String brand) {
        System.out.println("\nАвтомобили марки " + brand + ":");
        for (Car car : cars) {
            if (car.getBrand().equalsIgnoreCase(brand)) {
                System.out.println(car);
            }
        }
    }

    public static void printCarsByModelAndAge(Car[] cars, String model, int years) {
        int currentYear = java.time.Year.now().getValue();
        System.out.println("\nАвтомобили модели " + model + ", которым больше " + years + " лет:");
        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(model) && (currentYear - car.getYear()) > years) {
                System.out.println(car);
            }
        }
    }

    public static void printCarsByYearAndPrice(Car[] cars, int year, double minPrice) {
        System.out.println("\nАвтомобили " + year + " года, с ценой выше " + minPrice + ":");
        for (Car car : cars) {
            if (car.getYear() == year && car.getPrice() > minPrice) {
                System.out.println(car);
            }
        }
    }
}