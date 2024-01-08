class Solution {
    public String minWindow(String s, String t) {
        String ans="";
        int i=0,j=0;
        int min=Integer.MAX_VALUE;
        HashMap<Character,Integer> map=new HashMap<>();
         for(int k=0;k<t.length();k++){
            map.put(t.charAt(k),map.getOrDefault(t.charAt(k),0)+1);
        }
        int count=map.size();
        
        while(j<s.length())
        {
            if(map.containsKey(s.charAt(j))){
                int val = map.get(s.charAt(j))-1;
                map.put(s.charAt(j),val);
                if(val==0) count--;
            }
            if(count==0)
            {
                if(min>j-i+1)
                {
                    ans=s.substring(i,j+1);
                    min=Math.min(min,j-i+1);
                }
                while(count==0)
                {
                    char c1=s.charAt(i);
                    if(!map.containsKey(c1))
                        i++;
                    else{
                        map.put(c1,map.get(c1)+1);
                        if(map.get(c1)>0)
                            count++;
                        i++;
                    }
                    if(count==0)
                    {
                        if(min>j-i+1)
                        {
                            ans=s.substring(i,j+1);
                            min=j-i+1;
                        }
                    }
                }
            }
            j++;
        }
        return ans;
    }
}