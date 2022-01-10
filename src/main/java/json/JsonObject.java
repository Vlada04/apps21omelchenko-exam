package json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    List<List> jsonPack = new ArrayList<List>();

    public JsonObject(JsonPair... jsonPairs) {
        for(int i=0; i < jsonPairs.length; i++){
            List<String> pair = Arrays.asList(jsonPairs[i].key, jsonPairs[i].value.toJson());
            jsonPack.add(pair);
        }
    }

    @Override
    public String toJson() {
        String res = "{";
        for(int i = 0; i < jsonPack.size(); i++){
            res = res +  "'" + jsonPack.get(i).get(0) + "'" + ": " + jsonPack.get(i).get(1);
            if (i < jsonPack.size() - 1){
                res += ", ";
            }
        }
        res += "}";
        return res;
    }

    public void add(JsonPair jsonPair) {
        // ToDo
    }

    public Json find(String name) {
        // ToDo
        return null;
    }

    public JsonObject projection(String... names) {
        // ToDo
        return null;
    }
}
