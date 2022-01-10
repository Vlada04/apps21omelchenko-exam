package domain;

import json.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {
    public String name;
    public String surname;
    public Integer year;
    public List<Tuple<String, Integer>> exams;

    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.exams = Arrays.asList(exams);
    }

    @Override
    public JsonObject toJsonObject() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add(new JsonPair("name", new JsonString(this.name)));
        jsonObject.add(new JsonPair("surname", new JsonString(this.surname)));
        jsonObject.add(new JsonPair("year", new JsonNumber(this.year)));
        return jsonObject;
    }
}