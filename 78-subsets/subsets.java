class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        subsets(nums, 0, list, new ArrayList<>());
        return list;
    }

    public void subsets(int[] nums, int start, List<List<Integer>> list, List<Integer> curr) {
        if (start > nums.length) {
            return;
        }

        list.add(new ArrayList<>(curr));

        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            subsets(nums, i + 1, list, curr);
            curr.remove(curr.size() - 1);
        }
    }
}