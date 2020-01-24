package org.launchcode.techjobs_oo;

import java.util.Objects;

public abstract class JobField {
    protected final int id;
    protected static int nextId = 1;
    protected String value;

    public JobField() {
        id = nextId;
        nextId++;
    }

    public JobField(String value) {
        this();
        this.value = value;
    }



    //toString
    @Override
    public String toString() {
        return value;
    }

    //HashCode

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    // Getters and Setters:

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
