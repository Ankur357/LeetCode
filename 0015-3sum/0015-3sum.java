class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
//         Set<List<Integer>> res  = new HashSet<>();
//         if(nums.length==0) return new ArrayList<>(res);
//         Arrays.sort(nums);
//         for(int i=0; i<nums.length-2;i++){
//             int j =i+1;
//            int  k = nums.length-1;
//             while(j<k){
//                 int sum = nums[i]+nums[j]+nums[k];
//                 if(sum==0)res.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
//                 else if (sum >0) k--;
//                 else if (sum<0) j++;
//             }

//         }
//         return new ArrayList<>(res);
        List<List<Integer>> list = new ArrayList<>();
        if(nums.length==0 || nums.length<3) return list;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i==0 || i>0 && nums[i]!=nums[i-1]){
                int l=i+1;
                int r=nums.length-1;
                int sum = 0-nums[i];
                while(l<r){
                    if(nums[l]+nums[r]==sum){
                        list.add(Arrays.asList(nums[i],nums[l],nums[r]));
                        while(l<r && nums[l]==nums[l+1]) l++;
                        while(l<r && nums[r]==nums[r-1]) r--;
                        l++;
                        r--;
                                             }
                else if(nums[l]+nums[r]<sum) l++;
                else r--;
                }
            }
        }
        return list;

    }
}