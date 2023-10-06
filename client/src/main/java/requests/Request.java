package requests;

import java.io.Serializable;

import Collection.LabWork;

public class Request implements Serializable {
    private String name;
    private String arguments;
    private LabWork labWork;
    public Request(String name, String arguments, LabWork labWork){
        this.name = name;
        this.arguments = arguments;
        this.labWork = labWork;
    }

    public String getCommandName() {
        return name;
    }

    public String getArguments() {
        return arguments;
    }

    public LabWork getLabWork() {
        return labWork;
    }
}
