package ru.geekbrains;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    Map<String, ArrayList<String>> phoneBook = new HashMap<>();
    ArrayList<String> numberList;

    public void add(String abonent, String phoneNumber) {
        if (phoneBook.containsKey(abonent)) {
            // Если абонент уже есть в справочнике..
            numberList = phoneBook.get(abonent); // ..добавляем к нему еще один номер
            numberList.add(phoneNumber);
            phoneBook.put(abonent, numberList);
        } else {
            // Если абонента нет..
            numberList = new ArrayList<>(); // ..добавляем
            numberList.add(phoneNumber);
            phoneBook.put(abonent, numberList);
        }
    }

    public String get(String abonent) {
        return abonent + ": " + phoneBook.get(abonent);
    }
}


class SearchAbonent {
    public static void getAbonent() {
        PhoneBook pBook = new PhoneBook();

        pBook.add("Абонент 1", "111");
        pBook.add("Абонент 2", "222");
        pBook.add("Абонент 3", "333");
        pBook.add("Абонент 1", "444");
        pBook.add("Абонент 2", "555");
        pBook.add("Абонент 3", "777");
        pBook.add("Абонент 4", "888");
        pBook.add("Абонент 5", "999");
        pBook.add("Абонент 3", "333555");

        System.out.println(pBook.get("Абонент 1"));
        System.out.println(pBook.get("Абонент 2"));
        System.out.println(pBook.get("Абонент 3"));
        System.out.println(pBook.get("Абонент 4"));
        System.out.println(pBook.get("Абонент 5"));
    }
}
