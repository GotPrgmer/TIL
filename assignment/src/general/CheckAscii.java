package assignment.src.general;

import java.io.IOException;
import java.util.Objects;


public class CheckAscii {
    public static void main(String[] args) throws IOException {
        String currentPath = Objects.requireNonNull(CheckAscii.class.getResource("CheckAscii.class")).getPath();
        for(char c:currentPath.toCharArray()){
            if((int) c >127){
                System.exit(1);
            }
        }
        System.exit(0);
    }
}
