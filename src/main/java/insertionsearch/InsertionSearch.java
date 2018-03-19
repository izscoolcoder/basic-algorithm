package insertionsearch;

import util.Constant;

/**
 * <p>理解插值查找之前，首先考虑一个新问题，为什么二分算法一定要是折半，而不是折四分之一或者折更多呢？
 * 打个比方，在英文字典里面查“apple”，你下意识翻开字典是翻前面的书页还是后面的书页呢？如果再让你查“zoo”，你又怎么查？
 * 很显然，这里你绝对不会是从中间开始查起，而是有一定目的的往前或往后翻。
 * 同样的，比如要在取值范围1 ~ 10000 之间 100 个元素从小到大均匀分布的数组中查找5， 我们自然会考虑从数组下标较小的开始查找。
 * 经过以上分析，折半查找这种查找方式，不是自适应的（也就是说是傻瓜式的）。二分查找中查找点计算如下
 * mid=(low+high)/2, 即mid=low+1/2*(high-low);
 * 通过类比，我们可以将查找的点改进为如下：
 * mid=low+(key-a[low])/(a[high]-a[low])*(high-low)，
 * 也就是将上述的比例参数1/2改进为自适应的，根据关键字在整个有序表中所处的位置，
 * 让mid值的变化更靠近关键字key，这样也就间接地减少了比较次数。</p>
 *
 * @author zhushuai
 */
public class InsertionSearch {

    /**
     * 插入查找
     *查询无数据  返回下标为 <code>Constant.DEFAULT_INDEX</code>
     *
     * @param arr    目标数组
     * @param source 查找对象
     * @return 下标
     */
    public static int insertionSearch(int[] arr, int source) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (source - arr[low]) / (arr[high] - arr[low]) * (high - low);
            if (arr[mid] == source) {
                return mid;
            } else if (arr[mid] < source) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return Constant.DEFAULT_INDEX;
    }

    /**
     * 插入查找
     * 递归方式查询
     * 查询无数据  返回下标为 <code>Constant.DEFAULT_INDEX</code>
     * @param arr    目标数组
     * @param source 目标对象
     * @param low    最小下标
     * @param high   最高下标
     * @return 下标
     */
    public static int insertionSearch(int[] arr, int source, int low, int high) {
        int mid = low + (source - arr[low]) / (arr[high] - arr[low]) * (high - low);
        if (source < arr[low] || source > arr[high] || low > high) {
            return Constant.DEFAULT_INDEX;
        }
        if (arr[mid] == source) {
            return mid;
        } else if (arr[mid] < source) {
            return insertionSearch(arr, source, mid + 1, high);
        } else {
            return insertionSearch(arr, source, low, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 12, 33, 87, 90, 97, 108, 561};
        System.out.println("循环查找：" + (insertionSearch(arr, 6) + 1));
        System.out.println("递归查找：" + (insertionSearch(arr, 88, 0, arr.length - 1) + 1));
    }
}
