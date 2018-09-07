import cn.tommyyang.jsontool.Json;
import cn.tommyyang.jsontool.JsonBuilder;

/**
 * Created by TommyYang on 2018/9/7.
 */
public class TestJson {

    public static void main(String[] args) {
        String json = Json.newJson().field("key1","value1").field("key2", "value2").longField("long", 22L).json();
        System.out.println(json);

        JsonBuilder jsonBuilder = Json.newJson().field("key", "value").newBuilder();
        String json1 = jsonBuilder.field("akey", "aaa").json();
        String json2 = jsonBuilder.field("bkey", "bbb").json();
        String json3 = jsonBuilder.field("ckey", "ccc").intField("cint", 23).json();
        String json4 = jsonBuilder.field("dkey", "ddd").json();
        System.out.println(json1);
        System.out.println(json2);
        System.out.println(json3);
        System.out.println(json4);
    }

}
