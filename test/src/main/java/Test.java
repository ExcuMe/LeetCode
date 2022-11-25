

public class Test {


    public static String main(String[] args) {

        int index = args[0].length();
        loop:
        for (int i = 0; i < args[0].length(); i++) {
            char c = args[0].charAt(i);
            for (int j = 1; j < args.length; j++){
               if (args[j].length() <= i || args[j].charAt(i) != c){
                   index = i;
                   break loop;
               }
            }
        }
        if (index <= 0){
            return "";
        }
        return args[0].substring(0, index);
    }
}
