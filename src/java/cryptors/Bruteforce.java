package cryptors;

import services_file.Algorithms;
import services_file.alphabets.SelectLanguage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

/*[+\S]{12,}*/
public class Bruteforce {

    private static String pathReadFile;
    private static String pathWriteFile;
    private static String pathControlFile;
    private static boolean isRegister;
    private static Algorithms type = Algorithms.BRUTEFORCE;
    private static char []alphabet;

    private static void bruteForce(){

        int index = 0;
        int newIndex = 0;

        for (int bKey = 0; bKey < SelectLanguage.getAlphabetLanguage().length; bKey++) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/resources/files/Encrypt"));
                 FileWriter fileWriter = new FileWriter("src/resources/files/Decrypt", true)) {

                while (bufferedReader.ready()) {
                    char c = (char) bufferedReader.read();
                    if (c == '\r') {
                        continue;
                    } else {
                        for (int i = 0; i < SelectLanguage.getAlphabetLanguage().length; i++) {
                            if (c == SelectLanguage.getAlphabetLanguage()[i]) {
                                index = i;
                                break;
                            }
                        }
                    }

                    newIndex = (SelectLanguage.getAlphabetLanguage().length - bKey + index) % SelectLanguage.getAlphabetLanguage().length;
                    String str = String.valueOf(SelectLanguage.getAlphabetLanguage()[newIndex]);
                    boolean pattern1 = Pattern.matches("[+\\n\\t\\f\\r]{3,}", str);
                    boolean pattern = Pattern.matches("[^\\w]{3,}", str);
                    if (!pattern || ! pattern1) {
                        fileWriter.append(str.toLowerCase());
                    } else {
                        break;
                    }


                }
                fileWriter.append('\n').append(String.valueOf(SelectLanguage.getAlphabetLanguage()[bKey])).append(") ");
            } catch(IOException e){
                e.printStackTrace();
            }
        }

    }


    public static char[] getAlphabet() {
        return alphabet;
    }


    public static void main(String[] args) {
        SelectLanguage.setAlphabetLanguage();
        //System.out.println(Arrays.toString(SelectLanguage.getAlphabetLanguage()));
        bruteForce();
    }

    public static void setPathReadFile(String pathReadFile) {
        Bruteforce.pathReadFile = pathReadFile;
    }

    public static void setPathWriteFile(String pathWriteFile) {
        Bruteforce.pathWriteFile = pathWriteFile;
    }

    public static void setPathControlFile(String pathControlFile) {
        Bruteforce.pathControlFile = pathControlFile;
    }

    public static void setIsRegister(boolean isRegister) {
        Bruteforce.isRegister = isRegister;
    }

    public static void setType(Algorithms type) {
        Bruteforce.type = type;
    }

    public static void setAlphabet(char[] alphabet) {
        Bruteforce.alphabet = alphabet;
    }
}
