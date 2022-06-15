package com.example.dictionary;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.util.Scanner;
public class DisplayFxlmController implements Initializable{
    DictionaryCommandLine commandline = new DictionaryCommandLine();
    DictionaryManagement management = new DictionaryManagement();
    private Label label;
    @FXML
    private TextField a;
    @FXML
    private TextArea b;
    @FXML
    private MenuButton c;
    @FXML
    private MenuItem d;
    @FXML
    private MenuItem e;
    @FXML
    private MenuItem f;
    @FXML
    private MenuItem g;
    @FXML
    private Button h;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    private void deSearch(ActionEvent event) {
        //management.insertFromFile();
        Scanner sc = new Scanner(System.in);
        String word = a.getText();
        int index = -1;

        for (int i = 0; i < Dictionary.listDictionary.size(); i++) {
            if(Dictionary.listDictionary.get(i).getWord_target().toLowerCase().equals(word.toLowerCase())) {
                index = i;
                break;
            }
        }

        if(index != -1) {
            b.setText(Dictionary.listDictionary.get(index).getWord_explain());
        }else {
            b.setText("Từ bạn tra không có trong từ điển");
        }

    }
    @FXML
    private void deAdd(ActionEvent event) throws IOException {
        // management.insertFromFile();
        Scanner sc = new Scanner(System.in);
        String w = a.getText();
        String e = b.getText();
        management.addNewWord(w, e);
        management.dictionaryExportToFile();

    }

    @FXML
    private void deFix(ActionEvent event) {
    }

    @FXML
    private void deRemove(ActionEvent event) throws IOException {
        String word = a.getText();
        management.removeWord(word);
        management.dictionaryExportToFile();
        b.setText("Xóa từ thành công");
    }


}
