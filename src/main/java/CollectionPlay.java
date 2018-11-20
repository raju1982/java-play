import java.util.*;

public class CollectionPlay {

    public static void main(String[] args){
        //Array list
        List<String> data = new ArrayList<String>();
        data.add("one");
        data.add("two");
        data.add("three");
        data.add("four");
        //add lement at specific index
        data.add(2,"five");
        for(String name: data){
            System.out.println(name);
        }
        //remove data or index
        data.remove("five");
        data.remove(2);

        //get element
        System.out.println(data.get(1));

        Iterator dataIterator = data.iterator();
        while(dataIterator.hasNext()){
            System.out.println(dataIterator.next());
        }

        System.out.println(data.size());


        //Hashmap
        Map<String, String> dataMap = new HashMap<String, String>();
        dataMap.put("1", "one");
        dataMap.put("2", "two");
        dataMap.put("3", "three");
        dataMap.put("4", "four");

        for(Map.Entry<String, String> val : dataMap.entrySet()){
            System.out.println("Key : " + val.getKey() + " Value : " + val.getValue());
        }
        System.out.println(dataMap.size());

        System.out.println(dataMap.remove("1"));

        System.out.println(dataMap.get("2"));

        System.out.println(dataMap.containsKey("3"));

        System.out.println(dataMap.containsValue("four"));

        System.out.println(dataMap.toString());

        System.out.println(dataMap.size());

        dataMap.clear();
        System.out.println(dataMap.size());
    }
}


// linklist
// index = 0(n)
// insert & deletion = 0(1)

// array
// index = 0(1)
//insert & deletion = 0(n)


//hashtable
//insertion & lookup =  0(1)
//element are stored in unordered way

//binary search tree
//insertion & lookup = O(logn)
//processing of element in ordered way

//hashmap
//insert, lookup, delete = 0(1)

//collections , Arrays, comparable, comparator, equals, hashcode, toString