import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here
        String text = reader.readLine().trim();
        String []words = text.split("\\s+");
        if (text.isEmpty() || text == null) {
            System.out.println("0");
        } else {
            System.out.println(words.length);
        }
        reader.close();
    }
}