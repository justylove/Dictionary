package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import javax.swing.Action;



public class Controller implements Initializable{
    @FXML
    private TextField input;
    @FXML
    private TextArea output;
    @FXML
    private TextField input1;
    @FXML
    private TextField input2;
    @FXML
    private TextField input3;
    @FXML
    private TextField input4;
    @FXML
    private TextField input5;
    @FXML
    private TextField input6;
    @FXML
    ListView<String> listView = new ListView();
    
    Word wordsWord = new Word();
    Dictionary lis = new Dictionary();
    DictionaryManagement management = new DictionaryManagement();

    public void searchWords() throws IOException {
        String x = input.getText();
        System.out.println(x);
        DictionaryManagement a = new DictionaryManagement();
        a.insertFromFile();
        a.dictionaryExportToFile();
        output.setText(a.dictionaryLookup(x));
    }

    public void textFieldSearch() throws IOException {
        String x = input.getText();
        System.out.println(x);
        DictionaryManagement a = new DictionaryManagement();
        a.insertFromFile();
        a.dictionaryExportToFile();
        output.setText(a.dictionaryLookup(x));
    }
    
   
    public void addWords(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("addword.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Add Words");
        stage.setScene(new Scene(parent, 600, 400));
        stage.show();
    }

    
    public void wordtarget() throws IOException {
        String x = input1.getText();
        wordsWord.word_target = x;
    }
    public void wordtarget2() throws IOException {
        String x = input3.getText();
        wordsWord.word_target = x;
    }

    public void wordexplain() throws IOException {
        String x = input2.getText();

        wordsWord.word_explain = x;
    }
    public void wordexplain2() throws IOException {
        String x = input4.getText();
        
        wordsWord.word_explain = x;
    }

    public void backdictionary(ActionEvent event) throws IOException {
        wordsWord.word_target = input1.getText();
        wordsWord.word_explain = input2.getText();
        System.out.println(wordsWord.word_target + " " + wordsWord.word_explain);

        DictionaryManagement dictionaryManagement = new DictionaryManagement();
        dictionaryManagement.InsertToFile(wordsWord.word_target, wordsWord.word_explain);
        Parent parent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Dictionarys");
        stage.setScene(new Scene(parent, 600, 400));
        stage.show();
    }

    public void backdictionary1(ActionEvent event) throws IOException {
        wordsWord.word_target = input3.getText();
        wordsWord.word_explain = input4.getText();
        String string = wordsWord.word_target + "\t" + wordsWord.word_explain;
        DictionaryManagement dictionaryManagement = new DictionaryManagement();
        dictionaryManagement.removeLineFromFile("C:\\Users\\Justilove\\Java\\JavaFX\\src\\sample\\dictionaries.txt", string);
        Parent parent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Dictionarys");
        stage.setScene(new Scene(parent, 600, 400));
        stage.show();
    }

    public void delWords(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("delword.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Delete Words");
        stage.setScene(new Scene(parent, 600, 400));
        stage.show();
    }

    public void editWords(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("editword.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Edit Words");
        stage.setScene(new Scene(parent, 600, 400));
        stage.show();
    }

    public void backdictionary2(ActionEvent event) throws IOException {
        wordsWord.word_target = input5.getText();
        wordsWord.word_explain = input6.getText();

        DictionaryManagement dictionaryManagement = new DictionaryManagement();
        dictionaryManagement.editLineFromFile("C:\\Users\\Justilove\\Java\\JavaFX\\src\\sample\\dictionaries.txt",
                wordsWord.word_target);
        dictionaryManagement.InsertToFile(wordsWord.word_target, wordsWord.word_explain);
        Parent parent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Dictionarys");
        stage.setScene(new Scene(parent, 600, 400));
        stage.show();
    }

    
    
    @FXML
    public void autocompelete(KeyEvent keyEvent) {
        this.listView.getItems().clear();
        String s = this.input.getText();
        if(s.trim().equals("")) return;

        for(int i = 0; i < this.management.dictionary.words.size(); ++i) {
            if (((Word)this.management.dictionary.words.get(i)).word_target.startsWith(s)) {
                this.listView.getItems().add(((Word)this.management.dictionary.words.get(i)).word_target);
            }
        }

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
            this.management.insertFromFile();
        //lis.dictionaryManagement.insertFromFile();
            //System.out.println("hoang loz");
    
            for (int i = 0; i < this.management.dictionary.words.size(); ++i) {
                //System.out.println(this.management.dictionary.words.get(i));
                this.listView.getItems().add(((Word) this.management.dictionary.words.get(i)).word_target);
            }
    

    }

    
}
