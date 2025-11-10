package assignment.src.general;

import java.io.File;


public class InstallationError {
    public static void main(String[] args){
        File file = new File(".");
        String abPath = file.getAbsolutePath();
        for (int i=0;i<abPath.length();i++){
            if(Integer.parseInt((String.valueOf(abPath.charAt(i))))){

            }
            System.out.println(abPath[i]);

        }
    }
}
