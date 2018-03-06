package binarysearch;

/**
 * @author zhushuai
 * <p>
 * <p>二分查找是针对有序数组的一种查询方式</p>
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
        return -1;
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
            return -1;
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
