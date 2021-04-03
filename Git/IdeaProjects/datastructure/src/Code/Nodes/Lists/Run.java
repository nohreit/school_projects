package Code.Nodes.Lists;

public class Run {
//    public static void main(String [] args){
//        execute();
//    }

    public static void execute(){
        LinkedList<Integer> list = new LinkedList<>();

        list.addSorted(61);
        list.addSorted(57);
        list.addSorted(41);
        list.addSorted(100);
        list.addSorted(29);
        list.addSorted(10);
        list.addSorted(37);
        list.addSorted(36);
        list.addSorted(5);
        list.addSorted(-1);
        list.addSorted(-25);


//        println("Number of items: "+list.size());
//        getItems(list);
//        println("The head is "+ list.get(0));
//        println("\nReplaced item: "+ list.replace(25, 0));
//        println("Replaced item: "+list.replace(1, 1));
//        println("\nThe following won't be sorted");
        list.add(19, 0);
        list.add(51, 3);
        list.add(null, 5);
        list.add(13, list.size());

        println("Item "+list.getIndex(19)+ (list.remove(list.getIndex(19)) ? " removed": " not removed"));
        println("Item "+list.getIndex(51)+ (list.remove(list.getIndex(51)) ? " removed": " not removed"));
        println("Item "+list.getIndex(null)+ (list.remove(list.getIndex(null)) ? " removed": " not removed"));
        println("Item "+list.getIndex(13)+ (list.remove(list.getIndex(13))? " removed": " not removed"));
        println("Item "+list.getIndex(-1)+ (list.remove(list.getIndex(-1))? " removed": " not removed"));
        println("Item "+list.getIndex(-25)+ (list.remove(list.getIndex(-25))? " removed": " not removed"));
        println("Item "+list.getIndex(-25)+ (list.remove(list.getIndex(-25))? " removed": " not removed"));
//        println("Index: "+list.getIndex(null));
        getItems(list);

    }

    public static void getItems(LinkedList<Integer> list){
        for(int i = 0; i < list.size(); i++){
            println("Item["+i+"]: " + (list.get(i) == null ? "Invalid index/item": list.get(i)));
        }
    }

    public static void println(Object o){
        System.out.println(o);
    }

    public static void print(Object o){
        System.out.print(o);
    }
}
