class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] arr = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                int prev = stack.pop();
                arr[prev] = i-prev;
            }
            stack.push(i);
        }
        return arr;
    }
}