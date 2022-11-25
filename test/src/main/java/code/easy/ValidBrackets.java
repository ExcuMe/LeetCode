package code.easy;

import java.util.*;

/**
 * LeetCode 20 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 */
public class ValidBrackets {

    public static void main(String[] args) {
        String str = "[{()()}]";
        System.out.println(isValidByMyself(str));
    }

    /**
     * 使用堆栈
     * @param s
     * @return
     */
    public static boolean isValidByMyself(String s) {
        HashMap<String, String> bracketsMap = new HashMap<>();
        bracketsMap.put("(", ")");
        bracketsMap.put("{", "}");
        bracketsMap.put("[", "]");

        List<String> list = Arrays.asList(s.split(""));
        Stack<String> stack = new Stack<>();
        for (String str : list) {
            if (bracketsMap.containsKey(str)) {
                stack.push(str);
            }
            if (bracketsMap.containsValue(str)) {
                if (stack.isEmpty()){ // 空
                    return false;
                }
                if (!bracketsMap.get(stack.pop()).equals(str)) { // 不匹配
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * 字符串替换 思路
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        int length = s.length() / 2;
        for (int i = 0; i < length; i++) {
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        }

        return s.length() == 0;
    }
}
