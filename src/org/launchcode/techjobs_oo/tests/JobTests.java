package org.launchcode.techjobs_oo.tests;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTests {

    static Job testJob1, testJob2, testJob3, testJob4, testJob5;
    static Employer testEmployer1;
    static Location testLocation1;
    static PositionType testType1;
    static CoreCompetency testComp1;

    @BeforeClass
    public static void initialize(){
        testEmployer1 = new Employer("SuprTek Technology");
        testLocation1 = new Location("Saint Louis");
        testType1 = new PositionType("Quality Assurance Analyst");
        testComp1 = new CoreCompetency("Non-coding");

        testJob1 = new Job();
        testJob2 = new Job();
        testJob3 = new Job("Quality Assurance Analyst", testEmployer1, testLocation1, testType1, testComp1);
        testJob4 = new Job("Quality Assurance Analyst", testEmployer1, testLocation1, testType1, testComp1);
        testJob5 = new Job("Associate Managed Systems Engineer", null, testLocation1, testType1, testComp1);
    }

    @Test
    public void testSettingJobId(){
        assertFalse(testJob1.equals(testJob2));
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assertTrue("Job does not have correct name", testJob3.getName().equals("Quality Assurance Analyst")); //Test name
        assertTrue("Job does not have correct employer", testJob3.getEmployer().equals(testEmployer1)); //Test employer
        assertTrue("Job does not have correct location", testJob3.getLocation().equals(testLocation1)); //Test Location
        assertTrue("Job does not have correct type", testJob3.getPositionType().equals(testType1)); //Test type
        assertTrue("Job does not have correct comp", testJob3.getCoreCompetency().equals(testComp1)); //Test comp
    }

    @Test
    public void testJobForEquality(){
        assertFalse(testJob3.equals(testJob4));
    }

    @Test
    public void testToStringFullFields(){
        String expected = "\nID:  3\n" +
                            "Name: Quality Assurance Analyst\n" +
                            "Employer: SuprTek Technology\n" +
                            "Location: Saint Louis\n" +
                            "Position Type: Quality Assurance Analyst\n" +
                            "Core Competency: Non-coding\n";
        assertEquals(expected, testJob3.toString());
    }

    @Test
    public void testToStringMissingFields(){
        String expected = "\nID:  5\n" +
                "Name: Associate Managed Systems Engineer\n" +
                "Employer: Data not available\n" +
                "Location: Saint Louis\n" +
                "Position Type: Quality Assurance Analyst\n" +
                "Core Competency: Non-coding\n";
        assertTrue(testJob5.toString().equals(expected));
    }

    @Test
    public void testToStringNoFields(){
        String expected = "\nOOPS! This job does not seem to exist.\n";
        assertTrue(testJob1.toString().equals(expected));
    }




}
