class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map =new HashMap<>();
        int j=0;
        while(j<nums.length){
            if(!map.containsKey(nums[j])){
                map.put(nums[j],j);
            }
            else{
                if(Math.abs(map.get(nums[j])-j)<=k) return true;
                map.put(nums[j],j);
            }
            j++;
        }
        return false;
    }
}