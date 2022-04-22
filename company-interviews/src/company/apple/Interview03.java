package company.apple;

/* Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string “”.

eg 1: Input: strs = ["flower","flow","flight"]
Output: “fl”

eg 2: Input: strs = [“dog”,”racecar”,”car”] Output: “” Explanation: There is no common prefix among the input strings.

0<=len<=10000

*/

class Interview03 {

    public String longestCommonPrefix(String[] strs) {

        StringBuilder solution = new StringBuilder();

        if (strs == null || strs.length == 0) {
            return solution.toString();
        }

        if (strs.length == 1) {
            return strs[0];
        }

        boolean appendChar = true;
        String currentWord = null;

        for (int i = 0; i < strs[0].length(); i++) {
            char currentLetter = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                currentWord = strs[j];

                if (i < currentWord.length() && currentWord.charAt(i) != currentLetter) {
                    appendChar = false;
                }

                if (i >= currentWord.length()) {
                    appendChar = false;
                }
            }

            if (i < currentWord.length() && appendChar) {
                solution.append(currentWord.charAt(i));
            }
        }

        return solution.toString();
    }

    public static void main (String args[]) {
        Interview03 solution = new Interview03();
        String[] strs = {"aaa","aa","aaa"};

        String result = solution.longestCommonPrefix(strs);
        System.out.println(result);
    }
}

