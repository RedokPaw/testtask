package com.redok.task.utils;

import java.util.List;
import java.util.Random;

import static java.util.Collections.swap;

public class QuickSelect {

    public static double findNthSmallest(List<Double> nums, int n) {
        int size = nums.size();
        return quickselect(0, size - 1, n - 1, nums);
    }

    private static double quickselect(int left, int right, int targetIndex, List<Double> nums) {
        if (left == right) {
            return nums.get(left);
        }
        int pivotIndex = partition(left, right, nums);
        if (targetIndex == pivotIndex) {
            return nums.get(pivotIndex);
        } else if (targetIndex < pivotIndex) {
            return quickselect(left, pivotIndex - 1, targetIndex, nums);
        } else {
            return quickselect(pivotIndex + 1, right, targetIndex, nums);
        }

    }

    private static int partition(int left, int right, List<Double> nums) {
        Random randomPivot = new Random();
        int pivotIndex = left + randomPivot.nextInt(right - left);
        double pivotValue = nums.get(pivotIndex);
        swap(nums, pivotIndex, right);
        int i = left;
        for (int j = left; j < right; j++) {
            if (nums.get(j) < pivotValue) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, right, i);
        return i;
    }
}
