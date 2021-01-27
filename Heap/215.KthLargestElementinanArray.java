/**

Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.

*/
class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length==0 || nums.length<k){
            return -1;
        }
        //Min Heap of size k
        PriorityQueue<Integer> pq =new PriorityQueue<>(k);
        //Min Heap with 1st K element
        for(int i=0;i<k;i++){
            pq.add(nums[i]);
        }
        for(int i=k;i<nums.length;i++){
            if(pq.peek()<nums[i]){
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }
}
