class Solution {
    public int maxProduct(int n) {
        n=Math.abs(n);
        int max1=-1;
        int max2=-1;
        while(n!=0){
            int rem=n%10;
           if(rem>=max1){
            max2=max1;
            max1=rem;
           }else if(rem>max2){
            max2=rem;
           }
            n/=10;
        }
        return (max1==-1||max2==-1)?0:max1*max2;
    }
}