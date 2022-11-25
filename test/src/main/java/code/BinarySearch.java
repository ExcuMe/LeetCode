package code;

import java.util.Arrays;

/**
 * @author: wuyujie
 * @Date: 2022-07-03-15:56
 * @Description: 二分法查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr= {30,20,50,10,80,9,7,12,100,40,8};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(binarySearch(arr,40, 0, arr.length - 1));
    }

    /**
     *  查找一个数组元素的下标。
     * 二分法适用于已经排好序的数组，定义两个变量，一个low,一个high,则mid=(low+high)/2
     * 算法核心：
     * 如果 value==arr[mid],中间值正好等于要查找的值，则返回下标，return mid;
     * 如果 value<arr[mid],要找的值小于中间的值，则再往数组的小端找，high=mid-1;
     * 如果 value>arr[mid],要找的值大于中间的值，则再往数组的大端找，low=mid+1;
     *
     * 使用递归的二分查找
     *title:binarySearch
     *@param arr 有序数组
     *@param key 待查找关键字
     *@return 找到的位置
     */
    public static int binarySearch(int[] arr,int key,int low,int high){

        if(key < arr[low] || key > arr[high] || low > high){
            return -1;
        }

        int middle = (low + high) / 2;			//初始中间位置
        if(arr[middle] > key){
            //比关键字大则关键字在左区域
            return binarySearch(arr, key, low, middle - 1);
        }else if(arr[middle] < key){
            //比关键字小则关键字在右区域
            return binarySearch(arr, key, middle + 1, high);
        }else {
            return middle;
        }

    }


}
