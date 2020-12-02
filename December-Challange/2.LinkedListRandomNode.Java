/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class LinkedListRandomNode {
    Random rand = null;
    ListNode h = null;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        h = head;
        rand = new Random();
    }

    /** Returns a random node's value. */
   
    /*
    * 1. This question gave us a linked list to return a node randomly. The most direct way is to first count the length of the linked list, then randomly generate a position based on the length, and then traverse from   the beginning to this position. See the code as follows: It will fail if linkedlist length is very large!
    */
    public int getRandom1() {
        ListNode temp=h;
        int length=0;
        //Finding the length
        while(temp!=null){
            temp=temp.next;
            length++;
        }
        //picking the random index
        int index = (int) Math.random()%length;
        temp=h;
        while(index>0){
            --index;
            temp=temp.next;
        }
        return temp.val;
    }
    /**
    * In Follow up, it is said that the linked list may be very long, and we cannot know the length in advance. Here, the famous Reservoir Sampling idea is used.:
    */
        public int getRandom() {
        ListNode temp=h;
        int result=-1;
        //Finding the length
        for(int index=1;temp!=null;index++){
            if(rand.nextInt(index)==index-1){
                result=temp.val;
            }
            temp=temp.next;
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
