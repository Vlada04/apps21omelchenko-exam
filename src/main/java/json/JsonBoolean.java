package json;

/**
 * Created by Andrii_Rodionov on 1/4/2017.
 */
public class JsonBoolean extends Json {
    public Boolean item;

    public JsonBoolean(Boolean bool) {
        item = bool;
    }

    @Override
    public String toJson() {
        if (item == true){
            return "true";
        }
        else{
            return "false";
        }
    }
}
