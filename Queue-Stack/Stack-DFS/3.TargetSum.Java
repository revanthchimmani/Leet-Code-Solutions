/**
You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:

Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
 

Constraints:

The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.

***Naive Recursive Solution ***
*/

class TargetSum {
    public int findTargetSumWays(int[] nums, int targetSum) {
        if(nums==null || nums.length==0){
            return 0;
        }
        return helper(nums,targetSum, 0);
    }
    
    private int helper(int[] nums, int currentSum, int curIndex){

        if(curIndex==nums.length && (0 == currentSum)){
            return 1;
        }

        if(curIndex!=nums.length ){
           int count1=helper(nums, currentSum+nums[curIndex], curIndex+1);
           int count2=helper(nums, currentSum-nums[curIndex], curIndex+1);
            return count1+count2;
        }
        return 0;
    }
}
