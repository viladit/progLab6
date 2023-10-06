package collection;

import java.io.Serializable;
import java.util.Date;

public class LabWork implements Serializable {
    private long id; //Value must be greater than 0, Value must be unique, Value must be generated automatically
    private String name; //Field can't be null, String can't be empty
    private Coordinates coordinates; //Field can't be null
    private Date creationDate; //Field can't be null, Value must be generated automatically
    private long minimalPoint; //Value must be greater than 0
    private Difficulty difficulty; //Field can't be null
    private Discipline discipline; //Field can be null

    public LabWork(int id, String name, Coordinates coordinates, Date creationDate, Long minimalPoint,
                  Difficulty difficulty, Discipline discipline) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.minimalPoint = minimalPoint;
        this.difficulty = difficulty;
        this.discipline = discipline;
    }

    public long getId () {
        return id;
    }
    public void setId (Long id){
        this.id = id;
    }
    public String getName () {
        return name;
    }
    public void setName (String name){
        this.name = name;
    }
    public Coordinates getCoordinates () {
        return coordinates;
    }
    public void setCoordinates (Coordinates coordinates){
        this.coordinates = coordinates;
    }
    public Date getCreationDate () {
        return creationDate;
    }
    public void setCreationDate (Date creationDate){
        this.creationDate = creationDate;
    }
    public long getMinimalPoint () {
        return minimalPoint;
    }
    public void setMinimalPoint (Long minimalPoint){
        this.minimalPoint = minimalPoint;
    }
    public Difficulty getDifficulty () {
        return difficulty;
    }
    public void setDifficulty (Difficulty difficulty){
        this.difficulty = difficulty;
    }
    public Discipline getDiscipline () {
        return discipline;
    }
    public void setDiscipline (Discipline discipline){
        this.discipline = discipline;
    }
}
