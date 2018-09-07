# `jsontool`

[![Build Status](https://travis-ci.org/joyang1/jsontool.svg?branch=master)](https://travis-ci.org/joyang1/jsontool.svg)

## Description
链式生成json字符串
方便简单的使用

## maven dependency
1. 添加repository
``` java
<repositories>
    <repository>
        <id>release</id>
        <url>https://raw.github.com/joyang1/jsontool/mvn-repo/</url>
        <snapshots>
            <enabled>true</enabled>
            <updatePolicy>always</updatePolicy>
        </snapshots>
    </repository>
</repositories>
```
2. 添加dependency
``` java
<dependency>
    <groupId>cn.tommyyang</groupId>
    <artifactId>jsontool</artifactId>
    <version>1.0</version>
</dependency>
```


## jsontool使用
  
1. 直接链式生成json串
  
``` java

String json = Json.newJson().field("key1","value1").field("key2", "value2").longField("long", 22L).json();
System.out.println(json);

```


2. json串中需要带特定的键值对

``` java

//如下{"key","value"}键值对在json1,json2,json3,json4中都需要
JsonBuilder jsonBuilder = Json.newJson().field("key", "value").newBuilder();
String json1 = jsonBuilder.field("akey", "aaa").json();
String json2 = jsonBuilder.field("bkey", "bbb").json();
String json3 = jsonBuilder.field("ckey", "ccc").intField("cint", 23).json();
String json4 = jsonBuilder.field("dkey", "ddd").json();
System.out.println(json1);
System.out.println(json2);
System.out.println(json3);
System.out.println(json4);

```

## 输出
``` json
{"key1":"value1","key2":"value2","long":22}
{"key":"value","akey":"aaa"}
{"bkey":"bbb","key":"value"}
{"ckey":"ccc","cint":23,"key":"value"}
{"dkey":"ddd","key":"value"}
```

## 测试程序
[测试demo](https://github.com/joyang1/jsontool/blob/master/src/test/java/TestJson.java)

## version
- `1.0版本`
    - 实现JsonTool的基本功能
    - 链式生成自己想要的字符串