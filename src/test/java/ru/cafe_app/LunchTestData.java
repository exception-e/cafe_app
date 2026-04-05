package ru.cafe_app;

import ru.cafe_app.model.Lunch;

import java.util.List;

public class LunchTestData {

    public static final Lunch lunch13 = new Lunch(100013, "Фри", 15000, 100008 );
    public static final Lunch lunch14 = new Lunch(100014,"Бургер", 40000, 100008);
    public static final Lunch lunch15 = new Lunch(100015, "Кола", 10000, 100008);
    public static final Lunch lunch16 = new Lunch(100016, "Рыба", 50000, 100009);
    public static final Lunch lunch17 = new Lunch(100017, "Овощи", 30000, 100009);
    public static final Lunch lunch18 = new Lunch(100018, "Сок", 20000, 100009);
    public static final Lunch lunch19 = new Lunch(100019, "Пицца", 65000, 100010);
    public static final Lunch lunch20 = new Lunch(100020, "Паста", 35000, 100010);
    public static final Lunch lunch21 = new Lunch(100021, "Вино", 25000, 100010);
    public static final Lunch lunch22 = new Lunch(100022, "Суши", 47000, 100011);
    public static final Lunch lunch23 = new Lunch(100023, "Сашими", 49000, 100011);
    public static final Lunch lunch24 = new Lunch(100024, "Лимонад", 18000, 100011);
    public static final Lunch lunch25 = new Lunch(100025, "Салат", 38000, 100012);
    public static final Lunch lunch26 = new Lunch(100026, "Сандвич", 41000, 100012);
    public static final Lunch lunch27 = new Lunch(100027, "Кофе", 23000, 100012);

    public static final List<Lunch> lunches = List.of(lunch13, lunch14, lunch15, lunch16, lunch17, lunch18, lunch19, lunch20,
            lunch21, lunch22, lunch23, lunch24, lunch25, lunch26, lunch27);
    public static final List<Lunch> lunchesForDelete = List.of(lunch14, lunch15, lunch16, lunch17, lunch18, lunch19, lunch20,
            lunch21, lunch22, lunch23, lunch24, lunch25, lunch26, lunch27);
    public static final List<Lunch> lunches100008 = List.of(lunch13, lunch14, lunch15);

    public static Lunch getUpdated(){
        Lunch updated = new Lunch(lunch13);
        updated.setName("UpdatedLunch");
        updated.setPrice(33333);
        return updated;
    }
}
