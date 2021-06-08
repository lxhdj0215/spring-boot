package com.lxhdj.algorithm;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import javax.swing.text.TabExpander;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-08-11 19:49
 **/

public class Tree {
    private int value;

    private Tree left;
    private Tree right;

    public Tree(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "value=" + value +
                '}';
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
        List<Tree> list = buildTree(arr);
        Stack<Tree> stack = new Stack<>();
        stack.add(list.get(0));
        while (!stack.isEmpty()) {
            Tree tree = stack.pop();
            System.out.println(tree.value);
            if (tree.right != null) {
                stack.add(tree.right);
            }
            if (tree.left != null) {
                stack.add(tree.left);
            }
        }
    }

    private static List<Tree> buildTree(int[] arr) {
        List<Tree> list = Lists.newArrayList();
        for (int i = 0; i < arr.length; i++) {
            list.add(new Tree(arr[i]));
        }
        for (int i = 0; i < list.size() / 2; i++) {
            if (2 * i + 1 < list.size()) {
                list.get(i).left = list.get(2 * i + 1);
            }
            if (2 * i + 2 < list.size()) {
                list.get(i).right = list.get(2 * i + 2);
            }
        }
        return list;
    }
}
