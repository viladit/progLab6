package utils;

import Collection.LabWork;

import javax.swing.tree.TreeCellRenderer;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * Класс отвечающий за управление коллекцией
 */
public class CollectionHandler implements Serializable {
    private TreeSet<LabWork> collection;
    private Date initDate;

    public CollectionHandler() {
        collection = new TreeSet<>();
        initDate = new Date();
    }
    /**
     * Добавляет объект класса LabWork в коллекцию
     * @param labWork : Объект класса LabWork
     * @see LabWork
     * @return
     */
    public Boolean addLabWork(LabWork labWork){
        collection.add(labWork);
        return true;
    }
    /**
     * Удаляет объект класса LabWork из коллекции
     * @param labWork : Объект класса LabWork
     * @see LabWork
     * @return
     */
    public Boolean removeLabWork(LabWork labWork){
        collection.remove(labWork);
        return true;
    }

    public LabWork getLabWork(LabWork labWork){
        return labWork;
    }

    public int getSize(){
        return collection.size();
    }

    public Date getInitDate() {
        return initDate;
    }

    public TreeSet<LabWork> getCollection(){
        return collection;
    }

    public void setCollection(TreeSet<LabWork> loadedCollection){
        this.collection = loadedCollection;
    }

    public void clear(){
        collection.clear();
    }

    public int generateNextId(){
        int nextId = 0;
        for(Person person :  collection){
            if(person.getId()>=nextId){
                nextId = person.getId();
            }
        }
        return nextId+1;
    }

    /**
     * Загружает коллецию из json
     * @see FileManager#readFromFile()
     */
    public void loadCollection(){
        FileManager fileManager = new FileManager();
        Person[] persons;
        try{
            persons = fileManager.readFromFile();
            for (Person person : persons) {
                addPerson(person);
            }
        } catch (IOException e) {
            IOHandler.println("Ошибка при чтении файла: " + e.getMessage());
        }

    }
    /**
     *Выводит все объекты в коллекции в строковом представлении
     */
    public void printPersonList(){
        for (Person person : collection){
            IOHandler.println("id: " + person.getId());
            IOHandler.println("name: " + person.getName());
            IOHandler.println("coordinates: X:" + person.getCoordinates().getX() +" Y:"+ person.getCoordinates().getY());
            IOHandler.println("creation_date: " + person.getCreationDate());
            IOHandler.println("height: " + person.getHeight());
            IOHandler.println("birthday: " + person.getBirthday());
            IOHandler.println("eye_color: " + person.getEyeColor());
            IOHandler.println("hair_color: " + person.getHairColor());
            IOHandler.println("location: X:" + person.getLocation().getX() + " Y:"+person.getLocation().getY()+ " Z:"+person.getLocation().getZ() + " name:" + person.getLocation().getName());
            IOHandler.println("------------------------------------------");
        }
    }
    /**
     *Выводит объект из коллекции в строковом представлении
     *@param person: Объект класса Person
     *@see Person
     */
    public void printPerson(Person person){
        IOHandler.println("id: " + person.getId());
        IOHandler.println("name: " + person.getName());
        IOHandler.println("coordinates: X:" + person.getCoordinates().getX() +" Y:"+ person.getCoordinates().getY());
        IOHandler.println("creation_date: " + person.getCreationDate());
        IOHandler.println("height: " + person.getHeight());
        IOHandler.println("birthday: " + person.getBirthday());
        IOHandler.println("eye_color: " + person.getEyeColor());
        IOHandler.println("hair_color: " + person.getHairColor());
        IOHandler.println("location: X:" + person.getLocation().getX() + " Y:"+person.getLocation().getY()+ " Z:"+person.getLocation().getZ() + " name:" + person.getLocation().getName());
        IOHandler.println("------------------------------------------");
    }
}
