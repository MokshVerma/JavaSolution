package Amazon.Stacks;

import java.util.Stack;

public class PostFix {

    public static int evaluatePostFix(String exp){
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<exp.length(); i++){
            int temp =0;
            switch (exp.charAt(i)){
                    case '+':{
                        temp = stack.pop();
                        stack.push(stack.pop()+temp);
                        break;
                    }
                    case '-':{
                        temp = stack.pop();
                        stack.push(stack.pop()-temp);
                        break;
                    }
                    case '/':{
                        temp = stack.pop();
                        stack.push(stack.pop()/temp);
                        break;
                    }
                    case '*':{
                        temp = stack.pop();
                        stack.push(stack.pop()*temp);
                        break;
                    }
                    default:{

                        stack.push((int)exp.charAt(i)-'0');
                    }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(evaluatePostFix("231*+9-"));
    }

}
