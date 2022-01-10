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
        JsonArray sub = new JsonArray();


        for (int i = 0; i < exams.size(); i++){
            JsonPair course = new JsonPair("course", new JsonString(exams.get(i).key));
            JsonPair mark = new JsonPair("mark", new JsonNumber(exams.get(i).value));
            JsonPair p = new JsonPair("passed", new JsonBoolean(false));
            if (exams.get(i).value >= 3){
                p = new JsonPair("passed", new JsonBoolean(true));}

            Json str = new JsonString(new JsonObject(course, mark, p).toJson());
            sub.jsons.add(str);
        }

        String s = sub.toJson();
        Json sub_str = new JsonString(s);

        jsonObject.add(new JsonPair("exams", sub_str));
        return jsonObject;
    }
}