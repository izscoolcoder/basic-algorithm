package leetcode;


/**
 * 马拉车算法
 * https://www.cnblogs.com/grandyang/p/4475985.html
 *
 * @author zhushuai
 */
public class Solution3 {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int length = expendAroundCenter(s, i);
            if (length > end - start) {
                //记录开始位置截至位置  不管以何种中心回文 i都被算作前半段回文 所以计算start 长度是减1后再去整除2
                start = i - (length - 1) / 2;
                end = i + length / 2;
            }
        }

        return s.substring(start, end+1);
    }


    /**
     * 中心扩张比较字符 获取回文长度  center 可以是中间字符 aba
     * 也可是 abba 这样的b字符位置
     *
     * @param s
     * @param center
     * @return 返回长度length
     */
    public static int expendAroundCenter(String s, int center) {

        int goLeft = center;
        int goRight = center;

        int midCenterLength = 0;
        while (goLeft >= 0 && goRight < s.length() && s.charAt(goLeft) == s.charAt(goRight)) {
            midCenterLength = goRight - goLeft + 1;
            --goLeft;
            ++goRight;
        }

        int symmetryCenterLength = 0;
        goLeft = center;
        goRight = center + 1;
        while (goLeft >= 0 && goRight < s.length() && s.charAt(goLeft) == s.charAt(goRight)) {
            symmetryCenterLength = goRight - goLeft + 1;
            --goLeft;
            ++goRight;
        }
        return Math.max(midCenterLength, symmetryCenterLength);
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }


}
