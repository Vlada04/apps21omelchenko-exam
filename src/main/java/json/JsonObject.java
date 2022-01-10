package json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    public List<List> jsonPack = new ArrayList<List>();

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
            res = res +  jsonPack.get(i).get(0) + ": " + jsonPack.get(i).get(1);
            if (i < jsonPack.size() - 1){
                res += ", ";
            }
        }
        res += "}";
        return res;
    }

    public void add(JsonPair jsonPair) {
        List<String> pair = Arrays.asList(jsonPair.key, jsonPair.value.toJson());
        jsonPack.add(pair);
    }

    public Json find(String name) {
        for(int i = 0; i < jsonPack.size(); i++){
            if (jsonPack.get(i).get(0) == name){
                Json js = new JsonString(jsonPack.get(i).get(1).toString());
                return js;
            }
        }
        return null;
    }

    public JsonObject projection(String... names) {
        JsonObject jsonObject = new JsonObject();
        for (int lst = 0; lst < jsonPack.size(); lst++){
            for (int i = 0; i < names.length; i++){
                if(jsonPack.get(lst).get(0).toString() == names[i]){
                    jsonObject.add(new JsonPair(jsonPack.get(lst).get(0).toString(), new JsonString(jsonPack.get(lst).get(1).toString())));
                }
            }
        }
        return jsonObject;
    }
}
