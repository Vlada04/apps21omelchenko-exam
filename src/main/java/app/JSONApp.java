package app;

import domain.*;
import json.*;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JSONApp {
    public static void main(String[] args) {
        Json jYear = new JsonNumber(2);
        print(jYear); // 2

        Json jMarks = new JsonArray(new JsonNumber(3), new JsonNumber(4));
        print(jMarks); // [3, 4]

        JsonPair name = new JsonPair("name", new JsonString("Andrii"));
        JsonPair surname = new JsonPair("surname", new JsonString("Rodionov"));
        JsonPair marks = new JsonPair("marks", jMarks);
        JsonPair year = new JsonPair("year", jYear);
        JsonObject jsonObj = new JsonObject(name, surname, year, marks);
        print(jsonObj); // {'name': 'Andrii', 'surname': 'Rodionov', 'year': 2, 'marks': [3, 4]}

        print(jsonObj.projection("surname", "age", "year", "marks")); // {'surname': 'Rodionov', 'year': 2, 'marks': [3, 4]}

        BasicStudent basicStudent = new BasicStudent("Andrii", "Rodionov", 2);
        print(basicStudent.toJsonObject()); // {'name': 'Andrii', 'surname': 'Rodionov', 'year': 2}

    }

    private static void print(Json json) {
        System.out.println(json.toJson());
    }

    public static JsonObject sessionResult() {

        JsonPair name = new JsonPair("name", new JsonString("Andrii"));
        JsonPair surname = new JsonPair("surname", new JsonString("Rodionov"));
        JsonPair year = new JsonPair("year", new JsonNumber(2));

        JsonPair course1 = new JsonPair("course", new JsonString("OOP"));
        JsonPair mark1 = new JsonPair("mark", new JsonNumber(3));
        JsonPair pass1 =  new JsonPair("passed", new JsonBoolean(true));
        Json str1 = new JsonString(new JsonObject(course1, mark1, pass1).toJson());

        JsonPair course2 = new JsonPair("course", new JsonString("English"));
        JsonPair mark2 = new JsonPair("mark", new JsonNumber(5));
        JsonPair pass2 =  new JsonPair("passed", new JsonBoolean(true));
        Json str2 = new JsonString(new JsonObject(course2, mark2, pass2).toJson());

        JsonPair course3 = new JsonPair("course", new JsonString("Math"));
        JsonPair mark3 = new JsonPair("mark", new JsonNumber(2));
        JsonPair pass3 =  new JsonPair("passed", new JsonBoolean(false));
        Json str3 = new JsonString(new JsonObject(course3, mark3, pass3).toJson());

        String sub = new JsonArray(str1, str2, str3).toJson();
        Json sub_str = new JsonString(sub);

        JsonPair lst = new JsonPair("exams", sub_str);
        JsonObject jsonObject = new JsonObject(name, surname, year, lst);
        return jsonObject;
    }
}
