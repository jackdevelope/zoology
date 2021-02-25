package util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HaveMoney {
   private static int price=0,res=0;//当天买入价,当天盈利
   private static List<Integer> allPrice=new ArrayList<>();//价格集合
    private static List<Integer> allprofit=new ArrayList<>(); //利润集合
   private static boolean state=false;//当前交易状态

    public static void finiallyResult(List<Integer> finallyRes){
        int i,count=0;
        Integer[] array = finallyRes.toArray(Integer[]::new);
        for (i=0;i<array.length-1;i++){
            if (array[i]<array[i+1]){
              res=array[i+1]-array[i];
          }else {
              res=array[i]-array[i+1];
          }
          i=i+1;
          allprofit.add(res);
        }
        System.out.println("最大值:"+ Collections.max(allprofit));
    }
    public static void main(String[] args) {
       System.out.println("请输入股票天数:");
       Scanner scanner = new Scanner(System.in);
       int sumDay =scanner.nextInt();
       for (int i=0;i<sumDay;i++){
          allPrice.add(scanner.nextInt());
       }
       finiallyResult(allPrice);
   }


}
