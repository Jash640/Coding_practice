class Solution {
    public int gcdOfOddEvenSums(int n) {
        int oddsum=n*n;
        int evensum=n*(n+1);
        return gcd(oddsum,evensum);
    }
    public int gcd(int odd,int even){
        if(even==0){
            return odd;
        }
        return gcd(even,odd%even);
    }
}