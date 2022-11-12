package com.accountBook;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

/*
* given(준비): 어떠한 데이터가 준비되었을 때
* when(실행): 어떠한 함수를 실행하면
* then(검증): 어떠한 결과가 나와야 한다.
* */
class StandardTests {

    @BeforeAll
    static void initAll() {
        System.out.println("BeforeAll");
    }

    @BeforeEach
    void init() {
        System.out.println("BeforeEach");
    }

    @Test
    void succeedingTest() {
        System.out.println("succeedingTest");
    }

    @Test
    void failingTest() {
        fail("a failing test");
    }

    @Test
    @Disabled("for demonstration purposes")
    void skippedTest() {
        // not executed
    }

    @Test
    void abortedTest() {
        assumeTrue("abc".contains("Z"));
        fail("test should have been aborted");
    }

    @AfterEach
    void tearDown() {
        System.out.println("AfterEach");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("AfterAll");
    }

}