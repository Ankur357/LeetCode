class Solution {
    public void sortColors(int[] arr) {
     int low =0, mid=0, high=arr.length-1;
        while(mid<=high){
            if(arr[mid]==0){
                int tmp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = tmp;
                low++;
                mid++;
            }
            else if(arr[mid]==1) mid++;
            else {
                int tmp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = tmp;
                high--;
            }  
        }
    }
}