package code;

/**
 * @author: wuyujie
 * @Date: 2022-07-03-16:02
 * @Description: 无序数组上的搜索统计
 *
 */
public class ArraySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 5, 2, 3};
        work(arr, arr.length);
        int index = 1;
        for (int countResult : arr
        ) {
            System.out.println(index++ + "出现了" + (-1) * countResult + "次");
        }
    }

    /**
     *  * 题目描述：
     *  * 一个长度大小为N的数组，数组中的每个元素的取值范围在[1，N]，且为正整数。
     *  * 问：如何在时间复杂度为O(N)，空间复杂度为O(1)的条件下，统计数组中不同元素出现的次数。
     *
     * 解题思路
     * 遍历数组，通过当前元素的值作为下标，找到下一个元素。
     * 最后得到的数组中，下标（因为数组的下标都是从0开始的，所以需要+1）为数组中出现的元素，每个下标对应的值取反输出即是该元素出现的次数。
     * 若当前元素小于0，则跳过
     * 若当前元素大于0，则判断其作为下标对应的元素是否大于0。若大于0，则把对应的元素赋值给当前元素，并把它的值设置为-1；若小于0，则把对应的元素自减1，当前元素置为0；
     *
     *
     * // 数组举例
     * int[] arr = {2, 5, 5, 2, 3};
     * 1、遍历数组，第一个arr[0]=2，然后看下标为2的元素是arr[2]=5。
     * 2、把arr[2]对应的5赋值给arr[0]，然后arr[2]就设置为-1
     * 3、然后重复整个过程直到结束
     * 它的整个变化过程就是这样
     * - {2, 5, 5, 2, 3}
     * - 5, [-1], 5, 2, 3
     * - 3, [-1], 5, 2, [-1]
     * - 5, [-1], [-1], 2, [-1]
     * - [0], [-1], [-1], 2, [-2]
     * - [0], [-2], [-1], [0], [-2]
     * 这个结果表示：1有0个，2有2个，3有一个，4有0个，5有2个
     *
     * @param arr
     * @param n
     */
    public static void work(int[] arr, int n) {
        int index = 0;
        while (index < n) {
            //因为数组都是从0开始的，所以arr[index]得减1才可以找到对应的元素，否则会数组越界
            int temp = arr[index] - 1;
            if (temp < 0) {
                index++;
                continue;
            }
            if (arr[temp] > 0) {
                arr[index] = arr[temp];
                arr[temp] = -1;
            } else {
                arr[temp]--;
                arr[index] = 0;
            }
        }
    }


}
