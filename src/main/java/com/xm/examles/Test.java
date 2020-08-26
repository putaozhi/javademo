package com.xm.examles;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Test
 * @Description TODO
 * @Date 2020/8/26 18:15
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("===============================================");
//        String dt = "2019-07-30 14:09:51";
        String dt = "2020-08-26 14:09:51";
        String[] d = dt.split("\\s+");
        System.out.println("***********************");
        System.out.println(d.length);
        System.out.println("1+1");

        // 创建一个Map
        Map<String, Object> infoMap = new HashMap<>();
        infoMap.put("name", "ll");
        infoMap.put("site", "www.xxx.xxx");
        infoMap.put("email", "xxx@.qq.com");
// 传统的Map迭代方式
//        for (Map.Entry<String, Object> entry : infoMap.entrySet()) {
//            System.out.println(entry.getKey() + "：" + entry.getValue());
//        }
// JDK8的迭代方式
        infoMap.forEach((key, value) -> {
            System.out.println(key + "：" + value);
        });
    }

}
