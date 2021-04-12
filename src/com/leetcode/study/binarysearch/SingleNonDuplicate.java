package com.leetcode.study.binarysearch;

/**
 * 有序数组中的单一元素
 * <p>
 * 给定一个只包含整数的有序数组,每个元素都会出现两次,只有一个数只会出现一次
 * O(log n)时间复杂度和O(1)空间复杂度
 */
public class SingleNonDuplicate {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicateRight(nums));

    }

    /**
     * 官方解法
     * @param nums
     * @return
     */
    public static int singleNonDuplicateRight(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            // 使用这种中间值的做法是为了防止中间值溢出
            // 即 （hi+lo）/2 中 hi+lo溢出
            int mid = lo + (hi - lo) / 2;

            // 确定那一侧元素为奇数
            boolean halvesAreEven = (hi - mid) % 2 == 0;
            // 与下半部分第一个相等
            if (nums[mid + 1] == nums[mid]) {
                // 偶数,在下半部分
                if (halvesAreEven) {
                    lo = mid + 2;
                } else {
                    // 奇数,在上半部分
                    hi = mid - 1;
                }
            } else if (nums[mid - 1] == nums[mid]) {
                if (halvesAreEven) {
                    hi = mid - 2;
                } else {
                    lo = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[lo];
    }




    /**
     * todo 错误解法
     * 使用二分查找法
     * 数组元素个数为2n+1
     *
     * @param nums
     * @return
     */
    public static int singleNonDuplicate(int[] nums) {
        int middleIndex = nums.length / 2;
        int startIndex = 0;
        int endIndex = nums.length - 1;
        while (startIndex < middleIndex) {
            if (middleIndex % 2 == 0) {
                // 单独的数在上半部分
                if (nums[middleIndex] == nums[middleIndex - 1]) {
                    endIndex = middleIndex - 1;
                } else if (nums[middleIndex] == nums[middleIndex + 1]) {
                    // 单独的数在下半部分
                    startIndex = middleIndex + 1;
                } else {
                    return nums[middleIndex];
                }
            } else {
                // 单独的数在下半部分
                if (nums[middleIndex] == nums[middleIndex - 1]) {
                    startIndex = middleIndex + 1;
                } else if (nums[middleIndex] == nums[middleIndex + 1]) {
                    endIndex = middleIndex - 1;
                } else {
                    return nums[middleIndex];
                }
            }
            middleIndex = (startIndex + endIndex) / 2;
        }
        if (nums[endIndex]==nums[middleIndex]){
            return nums[startIndex];
        }else {
            return nums[endIndex];
        }
    }

}
