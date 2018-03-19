package sequencesearch;

import util.Constant;

/**
 * <p>说明：顺序查找适合于存储结构为顺序存储或链接存储的线性表。</p>
 * <p>基本思想：顺序查找也称为线形查找，属于无序查找算法。从数据结构线形表的一端开始，顺序扫描，
 * 依次将扫描到的结点关键字与给定值k相比较，若相等则表示查找成功；若扫描结束仍没有找到关键字等于k的结点，表示查找失败。</p>
 * <p>复杂度分析：　查找成功时的平均查找长度为：（假设每个数据元素的概率相等） ASL = 1/n(1+2+3+…+n) = (n+1)/2 ;
 * 当查找不成功时，需要n+1次比较，时间复杂度为O(n);
 * 所以，顺序查找的时间复杂度为O(n)。</p>
 *
 * @author zhushuai
 */
public class SequenceSearch {

    /**
     * 顺序查找
     *未查询到目标值返回 -1
     * @param arr    对象数组
     * @param source 目标值
     * @return 下标
     */
    public static int sequenceSearch(int[] arr, int source) {
        int index = Constant.DEFAULT_INDEX;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == source) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {6, 12, 33, 87, 90, 97, 108, 561};
        System.out.println("顺序查找：" + sequenceSearch(arr, 97));
        System.out.println("顺序查找：" + sequenceSearch(arr, 520));
    }

}
