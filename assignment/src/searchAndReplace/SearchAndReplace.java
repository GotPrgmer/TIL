package assignment.src.searchAndReplace;

public class SearchAndReplace {
    public static void main(String[] args){
        System.out.println(searchAndReplace("i ate apples apple today", "apple", "banana"));
    }
    static String searchAndReplace(String sentence, String find, String replace){
        StringBuilder sb = new StringBuilder();
        sb.append(sentence);
        int idx = sb.indexOf(find);
        while(idx!=-1){
            sb.replace(idx,idx+find.length(),replace);
            idx = sb.indexOf(find);
        }
        return sb.toString();
    }
}
