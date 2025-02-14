class Car {
    private int id;
    private String brand;
    private String model;
    private int year;
    private String color;
    private double price;
    private String regNumber;

    // Конструктор с полными данными
    public Car(int id, String brand, String model, int year, String color, double price, String regNumber) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.regNumber = regNumber;
    }

    // Конструктор без регистрационного номера
    public Car(int id, String brand, String model, int year, String color, double price) {
        this(id, brand, model, year, color, price, "Не указан");
    }

    // Сеттеры
    public void setPrice(double price) { this.price = price; }
    public void setColor(String color) { this.color = color; }

    // Геттеры
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