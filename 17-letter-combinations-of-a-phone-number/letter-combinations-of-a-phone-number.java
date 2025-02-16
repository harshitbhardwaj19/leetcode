class Solution {
    String arr[];
    List<String> list;

    public List<String> letterCombinations(String digits) {
        arr = new String[] { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        list = new ArrayList<>();
        if (digits.equals("")) {
            return list;
        }
        letterCombinations(digits, 0, "");
        return list;
    }

    public void letterCombinations(String digits, int index, String combination) {
        if (index == digits.length()) {
            list.add(combination);
            return;
        }

        String str = arr[digits.charAt(index) - '2'];
        for (char ch : str.toCharArray()) {
            letterCombinations(digits, index + 1, combination + ch);
        }
    }
}