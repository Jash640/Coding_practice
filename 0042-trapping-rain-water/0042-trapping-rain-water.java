class Solution {
    public int trap(int[] height) {
        int total=0;
        int start=0,end=height.length-1;
        int leftmax=0,rightmax=0;
        while(start<end){
            leftmax=Math.max(leftmax,height[start]);
            rightmax=Math.max(rightmax,height[end]);
            if(height[start]<height[end]){
                total+=leftmax-height[start];
                start++;
            }else{
                total+=rightmax-height[end];
                end--;
            }
        }
        return total;
    }
}