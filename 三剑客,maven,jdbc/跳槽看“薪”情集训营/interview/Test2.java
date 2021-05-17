package com.duyi.interview;

public class Test2 {

    public static void main(String[] args) {
        int j = 0;
        for (int i = 0; i < 10; i++) {
            System.out.println(i + "," + j);
            // i = 0  j = 0
            j = j++;
            // j++     j的值先返回  然后自增j=j+1
            // j = j++的结果

            // j=0
        }

        // A 0  B 10  C 其他
        System.out.println(j);


        // 自增
        // ++   --
        // int i = 0;  int j;
        // j = i++   i = i+1      j=0  i=1
        // j = ++i   i = i+1      j=1  i=1


    }
}
