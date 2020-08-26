package com.xm.examles;

import avro.shaded.com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @ClassName TestProduct
 * @Description
 * @Date 2020/8/13 17:49
 */
public class TestProduct {
    public static void main(String[] args) {

        Product prod1 = new Product(1L, 1, new BigDecimal("15.5"), "面包", "零食");
        Product prod4 = new Product(4L, 3, new BigDecimal("10"), "青岛啤酒", "啤酒");
        Product prod3 = new Product(3L, 3, new BigDecimal("30"), "月饼", "零食");
        Product prod5 = new Product(5L, 10, new BigDecimal("15"), "百威啤酒", "啤酒");
        Product prod2 = new Product(2L, 2, new BigDecimal("20"), "饼干", "零食");
        List<Product> prodList = Lists.newArrayList(prod1, prod2, prod3, prod4, prod5);

        // 按照类目分组：
        Map<String, List<Product>> prodMap= prodList.stream().collect(Collectors.groupingBy(Product::getCategory));
        System.out.println("===========================修改=======================================");


        System.out.println(prodMap.toString());
        //{"啤酒":[{"category":"啤酒","id":4,"name":"青岛啤酒","num":3,"price":10},{"category":"啤酒","id":5,"name":"百威啤酒","num":10,"price":15}],"零食":[{"category":"零食","id":1,"name":"面包","num":1,"price":15.5},{"category":"零食","id":2,"name":"饼干","num":2,"price":20},{"category":"零食","id":3,"name":"月饼","num":3,"price":30}]}

        //按照几个属性拼接分组：
        Map<String, List<Product>> prodMap2 = prodList.stream().collect(Collectors.groupingBy(item -> item.getCategory() + "_" + item.getName()));
//        System.out.println(prodMap2);
        //{"零食_月饼":[{"category":"零食","id":3,"name":"月饼","num":3,"price":30}],"零食_面包":[{"category":"零食","id":1,"name":"面包","num":1,"price":15.5}],"啤酒_百威啤酒":[{"category":"啤酒","id":5,"name":"百威啤酒","num":10,"price":15}],"啤酒_青岛啤酒":[{"category":"啤酒","id":4,"name":"青岛啤酒","num":3,"price":10}],"零食_饼干":[{"category":"零食","id":2,"name":"饼干","num":2,"price":20}]}

        prodList.stream().collect(Collectors.groupingBy(Product::getCategory)).forEach((category, value) -> {
            System.out.println(category);
            Iterator<Product> iterator = value.iterator();
            while(iterator.hasNext()){//判断是否有下一个对象
                System.out.println(iterator.next().getName());//获取对象
            }
        });
        System.out.println("==============================运行结束==============================================");
    }
}
