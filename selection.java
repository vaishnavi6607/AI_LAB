package Ai_main;

import java.util.*;
public class selection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no of elements");
        int n =sc.nextInt();

        int array[]= new int[n];
        System.out.println("enter th elemnts");
        for(int i=0;i<n;i++){
            array[i]=sc.nextInt();
        }

        for(int i=0;i<n;i++){
            int smallest =i;
            for(int j=i+1;j<n;j++){
                if(array[smallest]>array[j]){
                    smallest= j;
                }
            }
            int temp =array[smallest];
            array[smallest]=array[i];
            array[i]=temp;
        }

        System.out.println("sorted array");
        for(int i=0;i<n;i++){
            System.out.print(array[i]+" ");
        }
    }
}
