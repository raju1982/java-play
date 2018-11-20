package corejava;

import java.util.Arrays;
/**
 * Created by rkandpal on 9/14/17.
 */
public class StringPlay {

    public static void main(String[] args){
        String master = "tony stark";
        System.out.println(master.length());
        System.out.println(master.substring(0, 7));
        System.out.println(master.substring(5));
        String new_master = master.concat(" hit hard.");
        System.out.println(new_master);
        for(char x: master.toCharArray()){
            //System.out.println(x);
        }
        System.out.println(master.charAt(0));
        int x = 'a';
        int y = 'z';
        System.out.println(x);//97
        System.out.println(y);//122
        System.out.println(master.toLowerCase());
        System.out.println(master.toUpperCase());
        System.out.println(master.trim());
        System.out.println(master.indexOf("s"));
        System.out.println(master.indexOf('s'));

        //In the example below we are directly referencing a String literal.
        // This value will be stored in a "String constant pool" – which is inside the Heap memory.
        // If compiler finds a String literal,it checks if it exists in the pool. If it exists, it is reused.
        String copy = "tony stark";
        System.out.println(master == copy);
        System.out.println(master.equalsIgnoreCase(copy));

        //However, if new operator is used to create string object, the new object is created on the heap. There will not be any reuse of values.
        String delta = new String("tony stark");
        String tango = new String("tony stark");
        System.out.println(delta == tango);
        System.out.println(tango.equalsIgnoreCase(tango));

        //replace
        System.out.println(new_master.replace("tony", "baby"));
        System.out.println(new_master.replace('t', 'Z'));
        //replace all
        System.out.println(new_master.replaceAll("\\s", "BB"));
        System.out.println(new_master.replaceAll("\\S", "BB"));


        //StringBuffer
        StringBuffer empty = new StringBuffer();
        StringBuffer iron = new StringBuffer(master);
        iron.substring(1, iron.length());
        iron.append(" fly fast");
        System.out.println(iron);
        iron.insert(5, "BRO");
        System.out.println(iron);
        iron.delete(5, 8);
        System.out.println(iron);
        System.out.println(iron.reverse());

        //StringBuilder is not thread safe. So, it performs better in situations where thread safety is not required.
        StringBuilder balls = new StringBuilder();
        StringBuilder ironMan = new StringBuilder(master);
        ironMan.substring(1, ironMan.length());
        ironMan.append(" fly fast");
        System.out.println(ironMan);

        //Tokenizing means splitting a string into several sub strings based on delimiters.
        System.out.println(Arrays.toString(master.split(" ")));
    }

}
