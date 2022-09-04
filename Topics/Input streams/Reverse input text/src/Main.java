import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here
        StringBuilder sb = new StringBuilder();
        sb.append(reader.readLine());
        System.out.println(sb.reverse());
        reader.close();
    }
}