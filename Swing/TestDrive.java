import java.io.*;

class TestDrive {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = (br.readLine()).toUpperCase() + '$';
        String s = "" , ls = "";
        char ch;
        for(int i = 0 ; i < str.length() - 1; i++) {
            s = s + str.charAt(i);
            if(str.charAt(i + 1) != str.charAt(i) + 1) {
                if(s.length() > ls.length()) {
                    ls = s;
                }
                s = "";
            }
        }
        System.out.print(ls);
    }
}