class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        int arr[] = new int[friends.length];
        int i = 0;
        for (int id : order) {
            if (contains(id, friends)) {
                arr[i] = id;
                i++;
            }
        }
        return arr;
    }

    private boolean contains(int id, int[] friends) {
        for (int i = 0; i < friends.length; i++) {
            if (friends[i] == id) {
                return true;
            }
        }
        return false;
    }
}