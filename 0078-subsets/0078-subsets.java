class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>list=new ArrayList<>();
        dfs(list,new ArrayList<>(),nums,0);
        return list;
    }
    public void dfs(List<List<Integer>>list,List<Integer>slist,int[] nums,int start){
        list.add(new ArrayList<>(slist));
        for(int i=start;i<nums.length;i++){
            slist.add(nums[i]);
            dfs(list,slist,nums,i+1);
            slist.remove(slist.size()-1);
        }
    }
}