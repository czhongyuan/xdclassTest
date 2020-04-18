package com.how2java;

import java.util.ArrayList;
import java.util.List;

public class TestSort {
    public static void main(String[] args) {
        // 初始化一个4万随机数的数组
        int[] i = new int[40000];
        for (int j = 0; j < i.length; j++) {
            i[j] = (int) (Math.random() * 1000);
        }
        // 记录冒泡排序时间
        long start1 = System.currentTimeMillis();
        bubbleSort(i);
        long end1 = System.currentTimeMillis();
        System.out.println("4万个随机数进行冒泡排序所需要的的时间为：" + (end1 - start1) + "ms.");

        // 记录选择排序时间
        long start2 = System.currentTimeMillis();
        SelectSort(i);
        long end2 = System.currentTimeMillis();
        System.out.println("4万个随机数进行选择排序所需要的的时间为：" + (end2 - start2) + "ms.");

        // 记录二叉树排序时间
        treenode tree = new treenode();
        for (int a = 0; a < i.length; a++) {
            tree.add(i[a]);
        }
        long start3 = System.currentTimeMillis();
        tree.values();
        long end3 = System.currentTimeMillis();
        System.out.println("4万个随机数进行二叉树排序所需要的的时间为：" + (end3 - start3) + "ms.");
    }

    // 冒泡排序,从小到大
    private static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
//       for (int i : nums) {
//          System.out.println(i + " ");
//      }
    }

    // 选择排序,从小到大
    private static void SelectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
//       for (int i : nums) {
//          System.out.println(i + " ");
//      }
    }
}

class treenode {
    public treenode leftNode;
    public treenode rightNode;
    public Object root;

    public void add(Object v) {
        if (root == null) {
            root = v;
        } else {
            if ((Integer) v - (Integer) root <= 0) {
                if (leftNode == null) {
                    leftNode = new treenode();
                }
                leftNode.add(v);
            } else {
                if (rightNode == null) {
                    rightNode = new treenode();
                }
                rightNode.add(v);
            }
        }
    }

    // 中序遍历所有的节点
    public List<Object> values() {
        List<Object> list = new ArrayList<>();
        if (null != leftNode) {
            list.addAll(leftNode.values());
        }
        list.add(root);
        if (null != rightNode) {
            list.addAll(rightNode.values());
        }
        return list;
    }
}
