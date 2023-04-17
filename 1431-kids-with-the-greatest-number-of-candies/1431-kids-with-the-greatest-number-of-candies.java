class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max=Integer.MIN_VALUE;
        for(int candie:candies){
            max = Math.max(max,candie);
        }
        List<Boolean> list = new ArrayList<>();
        for(int candie:candies){
            if(candie+extraCandies>=max) list.add(true);
            else list.add(false);
        }
        return list;
    }
}