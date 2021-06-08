package com.lxhdj.algorithm;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2021-01-30 21:46
 **/

public class SortTest {
    public static void main(String[] args) {
//        int[] arr = {5, 6, 7, 4, 3, 2, 1};
//        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int[] arr = {7, 6, 5, 4, 3, 2, 1};
//        treeSet(arr);
//        int[] arr = {1, 2, 3};
        int k = 7;
        quickSort(arr, 0, arr.length - 1, arr.length - k);
        System.out.println(Arrays.toString(arr));
        System.out.println(binarySearch(arr, 4));
    }

    private static int binarySearch(int[] arr, int n) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int index = (start + end) / 2;
            if (n > arr[index]) {
                start = index + 1;
            } else if (n < arr[index]) {
                end = index - 1;
            } else {
                return index;
            }
        }
        return -1;
    }


    private static void treeSet(int[] arr) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < arr.length; i++) {
            treeSet.add(arr[i]);
        }
        System.out.println(JSON.toJSONString(treeSet));
    }


    private static void quickSort(int[] arr, int start, int end, int n) {
        if (start >= end) {
            return;
        }
        int k = partition(arr, start, end);
//        if (k == n) {
//            System.out.println(arr[n]);
//            return;
//        }
//        System.out.println(k);
        quickSort(arr, start, k - 1, n);
        quickSort(arr, k + 1, end, n);
    }

    private static int partition(int[] arr, int start, int end) {
        int low = start;
        int high = end;
        int index = arr[start];
        while (low < high) {
            while (low < high && arr[high] >= index) {
                high--;
            }
            while (low < high && arr[low] <= index) {
                low++;
            }
            if (low < high) {
                swap(arr, low, high);
            }
        }
        swap(arr, start, high);
        return high;
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
