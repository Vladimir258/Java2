package ru.geekbrains;

import java.util.*;

public class UniqueWords {
    public static void uWords() {
        String[] list = new String[20];
        list[0] = "Инкапсуляция";
        list[1] = "Полиморфизм";
        list[2] = "Наследование";
        list[3] = "Java";
        list[4] = "Git";
        list[5] = "Программирование";
        list[6] = "Инкапсуляция";
        list[7] = "Spring";
        list[8] = "Hibernate";
        list[9] = "Sql";
        list[10] = "Maven";
        list[11] = "Jdbc";
        list[12] = "Полиморфизм";
        list[13] = "Инкапсуляция";
        list[14] = "Полиморфизм";
        list[15] = "Наследование";
        list[16] = "Maven";
        list[17] = "Git";
        list[18] = "Программирование";
        list[19] = "Инкапсуляция";

        HashMap<String,Integer> listToMap =new HashMap<String,Integer>();
        for(String str:list) {
            int wordCounter =  listToMap.getOrDefault(str,0)+1;
            listToMap.put(str,wordCounter);
        }
        System.out.println(listToMap);
    }
}
