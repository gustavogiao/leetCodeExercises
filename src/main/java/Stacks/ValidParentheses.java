package Stacks;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "([)]";
        String sValid = "([])";
        System.out.println(isValid(s));
        System.out.println(isValid(sValid));
    }

    // stack []
    // ( -> push('(') -> stack['(']
    // [ -> push('[') -> stack['(','[']
    // ) -> not empty || stack.pop() -> '[' // hash.get('[') = ']' // ']' != ')' false;
    // return false

    // stack[]
    // ( -> push('(') -> stack['(']
    // [ -> push('[') -> stack['(','[']
    // ] -> not empty || stack.pop -> '[' // hash.get('[') = ']' // ']' == ']' true;
    // stack['(']
    // ) -> not empty || stack.pop -> '(' // hash.get('(') = ')' // ')' == ')' true;
    // true

    public static boolean isValid(String s){
        HashMap<Character, Character> hash = new HashMap<>();
        hash.put('(', ')');
        hash.put('[', ']');
        hash.put('{', '}');

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(hash.containsKey(c)){
                stack.push(c);
            }else if(hash.containsValue(c)){
                if(stack.isEmpty() || hash.get(stack.pop()) != c){
                    return false;
                }
            }
        }

        return stack.isEmpty();

    }
}
