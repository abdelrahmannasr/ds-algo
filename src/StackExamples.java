import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StackExamples {

    private final List<Character> leftBrackets = Arrays.asList('(', '<', '[', '{');
    private final List<Character> rightBrackets = Arrays.asList(')', '>', ']', '}');

    public String stringReverser(String input) {
        if (input == null) throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray())
            stack.push(ch);

        StringBuffer reversedString = new StringBuffer();
        while (!stack.empty())
            reversedString.append(stack.pop());

        return reversedString.toString();
    }

    public boolean isStringBalanced(String input) {
        if (input == null) throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();

        for (char ch: input.toCharArray()) {
            if (isLeftBracket(ch)) stack.push(ch);

            if (isRightBracket(ch)) {
                if (stack.empty()) return false;

                var leftBracket = stack.pop();
                if (!bracketsMatched(leftBracket, ch)) return false;
            }
        }

        return stack.empty();
    }

    private boolean isLeftBracket(char ch) {
        return leftBrackets.contains(ch);
    }

    private boolean isRightBracket(char ch) {
        return rightBrackets.contains(ch);
    }

    private boolean bracketsMatched(char left, char right) {
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }

}
