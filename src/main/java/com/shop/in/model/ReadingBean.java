package com.shop.in.model;

import javax.enterprise.context.RequestScoped;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class ReadingBean {
    private static final  String SHOP_FRUIT ="/fruits.txt";
    private  static  final String SHOP_VEGETABLES ="vegetables.txt";
    private  String fruits,vegtables;
    private List<String> fruitList,vegList;
    public List<String> fruitReader() throws IOException {
        InputStream pathStream = ReadingBean.class.getResourceAsStream(SHOP_FRUIT);
        InputStreamReader resourceStream = new InputStreamReader(pathStream);
        BufferedReader fruitReader = new BufferedReader(resourceStream);
        fruitList = new ArrayList<String>();
        while ((fruits = fruitReader.readLine()) != null){
            fruitList.add(fruits);
        }
        return fruitList;
    }
    public  List<String> vegReader()throws  IOException{
        InputStream pathStream = ReadingBean.class.getResourceAsStream(SHOP_VEGETABLES);
        InputStreamReader resourceStream = new InputStreamReader(pathStream);
        BufferedReader vegReader = new BufferedReader(resourceStream);
        vegList = new ArrayList<String>();
        while((vegtables = vegReader.readLine()) != null){
            vegList.add(vegtables);
        }
        return vegList;
    }
}
