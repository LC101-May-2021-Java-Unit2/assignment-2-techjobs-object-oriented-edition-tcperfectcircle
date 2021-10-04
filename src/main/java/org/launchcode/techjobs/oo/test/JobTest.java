package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.Employer;
import org.launchcode.techjobs.oo.Job;
import org.launchcode.techjobs.oo.Location;
import org.launchcode.techjobs.oo.PositionType;
import org.launchcode.techjobs.oo.CoreCompetency;
import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1, job2);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester", job1.getName());
        assertEquals("ACME", job1.getEmployer().getValue());
        assertEquals("Desert", job1.getLocation().getValue());
        assertEquals("Quality control", job1.getPositionType().getValue());
        assertEquals("Persistence", job1.getCoreCompetency().getValue());

        assertTrue(job1.getName() instanceof String);
        assertTrue(job1.getEmployer() instanceof Employer);
        assertTrue(job1.getLocation() instanceof Location);
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        char expected = '\n';
        Job newLineJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        char firstChar = newLineJob.toString().charAt(0);
        char lastChar = newLineJob.toString().charAt(newLineJob.toString().length()-1);
        System.out.println(firstChar);
        System.out.println(lastChar);
        assertEquals(firstChar, '\n');
        assertEquals(lastChar, '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String labels = "\nID: " +
                job1.getId() +
                "\n" +
                "Name: " +
                job1.getName() +
                "\n" +
                "Employer: " +
                job1.getEmployer() +
                "\n" +
                "Location: " +
                job1.getLocation() +
                "\n" +
                "Position Type: " +
                job1.getPositionType() +
                "\n" +
                "Core Competency: " +
                job1.getCoreCompetency() +
                "\n";

        assertEquals(labels, job1.toString());
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job job4 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String expected = "";
        expected = "\n" +
                "ID: " +
                job4.getId() +
                "\n" +
                "Name: " +
                "Data not available" +
                "\n" +
                "Employer: " +
                "Data not available" +
                "\n" +
                "Location: " +
                "Data not available" +
                "\n" +
                "Position Type: " +
                "Data not available" +
                "\n" +
                "Core Competency: " +
                "Data not available" +
                "\n";

        assertEquals(expected, job4.toString());
    }

}
