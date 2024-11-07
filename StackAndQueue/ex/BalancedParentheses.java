package JavaAdvanced.StackAndQueue.ex;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //{[()]} - This is a balanced parenthesis.
        //{[(])} - This is not a balanced parenthesis

        String[] brackets = scanner.nextLine().split("");

        String result = isBalanced(brackets) ? "YES" : "NO";

        System.out.println(result);
    }

    public static boolean isBalanced(String[] brackets){
        //Creating the stack
        Deque<String> bracketsStack = new ArrayDeque<>();

        boolean isBalanced = true;

        for (int i = 0; i < brackets.length; i++) {
            switch (brackets[i]){
                case "}" ->{
                    if (bracketsStack.isEmpty()){
                        isBalanced = false;
                    }else {
                        String topBracket = bracketsStack.pop();
                        if (!topBracket.equals("{")){
                            isBalanced = false;
                        }
                    }
                }
                case ")" ->{
                    if (bracketsStack.isEmpty()){
                        isBalanced = false;
                    }else {
                        String topBracket = bracketsStack.pop();
                        if (!topBracket.equals("(")){
                            isBalanced = false;
                        }
                    }
                }
                case "]" ->{
                    if (bracketsStack.isEmpty()){
                        isBalanced = false;
                    }else {
                        String topBracket = bracketsStack.pop();
                        if (!topBracket.equals("[")){
                            isBalanced = false;
                        }
                    }
                }
                default ->{
                    bracketsStack.push(brackets[i]);
                }
            }
        }
        return isBalanced;
    }
}
