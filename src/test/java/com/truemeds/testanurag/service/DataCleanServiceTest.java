package com.truemeds.testanurag.service;

import com.truemeds.testanurag.model.ReduceResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

final class DataCleanServiceTest {

    @Test
    void givenCase1ThenReturnResult(){
       final DataCleanService service = new DefaultDataCleanService();

       final ReduceResult resultCase1 = service.reduceCharacters("baacdccce");
       assertEquals("bcde", resultCase1.getProcessedData());
       assertEquals(2, resultCase1.getCount());

        final ReduceResult resultCase2 = service.reduceCharacters("aabcbb cdee");
        assertEquals("bd", resultCase2.getProcessedData());
        assertEquals(4, resultCase2.getCount());
    }

}