package com.truemeds.testanurag.service;

import com.truemeds.testanurag.model.ReduceResult;

public interface DataCleanService {

    /**
     * Removes adjacent duplicate characters from given String
     * @param data Input string from which characters need to be removed
     * @return {@link ReduceResult} having clean string with no adjacent repeating characters and count of steps
     */
    ReduceResult reduceCharacters(final String data);
}
