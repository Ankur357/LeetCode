class Solution {
    public int minMoves(int target, int maxDoubles) {
        int cnt=0;
        while(target>1 && maxDoubles>0){
            if(target%2!=0){
                target--;
            }
            else{
                target/=2;
                maxDoubles--;  
            }
            cnt++;
        }
        return cnt+target-1;
    }
}