class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] c = new int[A.length];
        for(int i=0;i<A.length;i++){
            boolean found =false;
            for(int j=0;j<B.length;j++){
                if(A[i]==B[j]) found =true;
                if(found&&j>=i){
                    c[j]++;
                }
            }
        }
        return c;
    }
}