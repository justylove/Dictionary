package sample;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class DictionaryManagement {
    static Dictionary dictionary = new Dictionary();


    public static void insertFromCommandline() {
        Scanner s = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        int n = s.nextInt();
        for(int i = 0; i < n; i++) {
            Word tu_moi = new Word();
            tu_moi.word_target = sc.nextLine();
            tu_moi.word_explain = sc.nextLine();
            dictionary.words.add(tu_moi);
        }
    }

    public static void insertFromFile() {
        File file = new File("C:\\Users\\Justilove\\Java\\JavaFX\\src\\sample\\dictionaries.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                Word tu_moi = new Word();
                String tu = scanner.nextLine();
                String[] s = tu.split("\t",2);
                tu_moi.word_target = s[0];
                tu_moi.word_explain = s[1];
                dictionary.words.add(tu_moi);
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    public String dictionaryLookup(String w) {
        for (int i = 0; i < dictionary.words.size(); ++i) {
            if (w.equalsIgnoreCase(dictionary.words.get(i).word_target)) {
                return dictionary.words.get(i).word_explain;
            }
        }
        return "Từ điển chưa cập nhật!";
    }



    public static void dictionaryExportToFile() {
        try {
            Writer writer = new FileWriter("C:\\Users\\Justilove\\Java\\JavaFX\\src\\sample\\output.txt");
            for (int i = 0; i < dictionary.words.size(); i++) {
                writer.write(dictionary.words.get(i).word_target + "\t");
                writer.write(dictionary.words.get(i).word_explain + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void InsertToFile(String x, String y) {
        try {

            Writer writer1 = new FileWriter("C:\\Users\\Justilove\\Java\\JavaFX\\src\\sample\\dictionaries.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer1);

            bufferedWriter.write(x + "\t" + y + "\n");

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeLineFromFile(String file, String lineToRemove) {

        try {

            File inFile = new File(file);

            if (!inFile.isFile()) {
                System.out.println("Parameter is not an existing file");
                return;
            }

            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

            BufferedReader br = new BufferedReader(new FileReader(file));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line = null;
            while ((line = br.readLine()) != null) {

                if (!line.trim().equals(lineToRemove)) {

                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();
            if (!inFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }

            if (!tempFile.renameTo(inFile))
                System.out.println("Could not rename file");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void editLineFromFile(String file, String lineToRemove) {

        try {

            File inFile = new File(file);

            if (!inFile.isFile()) {
                System.out.println("Parameter is not an existing file");
                return;
            }

            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

            BufferedReader br = new BufferedReader(new FileReader(file));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line = null;
            while ((line = br.readLine()) != null) {

                if (!line.trim().contains(lineToRemove)) {

                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();
            if (!inFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }

            if (!tempFile.renameTo(inFile))
                System.out.println("Could not rename file");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
