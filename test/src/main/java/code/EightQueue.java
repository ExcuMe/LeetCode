package code;

/**
 * @author: wuyujie
 * @Date: 2022-07-03-18:50
 * @Description: 八皇后——经典回溯问题
 *
 * 八皇后问题，是一个古老而著名的问题，是回溯算法的典型案例。
 * 该问题是由国际西洋棋手马克斯 • 贝瑟尔于1848年提出：
 * 在8×8格的国际象棋上摆放八个皇后，使其不能互相攻击，即：任意两个皇后不能处于同一行、同一列或同一斜线上，问有多少种摆法
 */
public class EightQueue {

    int max = 8;//皇后个数
    static  int count = 0;//记录有多少种摆法

    /**
     * 初始化一个数组用于存放结果
     * 这里用一维数组存放数据就可以了，这里一维数组中的值存放的是皇后的列坐标，
     * 因为规定皇后是不能摆放在同一行，所以每一行只有一个皇后 ； 一维数组 arr
     * 的第一个值就是 棋盘第一行皇后的列坐标值，第二个值就是皇后在棋盘第二行的列坐标值
     */
    int[] arr = new int[max];

    public static void main(String[] args) {

        EightQueue quuen = new EightQueue();
        quuen.PutQuuen(0);
        System.out.println("共有"+count+"种摆法");
    }

    //写一个摆皇后的方法
    private void PutQuuen(int n) {
        if(n==max) {//因为n是从0开始增加，即n=0表示放第一个皇后，当n==max时表示皇后已经摆完了
            Print();
            return;
        }
        for(int i=0;i<max;i++) {
            arr[n]=i;//放置第一个皇后
            if(judge(n)) {//判断皇后的位置是否冲突，不冲突继续放下一个皇后
                PutQuuen(n+1);
            }
        }
    }


    // 写一个方法，判断皇后在该位置是否会引起冲突，即在同一行或同一列或同一斜线
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {

            /*
             * 1. 判断 皇后是否在同一列，只需判断皇后的列坐标是否相等即可，即arr[i] == arr[n]
             * 2. i判断皇后是否在同一斜线上，只需判断两个皇后的列坐标之差的绝对值与其横坐标之差的绝对值是否相等即可，
             *   即Math.abs(n - i) == Math.abs(arr[i] - arr[n])
             *  */
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[i] - arr[n])) {
                return false;//违反了规则，返回false
            }
        }
        return true;
    }

    //输出
    private void Print() {
        // TODO Auto-generated method stub
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        count++;
        System.out.println();
    }


}
