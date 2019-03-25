package com.example.unittesting;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class StringUtilTest {
    Student mockStudent;

    @Before
    public void setup() {
        mockStudent = mock(Student.class);
        Mockito.when(mockStudent.getStudentName()).thenReturn("Mike");

    }

    @Test
    public void testConcatTwoStrings() {

        final String one = "test";
        final String two = "method";
        final String expectedResult = one + " " + two;

        assertEquals(expectedResult, StringUtil.concatTwoStrings(one, two));
    }

    @Test
    public void testStringLengthGreaterThanFive_True(){
     assertTrue(StringUtil.stringLengthGreaterThanFive("Hexagon"));
    }

    @Test
    public void testStringLengthGreaterThanFive_False(){
        assertFalse(StringUtil.stringLengthGreaterThanFive("Lewis"));

    }

    @Test
    public void testReturnString_Null(){
        final String testString = null;
        assertNull(StringUtil.returnString(testString));

    }
    @Test
    public void testReturnString_NonNull(){
        final String testString = "I HAVE A VALUE";
        assertNotNull(StringUtil.returnString(testString));


    }

    @Test
    public void testProcessStudent() {
        final String middleText = " has a GPA of ";
        final String mockGPAValue = "3.0";
        final String expectedResult = "Mike" + middleText + mockGPAValue;

        Mockito.when(mockStudent.getStudentGPA()).thenReturn(mockGPAValue);
        assertEquals(expectedResult, StringUtil.processStudentName(mockStudent));

    }

    @Test
    public void testProcessStudentGPA() {
        Mockito.verify(mockStudent, times(1)).processGPA();


    }

}
