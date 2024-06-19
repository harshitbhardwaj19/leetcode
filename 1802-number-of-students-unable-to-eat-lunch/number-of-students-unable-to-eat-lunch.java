class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();
        for(int num : students){
            q.add(num);
        }
        int j = 0;
        while(q.size()!=0){
            int size = q.size();
            for(int i=0; i<size; i++){
                int choice = q.poll();
                if(choice == sandwiches[j]){
                    j++;
                } else {
                    q.add(choice);
                }
            }
            if(q.size()==size){
                return size;
            }
        }
        return 0;
    }
}