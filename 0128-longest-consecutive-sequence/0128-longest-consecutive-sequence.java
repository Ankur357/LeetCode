class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums) set.add(num);
        int max = 0;
        for(int num:nums){
            if(!set.contains(num-1)){
                int currNum = num;
                int count=1;
                while(set.contains(currNum+1)){
                    currNum +=1;
                    count+=1;
                }
                max= Math.max(max,count);
            }
        }
        return max;
    }
}