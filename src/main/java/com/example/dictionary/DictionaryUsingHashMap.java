package com.example.dictionary;

import java.util.HashMap;

public class DictionaryUsingHashMap {
    private HashMap<String,String>dictionary;
     public  DictionaryUsingHashMap(){
         dictionary = new HashMap<String, String>();
         addListOfWords();
     }
    public  boolean addWord(String word, String meaning){
         dictionary.put(word,meaning);
         return true;

    }
    public String findMeaning(String word){

         if(!dictionary.containsKey(word)){
             return "Given Word not found";

        }
         else return dictionary.get(word);
    }
private void addListOfWords(){
         addWord("evaluative","exercising or involving careful appraisals");
    addWord(" discomfit"," cause to lose one's composure");
    addWord("adulation"," excessive flattery or praise");
    addWord(" binary","something that consists of two parts");
    addWord("digress","to go off on a tangent, leave the main subject");
    addWord("associate's degree","a degree that is given to a student who has " +
            "completed two years of study at a junior college, college");
    addWord("bachelor's degree","a degree that is given to a student by a " +
            "college or university usually after four years of study");
    addWord("campus","the area and buildings around a university, college, school, etc.");
    addWord("credit","money that a bank or business will allow a person to use and then pay back in the future");
    addWord("exam","an annual physical exam");
    addWord("fail","to end without success");
    addWord("graduate","to earn a degree or diploma from a school, college, or university");
    addWord("lecture","a talk or speech given to a group of people to teach them about a particular subject");




}






}
