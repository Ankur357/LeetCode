class Solution {
    public String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String[] arr= path.split("/");
        for(int i=0;i<arr.length;i++){
            if(!s.isEmpty() && arr[i].equals("..")) s.pop();
            else if(!arr[i].equals("") && !arr[i].equals(".") && !arr[i].equals(".."))
                s.push(arr[i]);
        }
        if(s.isEmpty()) return "/";
        while(!s.isEmpty()){
            sb.insert(0,s.pop()).insert(0,"/");
        }
        return sb.toString();
    }
}