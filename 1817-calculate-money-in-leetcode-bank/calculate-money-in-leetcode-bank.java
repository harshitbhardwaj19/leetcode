class Solution {
    public int totalMoney(int n) {
        int fullWeeks = n / 7;
        int total = fullWeeks * 28;
        System.out.println(total);
        total += ((fullWeeks - 1) * fullWeeks * 7) / 2;
        System.out.println(total);
        int rem = n % 7;
        total += ((rem + 1) * rem) / 2;
        System.out.println(total);
        total += fullWeeks * rem;
        System.out.println(total);
        return total;
    }
}