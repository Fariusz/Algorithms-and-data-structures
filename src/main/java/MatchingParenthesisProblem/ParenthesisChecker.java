package MatchingParenthesisProblem;

import java.util.Stack;

public class ParenthesisChecker {
    public static boolean isBalanced(String expression) {

        Stack<Character> stack = new Stack<>();
        String openingParentheses = "({[";
        String closingParentheses = ")}]";
        String matchingParentheses = "(){}[]";

        for (char ch : expression.toCharArray()) {
            if (openingParentheses.contains(String.valueOf(ch))) {
                stack.push(ch);
            } else if (closingParentheses.contains(String.valueOf(ch))) {
                if (stack.isEmpty()) {
                    return false;
                }
                char lastOpening = stack.pop();
                String parenthesesPair = String.valueOf(lastOpening) + ch;
                if (!matchingParentheses.contains(parenthesesPair)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("({[()]}"));  // false
        System.out.println(isBalanced("({[()]})"));  // true
        System.out.println(isBalanced("({[()}]"));  // false
        System.out.println(isBalanced("()"));  // true
        System.out.println(isBalanced("))"));  // false
    }
}
