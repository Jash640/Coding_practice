class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count=0;
        int prefix=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int num:nums){
            prefix+=num;
            int mod=prefix%k;
            if(mod<0){
                mod+=k;
            }
            if(map.containsKey(mod)){
                count+=map.get(mod);
                map.put(mod,map.get(mod)+1);
            }else{
                map.put(mod,1);
            }
        }
        return count;
    }
}