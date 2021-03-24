package jrout.tutorial.datastructure.excercises;

import jrout.tutorial.datastructure.Stack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MatchingParenthesis {
    public static void main(String[] args) throws Exception {
        String input = "${abc(xyz{lmn})}}";
        Set<Character> openParanSet = new HashSet<>();
        openParanSet.add('{');
        openParanSet.add('(');
        openParanSet.add('[');

        Map<Character,Character> matchingParenMap = new HashMap<>();
        matchingParenMap.put('}','{');
        matchingParenMap.put(']','[');
        matchingParenMap.put(')','(');

        boolean isGood = true;
        Stack<Character> parenStack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            // Add to the stack for an opening paren.
            if (openParanSet.contains(ch)) {
                parenStack.push(ch);
            }
            if (matchingParenMap.containsKey(ch)) {
                if (parenStack.isEmpty()) {
                    isGood = false;
                    break;
                }
                Character lastParen = parenStack.pop();
                if (lastParen != matchingParenMap.get(ch)) {
                    isGood  = false;
                    break;
                }
            }
        }

        System.out.println("All Matching good ? "+ isGood);
    }

}
