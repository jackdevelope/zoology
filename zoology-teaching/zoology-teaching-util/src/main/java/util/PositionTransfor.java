package util;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PositionTransfor {
    private static List<String> listResult = new ArrayList<>();
    private static String[] arrays =new String[listResult.size()];
    public static void positionChange(){
        String temp="";
        String[] array = listResult.toArray(String[]::new);
        String result=new StringBuffer(new String(array.toString())).reverse().toString();
        for (int i=0;i<result.length();i++){
            System.out.println(result.indexOf(i));
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i=0;i<n;i++){
            int small = scanner.nextInt();
            listResult.add(String.valueOf(small));
        }
        positionChange();
    }
}
