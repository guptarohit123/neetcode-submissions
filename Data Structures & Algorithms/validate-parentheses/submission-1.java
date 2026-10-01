class Solution {
    public boolean isValid(String s) {

        if(s.length() == 0 || s.length() % 2 != 0) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque();        
        
        for(int i = 0; i < s.length() ; i++) {
            char bracket = s.charAt(i);

            if(isOpenBracket(bracket)) {
                stack.push(bracket);
            } else {
                 if (stack.isEmpty()) {
                    return false;
                }

                char prevOpenBracket =  stack.pop();
                if(!matches(prevOpenBracket,bracket)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();


    }

    private boolean isOpenBracket(char bracket) {
        return bracket == '(' 
                || bracket == '['
                || bracket == '{';
    }

    private boolean matches(char open, char close) {
        return (open == '(' && close == ')')
                || (open == '[' && close == ']')
                || (open == '{' && close == '}');
    }
}
