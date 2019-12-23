import java.io.IOException;
import java.util.Scanner;

public class morsecodetranslator{

    public static String os = System.getProperty("os.name").toLowerCase();

    public static void ehcodes(String[] code) {
        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", 
        "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..",
        ".----", "..---", "...--","....-", ".....", " -....", "--...", "---..", "----.", "-----", 
        ".-.-.-", "--..--", "---...", "..--..", ".----.", "-....-", "-..-.", "-.--.", "-.--.-", ".-..-.", ".-...", "-.-.--", "-.-.-.", "-..-."};

        String[] a = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "k", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
        "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".", ",", ":", "?", "'", "-", "/", "(", ")", "\"", "&", "!", ";", "/"};

        String b = "";
        String str = "";

        for(int x=0; x< code.length; x++){
            String c = "";
            b = code[x];
            for (int i = 0; i < codes.length; i++){
                c = codes[i];

                if (c.equals(b)){
                    str += a[i];
                    break;
                }else if (b.equals("/")){
                    str+= " ";
                    break;
                }
            }
              
        }
        System.out.println("Output: "+str);
    }

    public static void console_clear() {
        try {
            if (oswindows()){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }else if(oslinux()){
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        console_clear();

        Scanner input = new Scanner(System.in);
        System.out.print("Enter Morse Code: ");
        String stragrs = input.nextLine();

        String[] argstr = stragrs.split(" ");
        ehcodes(argstr);
    }

    public static boolean oswindows(){return os.contains("windwos") | os.contains("win");}
    public static boolean oslinux(){return os.contains("linux") | os.contains("unix");}
}
