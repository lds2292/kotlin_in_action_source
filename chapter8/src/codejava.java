import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import kotlin.jvm.functions.Function1;

public class codejava {

    static String readFirstLineFormFile(String path) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }
//    public static void main(String[] args) {
//        CodeKt.processTheAnswer(new Function1<Integer, Integer>() {
//            @Override
//            public Integer invoke(Integer number) {
//                System.out.println(number);
//                return number + 1;
//            }
//        });
//    }
}
