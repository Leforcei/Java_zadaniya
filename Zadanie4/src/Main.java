import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Car[] cars = {
                new Car(1, "Toyota", "Camry", 2015, "Белый", 15000, "A123BC"),
                new Car(2, "BMW", "X5", 2018, "Черный", 35000, "B456DE"),
                new Car(3, "Audi", "A4", 2012, "Красный", 12000, "C789FG"),
                new Car(4, "Toyota", "Corolla", 2010, "Синий", 8000, "D234HI"),
                new Car(5, "BMW", "3 Series", 2020, "Серый", 40000, "E567JK")
        };

        System.out.println("\nАвтомобили заданной марки (Toyota):");
        printCarsByBrand(cars, "Toyota");

        System.out.println("\nАвтомобили модели Camry, старше 5 лет:");
        printCarsByModelAndAge(cars, "Camry", 5);

        System.out.println("\nАвтомобили 2012 года выпуска, дороже 10000:");
        printCarsByYearAndPrice(cars, 2012, 10000);
    }

    public static void printCarsByBrand(Car[] cars, String brand) {
        Arrays.stream(cars)
                .filter(car -> car.getBrand().equalsIgnoreCase(brand))
                .forEach(System.out::println);
    }

    public static void printCarsByModelAndAge(Car[] cars, String model, int years) {
        int currentYear = java.time.Year.now().getValue();
        Arrays.stream(cars)
                .filter(car -> car.getModel().equalsIgnoreCase(model) && (currentYear - car.getYear()) > years)
                .forEach(System.out::println);
    }

    public static void printCarsByYearAndPrice(Car[] cars, int year, double minPrice) {
        Arrays.stream(cars)
                .filter(car -> car.getYear() == year && car.getPrice() > minPrice)
                .forEach(System.out::println);
    }
}