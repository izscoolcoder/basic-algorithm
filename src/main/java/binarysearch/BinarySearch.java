package binarysearch;

import util.Constant;

/**
 *
 * <p>
 *     二分查找也称折半查找（Binary Search），它是一种效率较高的查找方法。
 *      但是，折半查找要求线性表必须采用顺序存储结构，而且表中元素按关键字有序排列。
 * </p>
 * <p>
 *     首先，假设表中元素是按升序排列，将表中间位置记录的关键字与查找关键字比较，
 *     如果两者相等，则查找成功；否则利用中间位置记录将表分成前、后两个子表，
 *     如果中间位置记录的关键字大于查找关键字，则进一步查找前一子表，否则进一步查找后一子表。
 *     重复以上过程，直到找到满足条件的记录，使查找成功，或直到子表不存在为止，此时查找不成功。
 * </p>
 *
 *
 * @author zhushuai
 */
public class BinarySearch {

    /**
     * 循环实现二分查找算法arr 已排好序的数组x 需要查找的数-1 无法查到数据
     *
     * @param arr 目标对象数组
     * @param x 目标对象值
     * @return 目标对象所在数组下标
     */
    public static int binarySearch(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (x == arr[middle]) {
                return middle;
            } else if (x < arr[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return Constant.DEFAULT_INDEX;
    }

    /**
     * 递归实现二分查找
     *
     * @param dataSet 目标对象数组
     * @param data 目标对象值
     * @param beginIndex 开始下标值
     * @param endIndex 结束下标值
     * @return 目标对象所在数组下标
     */
    public static int binarySearch(int[] dataSet, int data, int beginIndex, int endIndex) {
        int midIndex = (beginIndex + endIndex) / 2;
        if (data < dataSet[beginIndex] || data > dataSet[endIndex] || beginIndex > endIndex) {
            return Constant.DEFAULT_INDEX;
        }
        if (data < dataSet[midIndex]) {
            return binarySearch(dataSet, data, beginIndex, midIndex - 1);
        } else if (data > dataSet[midIndex]) {
            return binarySearch(dataSet, data, midIndex + 1, endIndex);
        } else {
            return midIndex;
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 12, 33, 87, 90, 97, 108, 561};
        System.out.println("循环查找：" + (binarySearch(arr, 87) + 1));
        System.out.println("递归查找：" + (binarySearch(arr, 87, 0, arr.length - 1) + 1));
    }

}
