package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private final int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Location getLocation() {
        return location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }


    public String toString(){

        JobField[] fields = new JobField[4]; //ID, Name, Employer, Location, Type, Comp

        fields[0] = getEmployer();
        fields[1] = getLocation();
        fields[2] = getPositionType();
        fields[3] = getCoreCompetency();

        String[] finalStrings = new String[4];

        int totalMissing = 0;

        for(int i = 0; i < fields.length; i++)
        {
            if(fields[i] == null)
            {
                finalStrings[i] = "Data not available";
                totalMissing += 1;
            } else {
                finalStrings[i] = fields[i].toString();
                if(finalStrings[i].isEmpty())
                {
                    finalStrings[i] = "Data not available";
                }
            }
        }

        String result = "";

        if(totalMissing == 4 && getName() == null){
            result = "\nOOPS! This job does not seem to exist.\n";
        } else {
            result = "\nID:  " + getId() + "\n" +
                "Name: " + getName() + "\n" +
                "Employer: " + finalStrings[0] + "\n" +
                "Location: " + finalStrings[1] + "\n" +
                "Position Type: " + finalStrings[2] + "\n" +
                "Core Competency: " + finalStrings[3] + "\n";
        }

        return result;
    }

}
