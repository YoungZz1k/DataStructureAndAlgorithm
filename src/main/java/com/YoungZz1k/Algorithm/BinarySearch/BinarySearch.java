package com.YoungZz1k.Algorithm.BinarySearch;


public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {1,4,20,56,78,88,99,141,151,164,178,198,223,224,255,343};
        int mid = BinarySearch03(a, 1);
        System.out.println("the index is " + mid);
    }

    /**
     * 基础版
     * @param a
     * @param target
     * @return
     */
    private static int BinarySearch01(int[] a, int target){
        int begin = 0;
        int end = a.length - 1;
        int mid = ((begin + end) >>> 1);
        while (begin <= end){
            mid = ((begin + end) >>> 1);
            if(target > a[mid]){
                begin = mid + 1;
            }
            else if(target < a[mid]){
                end = mid -1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    /**
     * 改动版
     * @param a
     * @param target
     * @return
     */
    private static int BinarySearch02(int[] a, int target){
        int begin = 0;
        int end = a.length;
        int mid = ((begin + end) >>> 1);
        while (begin < end){
            mid = ((begin + end) >>> 1);
            if(target > a[mid]){
                begin = mid + 1;
            }
            else if(target < a[mid]){
                end = mid;
            }else{
                return mid;
            }
        }
        return -1;
    }

    /**
     * 平衡版
     * @param a
     * @param target
     * @return
     */
    private static int BinarySearch03(int[] a, int target){
        int begin = 0;
        int end = a.length;
        while(1 < end - begin){
            int mid = (begin + end) >>> 1;
            if(target < a[mid]){
                end = mid;
            }else{
                begin = mid;
            }
        }
        if(a[begin] == target){
            return begin;
        }else{
            return -1;
        }
    }

    /**
     * 有重复元素的话返回最左边那个
     * @param a
     * @param target
     * @return
     */
    private static int BinarySearchLeftMost(int[] a, int target){
        int begin = 0;
        int end = a.length - 1;
        int condidate = -1;
        while (begin <= end){
            int mid = ((begin + end) >>> 1);
            if(target > a[mid]){
                begin = mid + 1;
            }
            else if(target < a[mid]){
                end = mid -1;
            }else{
                // 确认候选者
                condidate = mid;
                end = mid - 1;
            }
        }
        return condidate;
    }

    /**
     * 有重复元素的话返回最右边那个
     * @param a
     * @param target
     * @return
     */
    private static int BinarySearchRightMost(int[] a, int target){
        int begin = 0;
        int end = a.length - 1;
        int condidate = -1;
        while (begin <= end){
            int mid = ((begin + end) >>> 1);
            if(target > a[mid]){
                begin = mid + 1;
            }
            else if(target < a[mid]){
                end = mid -1;
            }else{
                // 确认候选者
                condidate = mid;
                begin = mid + 1;
            }
        }
        return condidate;
    }


}
