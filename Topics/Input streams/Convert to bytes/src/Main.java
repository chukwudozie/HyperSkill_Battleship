import java.io.InputStream;

class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        int output = inputStream.read();
        while (output != -1) {
            output = inputStream.read();
            System.out.println(output);
        }
        inputStream.close();
    }
}