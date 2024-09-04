
//DFS
//TC : 
//SC :
class Solution {
    List<String> result;
    HashSet<String> set;
    int max;

    private boolean isValid(String s) {
        int count = 0;
        for(int i=0 ; i <s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isAlphabetic(c))
                continue;
            if(count < 0) {
                return false;
            }
            if(c == '(') {
                count ++;
            } else if(c == ')') {
                count--;
            }
        }
        return count == 0;
    }

    private void dfs(String s) {
        //base
        if(s.length() < max || set.contains(s))
            return;
        if(isValid(s)) { // here s.len > or == to max
            if(s.length() > max) {
                max = s.length();
                result = new ArrayList<>(); // empty the earliar list as it is anyways going to be lesser length
            }
            result.add(s);
        }
        //logic
        set.add(s);
        for(int i=0 ; i<s.length() ; i++) {
            if(Character.isAlphabetic(s.charAt(i)))
                continue;
            String childStr = s.substring(0, i) + s.substring(i+1, s.length());
            dfs(childStr);
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        result = new ArrayList<>();
        set = new HashSet<>();
        dfs(s);
        return result;
    }
}
