import java.io.File;
import java.util.Objects;

class Siblings {

    public static void main(String[] args) {
       File f1 = new File("dir/file1.txt");
       File f2 = new File("dir/file2.txt");
        System.out.println(areSiblings(f1, f2));
    }

    public static boolean areSiblings(File f1, File f2) {
        // implement me
        return Objects.equals(f1.getParent(),f2.getParent());
    }
}