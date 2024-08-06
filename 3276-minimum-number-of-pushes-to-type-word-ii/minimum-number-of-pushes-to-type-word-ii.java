class Solution {
    public int minimumPushes(String word) {
        int arr[] = new int[26];

        for(char ch : word.toCharArray()){
            arr[ch-'a']++;
        }

        Arrays.sort(arr);
        int counter = 8;
        int mul = 1;
        int taps = 0;
        int i = 25;
        while(i>=0 && arr[i]>0){
            taps += arr[i]*mul;
            // System.out.println(taps);
            counter--;
            if(counter == 0){
                counter=8;
                mul++;
            }
            i--;
        }
        return taps;
    }
}