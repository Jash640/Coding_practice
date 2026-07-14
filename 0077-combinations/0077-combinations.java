class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>list=new ArrayList<>();
        dfs(n,k,1,list,new ArrayList<>());
        return list;
    }
    public void dfs(int n,int k,int start,List<List<Integer>>list,List<Integer>slist){
        if(slist.size()==k){
            list.add(new ArrayList<>(slist));
            return;
        }
        for(int i=start;i<=n;i++){
            slist.add(i);
            dfs(n,k,i+1,list,slist);
            slist.remove(slist.size()-1);
        }
    }
}