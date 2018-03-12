package com.jumfens.MaxSubMatrix;

/**
 * 求 一个矩阵 的子矩阵的和的最大值
 */
public class MaxMatrix {

    public static void main(String[] args) {
        int[][] arr = {{-90,48,78},{64,-40,64},{-81,-7,66}};
        System.out.println("MaxSumOfSubMat = "+getMaxSumOfSubMat(arr));

        int[][] a={{-1,-1,-1},{-1,2,2},{-1,-1,-1}};
        System.out.println("MaxSumOfSubMat = "+getMaxSumOfSubMat(a));

    }

    private static int getMaxSumOfSubMat(int[][] arr) {
        if(arr==null || arr.length<=0 || arr[0].length<=0)
            return Integer.MIN_VALUE;

        int max = Integer.MIN_VALUE;



        for (int i=0;i<arr.length;++i){//从第0行开始，从第1行开始 ……

            int[] tmp = new int[arr[0].length];

            for (int j = i; j < arr.length; j++) {//第i行；第i……i+1行；第i，i+1，i+2行；…… ；第i，i+1，i+2，……最后一行；

                int cur=0;
                for (int k=0;k<arr[0].length;++k){//遍历列
                    tmp[k]+=arr[j][k];//若干行 累加成一行

                    cur+=tmp[k];

                    max = max>cur?max:cur;
                    cur=cur<0?0:cur;
                }
            }

        }


        return max;
    }
}
