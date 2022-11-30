class Solution {
    public int pivotInteger(int n) {
        double s = Math.sqrt(n*(n+1)/2);
        return s%1==0?(int)s:-1;
    }
}