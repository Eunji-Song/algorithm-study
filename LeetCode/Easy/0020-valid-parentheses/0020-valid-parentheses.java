class Solution {
     public boolean isValid(String s) {
        Map<String, String> brackets = new HashMap<>();
        brackets.put("(", ")");
        brackets.put("{", "}");
        brackets.put("[", "]");

        Stack<String> stack = new Stack<>();

        if (s == null || s.length() < 2) {
            return false;
        } else {
            int length = s.length();

            for (int i = 0; i < length; i++) {
                String target = String.valueOf(s.charAt(i));

                if (brackets.containsKey(String.valueOf(s.charAt(i)))) {
                    stack.push(target);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }

                    String close = brackets.get(stack.pop());
                    if (!close.equals(target)) {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty(); 
    }
}