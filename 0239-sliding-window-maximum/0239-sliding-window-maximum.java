class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] arr =new int[n-k+1];
        int cnt=0;
        int i=0;
        int j=0;
        Deque<Integer> q= new LinkedList<>();
        while(j<n){
            while(q.size()>0 && q.getLast()<nums[j]){
                q.removeLast();
            }
            q.add(nums[j]);
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                arr[cnt++] = q.getFirst();
                if(nums[i]==q.getFirst()) q.removeFirst();
                i++;
                j++;
            }
        }
        return arr;
    }
}