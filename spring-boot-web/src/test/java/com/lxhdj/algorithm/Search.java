package com.lxhdj.algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @description: 查找
 * @author: wangguijun1
 * @create: 2020-01-09 14:54
 **/

public class Search {

    public static void main(String[] args) {
        try {
            FileInputStream in = new FileInputStream("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(binarySearch(arr, 5));
        System.out.println(binarySearch(arr, 15));
    }

    public static int binarySearch(int[] arr, int n) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (low <= high) {
            mid = (high + low) / 2;
            if (n > arr[mid]) {
                low = mid + 1;
            } else if (n < arr[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }




}
