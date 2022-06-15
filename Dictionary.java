package com.example.dictionary;
import java.util.ArrayList;
public class Dictionary {
    public static ArrayList<Word> listDictionary = new ArrayList<Word>();

    public ArrayList<Word> getList() {
        return listDictionary;
    }

    public void setList(ArrayList<Word> l) {
        Dictionary.listDictionary = l;
    }
}
