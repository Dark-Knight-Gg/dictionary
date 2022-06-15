package com.example.dictionary;
import java.io.*;
import java.util.Scanner;

public class DictionaryManagement extends Dictionary{
    public void insertFromCommandline() {
        Scanner scan = new Scanner(System.in);
        int solg =0;
        while (solg <= 0) {
            System.out.println("Nhập số lượng từ muốn nhập:");
            solg = scan.nextInt();
        }
        scan.nextLine();
        for (int i = 0; i < solg; i++) {
            System.out.println("Nhập từ Tiếng Anh:");
            String word_target = scan.nextLine();
            System.out.println("Nhập nghĩa của từ:");
            String word_explain = scan.nextLine();
            Word word = new Word(word_target, word_explain);
            Dictionary.listDictionary.add(word);
        }
    }

    public void insertFromFile()   {
        try {
            File file = new File("dictionaries.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String dt = scan.nextLine();
                String[] slt = dt.split("\\t");
                if(slt.length == 2) {
                    Word tu = new Word(slt[0], slt[1]);
                    listDictionary.add(tu);
                }
            }
            scan.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Error!");
        }
    }


    public void dictionaryLookup() {
        System.out.println("Nhập từ muốn tra");
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        int index = -1;

        for (int i = 0; i < Dictionary.listDictionary.size(); i++) {
            if(Dictionary.listDictionary.get(i).getWord_target().toLowerCase().equals(word.toLowerCase())) {
                index = i;
                break;
            }
        }

        if(index != -1) {
            System.out.println("Từ muốn tra có nghĩa là: \n" + Dictionary.listDictionary.get(index).getWord_explain());
        }else {
            System.out.println("Từ bạn tra không có trong từ điển");
        }

    }
    public void addNewWord(String word_target, String word_explain) throws IOException {
        boolean c = true;

        for(Word tu : listDictionary) {
            if(tu.getWord_target().equalsIgnoreCase(word_target)) {
                c = false;
                break;
            }
        }
        if(!c) {
            System.out.println("Từ này đã có trong từ điển");
        }
        else {
            listDictionary.add(new Word(word_target,word_explain));
        }
    }

    public void editWord(String t) {
        boolean c = false;
        for(Word tu : listDictionary) {
            if(tu.getWord_target().equalsIgnoreCase(t)) {
                c = true;
                listDictionary.remove(tu);
                break;
            }
        }
        if(c) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Nhập từ mơí: ");
            t = scan.nextLine();
            System.out.println("Nhập nghĩa mơí: ");
            String mean = scan.nextLine();
            System.out.println("Sửa thành công");
            listDictionary.add(new Word(t,mean));
        }
        else {
            System.out.println("Không tìm thấy từ bạn muốn sửa");
        }
    }

    public void removeWord(String t) {
        for(Word tu : listDictionary) {
            if(tu.getWord_target().equalsIgnoreCase(t)) {
                listDictionary.remove(tu);
                break;
            }
        }
    }

    public void dictionaryExportToFile() throws IOException {

        PrintWriter f = new PrintWriter(new FileWriter("dictionaries.txt", false));
        for (Word tu : listDictionary) {
            f.write(String.format("%s\t%s\n", tu.getWord_target(), tu.getWord_explain()));
        }
        f.close();
    }
}
