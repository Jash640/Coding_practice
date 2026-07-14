class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>list=new ArrayList<>();
        dfs(nums,new boolean[nums.length],new ArrayList<>(),list);
        return list;
    }
    public void dfs(int[] nums,boolean[] v,List<Integer>slist,List<List<Integer>>list){
        if(slist.size()==nums.length){
            list.add(new ArrayList<>(slist));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(v[i])continue;
            v[i]=true;
            slist.add(nums[i]);
            dfs(nums,v,slist,list);
            v[i]=false;
            slist.remove(slist.size()-1);
        }
    }
}