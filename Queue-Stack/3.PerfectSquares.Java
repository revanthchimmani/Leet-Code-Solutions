/**
Perfect Squares
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
*/

class PerfectSquares {
  public int numSquares(int n) {
      Queue<Integer> q = new LinkedList<>();
      Set<Integer> visited =new HashSet<>();
      q.offer(0);
      visited.add(0);
      int depth = 0;
      while(!q.isEmpty()){
          int size = q.size();
              depth++;
          while(size-- > 0){
              int prevSum = q.poll();
              for(int i=1;i*i<=n;i++){
                  int tempSum=prevSum+i*i;
                  if(tempSum == n){
                      return depth;
                  }
                  if(tempSum > n){
                      break;
                  }
                  if(!visited.contains(tempSum)){
                      q.offer(tempSum);
                      visited.add(tempSum);
                  }
              }
          }
      }
      return depth;
  }
}
