class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n!=1 && !set.contains(n)){
            set.add(n);
            n = getNext(n);
        }
        return n==1;
    }
    private int getNext(int n){
        int sum=0;
        while(n>0){
            int d= n%10;
            n /=10;
            sum+=d*d;
        }
        return sum;
    }
}