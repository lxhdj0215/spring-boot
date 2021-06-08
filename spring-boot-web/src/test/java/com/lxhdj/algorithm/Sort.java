package com.lxhdj.algorithm;

import java.util.Arrays;

/**
 * @description: 排序
 * @author: wangguijun1
 * @create: 2020-01-09 17:07
 **/

public class Sort {

    public static void main(String[] args) {
//        int[] arr = {5, 6, 7, 4, 3, 2, 1};
//        int[] arr = {1, 2, 3, 4, 5, 6, 7};
//        int[] arr = {7, 6, 5, 4, 3, 2, 1};
//        int[] arr = {1, 2, 3};
//        topk(arr, 7);
//        topK(arr, 3);
//        bubleSort1(arr);
//        System.out.println(Arrays.toString(arr));
        int[] arr = {5, 4, 3, 2, 10, 9, 5};
        quickSort(arr, 0, arr.length - 1);
//        selectSort(arr);
//        bubbleSort(arr);
//        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] one(int[] arr) {
        return null;
    }

    public static int max_(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int k = partition(arr, start, end);
        quickSort(arr, start, k - 1);
        quickSort(arr, k + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int i = start;
        int j = end;
        int index = arr[i];
        while (i < j) {
            while (i < j && arr[j] >= index) {
                j--;
            }
            while (i < j && arr[i] <= index) {
                i++;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, start, j);
        return j;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int min(int[] arr) {
        int minIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        return arr[minIndex];
    }

    /**
     * todo TopK 问题
     *
     * @param arr
     * @return
     */
    public static int[] topTwo(int[] arr) {
        int[] top = new int[2];
        return null;
    }

    public static int max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * 选择排序
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertNode = arr[i];
            int j = i - 1;
            while (j >= 0 && insertNode < arr[j]) {
                arr[j + 1] = arr[j];
            }
            if (i != j + 1) {
                arr[j + 1] = insertNode;
            }
        }
    }

    public static void topk(int[] arr, int k) {
        if (arr == null || k < 0 || k > arr.length) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (i == k - 1) {
                System.out.println(arr[arr.length - k]);
            }
        }
        if (k == arr.length) {
            System.out.println(arr[0]);
        }
    }

    public static void topK(int[] arr, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        System.out.println(arr[arr.length - k]);
    }

    public static void bubleSort1(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }


    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}
