class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subArrays(nums,k)-subArrays(nums,k-1);
    }
    public int subArrays(int[] nums,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int i=0;
        int j=0;
        int count=0;
        while(j<nums.length){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while(map.size()>k){
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i])==0) map.remove(nums[i]);
                i++;
            }
            count+=(j-i+1);
            j++;
        }
        System.out.println(count);
        return count;
    }
}