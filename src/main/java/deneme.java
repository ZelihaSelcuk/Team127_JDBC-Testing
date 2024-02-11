import java.util.ArrayList;
import java.util.List;

public class deneme {

    public static void main(String[] args) {


        List<String> oyun = new ArrayList<>();
        oyun.add("a");
        oyun.add("b");
        oyun.add("c");
        oyun.add("d");
        oyun.add("e");

        System.out.println(oyun);
        oyun.set(0, "b");
        System.out.println(oyun);
        System.out.println(oyun.indexOf("c"));
        System.out.println(oyun.contains("d"));



    }
}
