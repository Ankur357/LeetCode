class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids.length<=1) return asteroids;
        Stack<Integer> stack = new Stack<>();
        for (int asteriod : asteroids) {
            if (asteriod > 0) { 
                stack.push(asteriod);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && Math.abs(stack.peek()) < Math.abs(asteriod))  
                    stack.pop();
                if (stack.isEmpty() || stack.peek() < 0) 
                    stack.push(asteriod);
                else if (stack.peek() == Math.abs(asteriod)) 
                    stack.pop();
            }
        }
        int[] arr = new int[stack.size()];
        for(int i=stack.size()-1;i>=0;i--){
            arr[i] = stack.pop();
        }
        return arr;
    }
}