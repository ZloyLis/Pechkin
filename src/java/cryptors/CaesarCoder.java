package cryptors;

import services_file.Algorithms;
import services_file.alphabets.SelectLanguage;

import java.io.*;

public class CaesarCoder {

    private static int key = 0;
    private static String pathReadFile = "";
    private static String pathWriteFile = "";
    private static boolean isRegister = true;
    private static Algorithms type = Algorithms.CAESAR_CODER;

    private static void caesarCoder(Algorithms type, int key, String pathReadFile, String pathWriteFile, boolean isRegister){

        int newIndex = 0;
        int index = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathReadFile));
             FileWriter fileWriter = new FileWriter(pathWriteFile)){

            while (bufferedReader.ready()){

                char c = (char) bufferedReader.read();
                if(c == '\r'){
                    continue;
                } else {
                    for (int i = 0; i < SelectLanguage.getAlphabetLanguage().length; i++) {
                        if(c == SelectLanguage.getAlphabetLanguage()[i]){
                            index = i;
                            break;
                        }
                    }
                }

                if(type == Algorithms.CAESAR_CODER){
                    newIndex = (SelectLanguage.getAlphabetLanguage().length + key + index) % SelectLanguage.getAlphabetLanguage().length;
                } else  if( type == Algorithms.CAESAR_DECODER){
                    newIndex = (SelectLanguage.getAlphabetLanguage().length - key + index) % SelectLanguage.getAlphabetLanguage().length;
                }

                String str = String.valueOf(SelectLanguage.getAlphabetLanguage()[newIndex]);
                if(!isRegister){
                    fileWriter.append(str.toLowerCase());
                } else {
                    fileWriter.append(str);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    //** Service area **//
    public CaesarCoder() {
    }

    //****//

    public static void setKey(int key) {
        CaesarCoder.key = key;
    }

    public static void setType(Algorithms type) {
        CaesarCoder.type = type;
    }

    public static void setPathReadFile(String pathReadFile) {
        CaesarCoder.pathReadFile = pathReadFile;
    }

    public static void setPathWriteFile(String pathWriteFile) {
        CaesarCoder.pathWriteFile = pathWriteFile;
    }

    public static void setIsRegister(boolean isRegister) {
        CaesarCoder.isRegister = isRegister;
    }

    //****//

    public static Algorithms getType() {
        return type;
    }

    public static int getKey() {
        return key;
    }

    public static String getPathReadFile() {
        return pathReadFile;
    }

    public static String getPathWriteFile() {
        return pathWriteFile;
    }

    public static boolean isIsRegister() {
        return isRegister;
    }

    //** END **//

}
