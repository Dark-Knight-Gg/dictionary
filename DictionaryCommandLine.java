package com.example.dictionary;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class DictionaryCommandLine extends Dictionary{
    static DictionaryManagement management = new DictionaryManagement();
    static DictionaryCommandLine commandline = new DictionaryCommandLine();

    public void showAllWords() {
        System.out.format("%-3s\t%s\t%s\n", "No", "|English", "|Vietnamese");

        for (int i = 0; i < Dictionary.listDictionary.size(); i++) {
            System.out.format("%-3s\t%-20s\t%s\n", i+1,
                    "|" + Dictionary.listDictionary.get(i).getWord_target(),
                    "|" + Dictionary.listDictionary.get(i).getWord_explain());
        }
    }

    public void dictionaryBasic() {
        DictionaryManagement mnm = new DictionaryManagement();
        DictionaryCommandLine cmd = new DictionaryCommandLine();
        mnm.insertFromCommandline();
        commandline.showAllWords();
    }

    public void dictionaryAdvanced() throws IOException {
        int op = 1;
        //management.insertFromFile();
        Scanner a = new Scanner(System.in);
        do {
            System.out.println("1. Tra từ  |  2. Hiển thị tất cả các từ  |  3. Thêm từ  |  4. Sửa từ  |  5. Xóa từ  |  6. Xuất ra file");
            System.out.println("Nhập chức năng (theo số): ");
            try{
                op = a.nextInt();
            }
            catch (InputMismatchException e) {
            }
            a.nextLine();
            switch (op) {
                case 1: {
                    System.out.println("Nhập từ muốn tra: ");
                    String t = a.nextLine();
                    commandline.dictionarySearcher(t);
                    System.out.println("Nhấn phím enter để tiếp tục ");
                    continue;
                }
                case 2: {
                    commandline.showAllWords();
                    System.out.println("Nhấn phím enter để tiếp tục ");
                    continue;
                }
                case 3: {
                    System.out.println("Nhập từ muốn thêm: ");
                    String t = a.nextLine();
                    System.out.println("Nhập nghĩa của từ muốn thêm: ");
                    String e = a.nextLine();
                    management.addNewWord(t,e);
                    commandline.showAllWords();
                    System.out.println("Nhấn phím enter để tiếp tục ");
                    continue;
                }

                case 4: {
                    System.out.println("Nhập từ muốn sửa: ");
                    String word = a.nextLine();
                    management.editWord(word);
                    System.out.print("Nhấn phím enter để tiếp tục");
                    continue;
                }

                case 5: {
                    System.out.println("Nhập từ muốn xóa: ");
                    String word = a.nextLine();
                    management.removeWord(word);
                    commandline.showAllWords();
                    System.out.print("Nhấn phím enter để tiếp tục");
                    continue;
                }

                case 6: {
                    management.dictionaryExportToFile();
                    System.out.println("Xuất ra file thành công!");
                    System.out.println("Nhấn phím enter để tiếp tục");
                    continue;
                }
                default: {
                    System.out.println("Yêu cầu không hợp lệ!");
                    System.out.print("Nhấn phím enter để tiếp tục");
                    a.nextLine();
                    continue;
                }
            }
        }while (op != 0);
    }

    public void dictionarySearcher (String t) {
        System.out.printf("%-30s|%s\n", "English", "Tiếng Việt");
        boolean c = false;
        for (int i = 0 ; i < listDictionary.size(); ++i) {
            Word tu = listDictionary.get(i);
            if (tu.getWord_target().startsWith(t)) {
                System.out.printf("%-30s|%s\n", tu.getWord_target(), tu.getWord_explain());
                c = true;
            }
        }
        if (!c) {
            System.out.println("Từ bạn muốn tra không có trong cơ sở dữ liệu!");
        }
    }
}
