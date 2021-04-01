package com.yin.bolgs;/**
 * @author 17694
 * @date 2021/03/26
 **/

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName : Add 
 * @Description :   
 */
public class Add {
    private static int ARRAYLENGTH = 3;
    public static void main(String[] args) {
        System.out.println(ARRAYLENGTH);
        Scanner input =new Scanner(System.in);
        int arr[] = new int[ARRAYLENGTH];
        for (int i = 0; i <ARRAYLENGTH; i++) {
            arr[i]=input.nextInt();
        }
     Arrays.stream(arr).forEach(i-> System.out.print(""+i));
            String.valueOf(arr);



    }

}
