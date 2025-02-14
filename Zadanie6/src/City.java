import java.util.ArrayList;
import java.util.List;

// Город
public class City {
    private String name;
    private List<Place> places;

    public City(String name) {
        this.name = name;
        this.places = new ArrayList<>();
    }

    //класс Место Проспект, Улица, Площадь
    public class Place {
        private String type;
        private String name;
        private double latitude;  // Широта
        private double longitude; // Долгота

        public Place(String type, String name, double latitude, double longitude) {
            this.type = type;
            this.name = name;
            this.latitude = latitude;
            this.longitude = longitude;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return type + " " + name + " (Координаты: " + latitude + ", " + longitude + ")";
        }
    }

    // Добавления места с координатами
    public void addPlace(String type, String name, double latitude, double longitude) {
        places.add(new Place(type, name, latitude, longitude));
    }

    // Поиск улицы по названию
    public Place findPlace(String name) {
        for (Place place : places) {
            if (place.getName().equalsIgnoreCase(name)) {
                return place;
            }
        }
        return null;
    }

    // Метод для удаления места по названию
    public boolean removePlace(String name) {
        return places.removeIf(place -> place.getName().equalsIgnoreCase(name));
    }

    // Метод для вывода списка мест
    public void showPlaces() {
        System.out.println("Город: " + name);
        for (Place place : places) {
            System.out.println("- " + place);
        }
    }

    // Тест 123 123
    public static void main(String[] args) {
        City city = new City("Москва");

        // Добавляем места
        city.addPlace("Проспект", "Ленинский", 55.7075, 37.5783);
        city.addPlace("Улица", "Тверская", 55.7587, 37.6151);
        city.addPlace("Площадь", "Красная", 55.7539, 37.6208);

        city.showPlaces();

        // Поиск улицы
        System.out.println("\nПоиск улицы 'Тверская':");
        Place found = city.findPlace("Тверская");
        if (found != null) {
            System.out.println("Найдено: " + found);
        } else {
            System.out.println("Улица не найдена.");
        }

        // Удаление улицы
        System.out.println("\nУдаляем 'Тверская':");
        if (city.removePlace("Тверская")) {
            System.out.println("Удалено успешно.");
        } else {
            System.out.println("Не найдено.");
        }

        // Вывод список после удаления
        System.out.println("\nОбновленный список мест:");
        city.showPlaces();
    }
}