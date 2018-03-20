package fibonaccisearch;


import util.Constant;

/**
 * <p>在介绍斐波那契查找算法之前，我们先了解一下很它紧密相连并且大家都熟知的一个概念——黄金分割。</p>
 * <p>黄金比例又称黄金分割，是指事物各部分间一定的数学比例关系，即将整体一分为二，
 * 较大部分与较小部分之比等于整体与较大部分之比，其比值约为1:0.618或1.618:1。</p>
 * <p>大家记不记得斐波那契数列：1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89…….（从第三个数开始，
 * 后边每一个数都是前两个数的和）。然后我们会发现，随着斐波那契数列的递增，
 * 前后两个数的比值会越来越接近0.618，利用这个特性，我们就可以将黄金比例运用到查找技术中。</p>
 * <p>
 * <p>基本思想：也是二分查找的一种提升算法，通过运用黄金比例的概念在数列中选择查找点进行查找，
 * 提高查找效率。同样地，斐波那契查找也属于一种有序查找算法。</p>
 *
 * @author zhushuai
 */
public class FibonacciSearch {

    /**
     * 创建最小的Fibonacci 数组
     *
     * @param length
     * @return
     */
    private static int[] fibonacci(int length) {
        if(length < Constant.FIBONACCI_DEFAULT_SIZE) {
            length = Constant.FIBONACCI_DEFAULT_SIZE;
        }
        int[] f = new int[length];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < length; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    /**
     * Fibonacci 查找
     *
     * @param arr
     * @param source
     * @return
     */
    public static int fibonacciSearch(int[] arr, int source) {
        int length = arr.length;
        int[] fibonacci = fibonacci(length);
        int k = 0;
        while (length > fibonacci[k] - 1) {
            ++k;
        }

        //将待搜索数组的规模扩展为F[k]-1；原来不足的部分用a[high]填充
        int[] tempArray = new int[fibonacci[k] - 1];
        int low = 0;
        int high = length - 1;
        for (int i = length; i < fibonacci[k] - 1; i++) {
            tempArray[i] = arr[high];
        }

        for (int i = 0; i < length; i++) {
            tempArray[i] = arr[i];
        }

        arr = tempArray;

        //对于规模为F[k]-1的数组
        //黄金分割搜索， 每次将数组分为三部分，
        //第一部分为从low（包含）开始的F[k-1]-1个元素，到mid-1（包含）为止;
        //第二部分即为单个的a[mid],其中 mid = low+F[k-1]-1;
        //第三部分为 从啊mid+1 （包含）开始的F[k-2]-1个元素，到high为止
        //每次循环均遵循这一规律

        while (low <= high) {
            int mid = low + fibonacci[k - 1] - 1;
            if (arr[mid] > source) {
                high = mid - 1;
                k = k - 1;
            } else if (arr[mid] < source) {
                low = mid + 1;
                k = k - 2;
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return -1;
                }
            }

        }

        return -1;
    }


    public static void main(String[] args) {
        int[] a = {5, 15, 19, 20, 25, 31, 38, 41, 45, 49, 52, 55, 57};
        System.out.println(fibonacciSearch(a, 57));
        int[] b = {55, 57};
        System.out.println(fibonacciSearch(b, 57));
    }


}
