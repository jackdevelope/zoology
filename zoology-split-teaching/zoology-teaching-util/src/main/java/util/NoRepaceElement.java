package util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class NoRepaceElement {
    private static List<String> list = new ArrayList<>();
    private static List<String> list0 = new ArrayList<>();
    public static int removeDuplicates(char nums[]){
        //System.out.println(num);
        int count=0;
        for (int i=0;i<nums.length;i++){
           // System.out.println(nums[i]);
            if (nums[i]=='1'&&count==0){
                count++;
            }else if (nums[i]=='1'&&count==1){
                nums[i]='2';
            }
            list.add(String.valueOf(nums[i]));
        }
        return list.size();
    }
    public static int removeDuplicates0(char nums0[]){
        //System.out.println(nums0);
        int count=0;
        for (int i=0;i<5;i++){
            // System.out.println(nums[i]);
            if (nums0[i]=='0'&&count==0){
                count++;
            }else if (nums0[i]=='0'&&count==1){
                nums0[i]='1';
                count++;
            }else if (nums0[i]=='1'&&count==2){
                nums0[i]='2';
                count++;
            }else if (nums0[i]=='1'&&count==3){
                nums0[i]='3';
                count++;
            }else if (nums0[i]=='1'&&count==4){
                nums0[i]='4';
                count++;
            }
            list0.add(String.valueOf(nums0[i]));
        }
       for (int j=5;j<10;j++){
           list0.add(String.valueOf(nums0[j]));
       }
        return list0.size();
    }
    @Test
    public void myArray(){
        char nums[] ={'1','1','2'};
        char nums0[] = {'0','0','1','1','1','2','2','3','3','4'};
        int len = removeDuplicates(nums);
        int len0 = removeDuplicates0(nums0);
        System.out.println("len:"+len+";list:"+list.toString());
        System.out.println("len0:"+len0+";list0:"+list0.toString());
    }
}
