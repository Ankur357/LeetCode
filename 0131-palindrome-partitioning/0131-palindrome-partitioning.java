class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(0,s,res,new ArrayList<>());
        return res;
    }
    void backtrack(int index,String s, List<List<String>> res, List<String> list){
        if(index==s.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(palindrome(s,index,i)){
                list.add(s.substring(index,i+1));
                backtrack(i+1,s,res,list);
                list.remove(list.size()-1);
            }
        }
    }
    boolean palindrome(String s,int i,int j){
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}