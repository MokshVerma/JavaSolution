package Amazon.Stacks;

import java.util.Stack;

public class ParenthesisChecker {

    static boolean ispar(String x){
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<x.length(); i++){
            switch (x.charAt(i)){
                case '{':{
                    stack.push(x.charAt(i));
                    break;
                }
                case '(':{
                    stack.push(x.charAt(i));
                    break;
                }
                case '[':{
                    stack.push(x.charAt(i));
                    break;
                }
                case '}':{
                    if(!stack.isEmpty() && stack.peek()=='{'){
                        stack.pop();
                    } else{
                        return false;
                    }
                    break;
                }
                case ']':{
                    if(!stack.isEmpty() && stack.peek()=='['){
                        stack.pop();
                    } else{
                        return false;
                    }
                    break;
                }
                case ')':{
                    if(!stack.isEmpty() && stack.peek()=='('){
                        stack.pop();
                    } else{
                        return false;
                    }
                    break;
                }
            }
        }
        return stack.isEmpty();
    }


}
