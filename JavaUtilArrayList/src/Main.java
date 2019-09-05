public class Main {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();

        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);

        myList.remove(2);

        for (int i = 0; i < myList.getSize(); i++){
            System.out.println(myList.get(i));
        }
    }
}
