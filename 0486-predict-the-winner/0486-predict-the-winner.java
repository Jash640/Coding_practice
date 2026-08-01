class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        if(n%2==0)return true;
        int []arr=nums.clone();
        for(int i=n-2;i>=0;--i){
            for(int j=i+1;j<n;j++){
                arr[j]=Math.max(nums[i]-arr[j], nums[j]-arr[j-1]);
            }
        }
        return arr[n-1]>=0;
    }
}