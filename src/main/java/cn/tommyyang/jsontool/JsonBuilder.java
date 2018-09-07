package cn.tommyyang.jsontool;


import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Created by TommyYang on 2018/9/4.
 */
public interface JsonBuilder {

    JsonBuilder message(String message);

    JsonBuilder message(Supplier<String> message);

    JsonBuilder map(String key, Map map);

    JsonBuilder map(String key, Supplier<Map> map);

    JsonBuilder list(String key, List list);

    JsonBuilder list(String key, Supplier<List> list);

    JsonBuilder field(String key, Object value);

    JsonBuilder field(String key, Supplier value);

    JsonBuilder strField(String key, String value);

    JsonBuilder intField(String key, int value);

    JsonBuilder longField(String key, long value);

    JsonBuilder exception(String key, Exception exception);

    JsonBuilder newBuilder();

    String json();

}
