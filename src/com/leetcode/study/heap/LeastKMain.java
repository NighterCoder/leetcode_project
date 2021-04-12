package com.leetcode.study.heap;

import java.util.Arrays;

public class LeastKMain {

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] arr=new int[]{9,3,5,7,2,4,6,8};
        int[] res=solution.smallestK(arr,4);
        for (int ele:res){
            System.out.println(ele);
        }

    }


}

class Solution {
    public int[] smallestK(int[] arr, int k) {
        //对数组arr进行堆排序
        sort(arr,arr.length-1);
        return Arrays.copyOfRange(arr, 0, 4);


    }

    private void swap(int[] a,int i,int j){
        int tmp=a[i];
        a[i]=a[j];
        a[j]=tmp;
    }

    private void createHeap(int[] arr,int n){
        for(int i=n/2-1;i>=1;i--){
            heapify(arr,n,i);
        }
    }

    private void heapify(int[] arr,int n,int i){
        while(true){
            int maxPos=i;
            if(i*2+1<=n && arr[i]<arr[i*2+1]) maxPos=i*2+1;
            if(i*2+2<=n && arr[maxPos]<arr[i*2+2]) maxPos=i*2+2;
            if(maxPos==i){ break; }
            // 交换位置
            swap(arr,i,maxPos);
            i=maxPos;
        }
    }

    private void sort(int[] arr,int k){
        createHeap(arr,k);
        while(k>=0){
            // 交换
            swap(arr,0,k);
            k--;
            heapify(arr,k,0);
        }
    }

}