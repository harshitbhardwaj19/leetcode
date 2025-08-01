class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        list.add(temp);
        for(int i = 1; i<numRows; i++){
            temp = new ArrayList<>();
            temp.add(1);
            for(int j = 1; j<i; j++){
                int sum = list.get(i-1).get(j-1) + list.get(i-1).get(j);
                temp.add(sum);
            }
            temp.add(1);
            list.add(temp);
        }
        return list;
    }
}