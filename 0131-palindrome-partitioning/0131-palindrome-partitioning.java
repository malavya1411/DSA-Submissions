class Solution {
    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public void backtrack(String s, int ind, List<String> temp,
                          List<List<String>> ans) {

        if (ind == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = ind; i < s.length(); i++) {
            if (isPalindrome(s, ind, i)) {

                temp.add(s.substring(ind, i + 1));

                backtrack(s, i + 1, temp, ans);

                temp.remove(temp.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();

        backtrack(s, 0, temp, ans);

        return ans;
    }
}