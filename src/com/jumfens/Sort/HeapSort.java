package com.jumfens.Sort;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{31,6,-2,8,33,3,-9,7,2};
        heapSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"   ");
        }
    }

    private static void heapSort(int[] arr) {

        //构建一个小顶堆
        for (int i=arr.length/2-1;i>=0;--i){
            heapAdjust(arr,i,arr.length-1);
        }

        for (int i = arr.length-1; i >=0 ; i--) {
            //交换堆顶记录 和 当前未经排序子数组的 最后一个元素
            int tmp = arr[0];//arr[0]是堆顶元素
            arr[0]=arr[i];
            arr[i]=tmp;
            heapAdjust(arr,0,i-1);//i-1就是未经排序的最后一个元素
        }
    }

    //调整堆为一个小顶堆
    private static void heapAdjust(int[] arr, int start, int stop) {
        int tmp = arr[start];
        for (int i = start*2+1; i <=stop; i=i*2+1) {
            if(i<stop && arr[i]>arr[i+1])
                i++;//指向较小的子节点

            if(arr[i]>tmp)//较小的子节点 大于 父节点，无需调整
                break;

            arr[start]=arr[i];//将较小的子节点 赋值 给其父节点
            start=i;//继续对start的较小的子节点进行堆调整
        }
        arr[start]=tmp;
    }
}
