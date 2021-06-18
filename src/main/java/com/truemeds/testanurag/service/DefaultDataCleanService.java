package com.truemeds.testanurag.service;

import com.truemeds.testanurag.model.ReduceResult;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

@Component
final class DefaultDataCleanService implements DataCleanService {

    private static final String USER = "Anurag Khadatkar";
    private static final char EMPTY_SPACE = ' ';

    DefaultDataCleanService() {}

    @Override
    public ReduceResult reduceCharacters(final String data) {
        if(data != null && !data.isEmpty()){
            final Map<String, Object> resultMap = removeDuplicateAdjacentChars(data);
            return new ReduceResult((String) resultMap.get("resultString"), (long) resultMap.get("count"), USER);
        } else {
            return new ReduceResult(data, 0, USER);
        }
    }

    private static Map<String, Object> removeDuplicateAdjacentChars(final String data){
        long stepsCount = 0;
        // result map to hold Cleaned String and number of steps
        Map<String, Object> resultMap = new HashMap<>();
        // using Stack here as it efficiently allows to check the last character in new string
        // and remove if it is repeated
        Stack<Character> reduceStack = new Stack<>();

        // this cache-variable to check the last removed repeating character
        char lastChar = data.charAt(0);
        // initialize stack with first character
        reduceStack.add(lastChar);

        for(int index = 1; index < data.length(); index++){
            // skip empty spaces
            if(data.charAt(index) == EMPTY_SPACE){
                continue;
            }

            // if the stack is empty, add current character to it
            if (reduceStack.isEmpty() || (reduceStack.peek() != data.charAt(index))) {
                // as we are removing matched character from stack as well, check in cache if current char matches
                // the last chars removed and is forming sequence.
                // If yes, no need to add
                if(lastChar != data.charAt(index)){
                    reduceStack.add(data.charAt(index));
                }
            } else {
                // if the current character matches last one in stack remove it
                lastChar = reduceStack.pop();
                stepsCount ++;
            }
        }

        resultMap.put("count", stepsCount);
        resultMap.put("resultString", stackToString(reduceStack));

        return resultMap;
    }

    /**
     * Utility method to convert Stack of characters back to String
     * @param stack Stack of characters to convert into String
     * @return String of characters
     */
    private static String stackToString(final Stack<Character> stack) {
        StringBuilder resultString = new StringBuilder();
        while(!stack.isEmpty()){
            resultString.insert(0, stack.pop());
        }
        return resultString.toString();
    }
}
