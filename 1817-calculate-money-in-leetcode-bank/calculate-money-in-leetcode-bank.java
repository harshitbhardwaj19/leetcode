class Solution {
    public int totalMoney(int n) {
        int fullWeeks = n / 7;
        int total = fullWeeks * 28;
        total += ((fullWeeks - 1) * fullWeeks * 7) / 2;
        int rem = n % 7;
        total += ((rem + 1) * rem) / 2;
        total += fullWeeks * rem;
        return total;
    }
}