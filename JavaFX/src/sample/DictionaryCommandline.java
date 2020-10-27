package sample;
import java.io.IOException;

public class DictionaryCommandline {
    DictionaryManagement dictionaryManagement = new DictionaryManagement();

    public void showAllWords() {
        System.out.println("NO  | English           | Vietnamese");
        for(int i = 0; i < dictionaryManagement.dictionary.words.size(); i++){
            System.out.printf("%-4d| %-18s| %s\n", i + 1
                    ,dictionaryManagement.dictionary.words.get(i).word_target
                    , dictionaryManagement.dictionary.words.get(i).word_explain);
        }
    }



    public void dictionaryBasic() {
        dictionaryManagement.insertFromCommandline();
        showAllWords();
    }

    public void dictionaryAdvanced() throws IOException {
        dictionaryManagement.insertFromFile();
        showAllWords();
        
        
    }
}
