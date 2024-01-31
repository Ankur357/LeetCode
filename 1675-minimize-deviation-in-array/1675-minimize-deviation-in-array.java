class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> max= new PriorityQueue<>((a,b)->b-a);
        int min = Integer.MAX_VALUE;
        for(int num: nums){
            if(num%2==1) num*=2;
            min = Math.min(min,num);
            max.add(num);
        }
        int diff = Integer.MAX_VALUE;
        while(max.peek()%2==0){
            int maxVal = max.poll();
            diff = Math.min(diff,maxVal-min);
            min = Math.min(min,maxVal/2);
            max.add(maxVal/2);
        }
        return Math.min(diff,max.peek()-min);
    }
}
