/*
* Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
* 
* Input: n = 3
* Output: [[1,2,3],[8,9,4],[7,6,5]]
* 
* Input: n = 1
* Output: [[1]]
* 
*/
class SpiralMatrixTwo {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int k=1;
        int top = 0;
        int bottom = n-1;
        int right = n-1;
        int left = 0;
        
        while(k<=(n*n)){
            //Iterate left -> right
            for(int i=left; i<=right;i++){
                result[top][i]=k;
                k++;
            }
            top++;
            //Iterate top -> bottom
            for(int i=top;i<=bottom;i++){
                result[i][right]=k;
                k++;
            }
            right--;
            //Iterate right -> left
            for(int i=right;i>=left;i--){
                result[bottom][i]=k;
                k++;
            }
            bottom--;
            //Iterate bottom -> top
            for(int i=bottom;i>=top;i--){
                result[i][left]=k;
                k++;
            }
            left++;
        }
        return result;
    }
}
