package cn.tommyyang.jsontool;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Created by TommyYang on 2018/9/7.
 */
public class Json implements JsonBuilder {

    private Gson gson;
    private JsonObject jsonObject;
    private JsonObject jsonObjectMore;

    public Json() {
        this.gson = new Gson();
        this.jsonObject = new JsonObject();
        this.jsonObjectMore = new JsonObject();
    }

    public static JsonBuilder newJson() {
        return new Json();
    }

    @Override
    public JsonBuilder message(String message) {
        try {
            this.jsonObject.add("message", this.gson.toJsonTree(message));
        } catch (Exception e) {
            this.jsonObject.add("message", this.gson.toJsonTree(this.formatException(e)));
        }

        return this;
    }

    @Override
    public JsonBuilder message(Supplier<String> message) {
        try {
            this.jsonObject.add("message", this.gson.toJsonTree(message.get()));
        } catch (Exception e) {
            this.jsonObject.add("message", this.gson.toJsonTree(this.formatException(e)));
        }

        return this;
    }

    @Override
    public JsonBuilder map(String key, Map map) {
        try {
            this.jsonObject.add(key, this.gson.toJsonTree(map));
        } catch (Exception e) {
            this.jsonObject.add(key, this.gson.toJsonTree(this.formatException(e)));
        }

        return this;
    }

    @Override
    public JsonBuilder map(String key, Supplier<Map> map) {
        try {
            this.jsonObject.add(key, this.gson.toJsonTree(map.get()));
        } catch (Exception e) {
            this.jsonObject.add(key, this.gson.toJsonTree(this.formatException(e)));
        }

        return this;
    }

    @Override
    public JsonBuilder list(String key, List list) {
        try {
            this.jsonObject.add(key, this.gson.toJsonTree(list));
        } catch (Exception e) {
            this.jsonObject.add(key, this.gson.toJsonTree(this.formatException(e)));
        }

        return this;
    }

    @Override
    public JsonBuilder list(String key, Supplier<List> list) {
        try {
            this.jsonObject.add(key, this.gson.toJsonTree(list.get()));
        } catch (Exception e) {
            this.jsonObject.add(key, this.gson.toJsonTree(this.formatException(e)));
        }

        return this;
    }

    @Override
    public JsonBuilder field(String key, Object value) {
        try {
            this.jsonObject.add(key, this.gson.toJsonTree(value));
        } catch (Exception e) {
            this.jsonObject.add(key, this.gson.toJsonTree(this.formatException(e)));
        }

        return this;
    }

    @Override
    public JsonBuilder field(String key, Supplier value) {
        try {
            this.jsonObject.add(key, this.gson.toJsonTree(value.get()));
        } catch (Exception e) {
            this.jsonObject.add(key, this.gson.toJsonTree(this.formatException(e)));
        }

        return this;
    }

    @Override
    public JsonBuilder strField(String key, String value) {
        try {
            this.jsonObject.add(key, this.gson.toJsonTree(value));
        } catch (Exception e) {
            this.jsonObject.add(key, this.gson.toJsonTree(this.formatException(e)));
        }

        return this;
    }

    @Override
    public JsonBuilder intField(String key, int value) {
        try {
            this.jsonObject.add(key, this.gson.toJsonTree(value));
        } catch (Exception e) {
            this.jsonObject.add(key, this.gson.toJsonTree(this.formatException(e)));
        }

        return this;
    }

    @Override
    public JsonBuilder longField(String key, long value) {
        try {
            this.jsonObject.add(key, this.gson.toJsonTree(value));
        } catch (Exception e) {
            this.jsonObject.add(key, this.gson.toJsonTree(this.formatException(e)));
        }

        return this;
    }

    @Override
    public JsonBuilder exception(String key, Exception exception) {
        try {
            this.jsonObject.add(key, this.gson.toJsonTree(this.formatException(exception)));
        } catch (Exception e) {
            this.jsonObject.add(key, this.gson.toJsonTree(this.formatException(e)));
        }

        return this;
    }

    @Override
    public JsonBuilder newBuilder() {
        if(this.jsonObject != null && this.jsonObject.size() > 0){
            for(Map.Entry<String, JsonElement> item : this.jsonObject.entrySet()){
                this.jsonObjectMore.add(item.getKey(), item.getValue());
            }
        }
        return this;
    }

    private String formatException(Exception e) {
        return ExceptionUtils.getStackTrace(e);
    }

    public String json(){
        if(this.jsonObjectMore != null && this.jsonObjectMore.size() > 0){
            for(Map.Entry<String, JsonElement> item : this.jsonObjectMore.entrySet()){
                this.jsonObject.add(item.getKey(), item.getValue());
            }
        }
        String json =  this.gson.toJson(this.jsonObject);
        this.jsonObject = new JsonObject(); //清空jsonObject里面的值
        return json;
    }

}
