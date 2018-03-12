package com.jumfens.Sort;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1,6,-2,8,3,3,9,7,2};
        heapSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"   ");
        }
    }

    private static void heapSort(int[] arr) {

        //构建一个大顶堆
        for (int i=arr.length/2-1;i>=0;--i){
            heapAdjust(arr,i,arr.length-1);
        }

        for (int i = arr.length-1; i >=0 ; i--) {
            int tmp = arr[0];
            arr[0]=arr[i];
            arr[i]=tmp;
            heapAdjust(arr,0,i-1);
        }
    }

    private static void heapAdjust(int[] arr, int start, int stop) {
        int tmp = arr[start];
        for (int i = start*2+1; i <=stop; i=i*2+1) {
            if(i<stop && arr[i]>arr[i+1])//指向较小的子节点
                i++;
            if(arr[i]>tmp)
                break;
            arr[start]=arr[i];
            start=i;
        }
        arr[start]=tmp;
    }
}
