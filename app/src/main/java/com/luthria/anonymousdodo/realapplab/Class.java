package com.luthria.anonymousdodo.realapplab;

/**
 * Created by karan on 2/10/17.
 */

public class Class {
    private double weight;
    private int grade;
    private String name;
    private String letter;
    private String type;
    public Class(){
        weight = 0;
        grade = 0;
        name = "";
    }
    public Class(String name, int grade, double weight){
        this.name = name;
        this.grade = grade;
        this.weight = weight;
    }
    public Class(String name, int grade, double weight, String letter, String type){
        this.name = name;
        this.grade = grade;
        this.weight = weight;
        this.letter = letter;
        this.type = type;
    }
    public double getWeighted(){
        return weight + grade;
    }
    public int getGrade(){
        return grade;
    }
    public String getName(){
        return name;
    }
    public String getLetter(){
        return letter;
    }
    public String getType(){
        return type;
    }

}
