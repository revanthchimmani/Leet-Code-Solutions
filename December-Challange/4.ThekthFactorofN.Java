class Solution {
    public int kthFactor(int n, int k) {
        int k1=0;
        //checking factors till n/2
        for(int i=1;i<=n/2i++){
            if(n % i == 0){
                k1++;
                if(k1==k){
                    return i;
                }
            }
        }
        //check if last factor is n 
        if((k1+1)==k){
            return n;
        }
        return -1;
    }
}
