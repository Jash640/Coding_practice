class Solution {
    public long sumAndMultiply(int n) {
        String number=String.valueOf(n);
        long sum=0;
        long x=0;
        for(char ch:number.toCharArray()){
            if(ch!='0'){
                int dig=ch-'0';
                x=x*10+dig;
                sum+=dig;
            }
        }
        return x *sum;
    }
}