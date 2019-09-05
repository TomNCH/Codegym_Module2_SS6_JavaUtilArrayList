import java.util.Arrays;

public class MyList<Integer> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList(){
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity){
        elements = new Object[capacity];
    }

    public void ensureCapa(){
        if (size >= elements.length) {
            int newSize = elements.length * 2;
            elements = Arrays.copyOf(elements, newSize);
        }
    }

    public void checkIndex(int index){
        if (index < 0 || index > this.size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + this.size );
        }
    }

    public void add(int index, int element){
        ensureCapa();
        checkIndex(index);
        for (int i = size-1; i >= index; i--){
            elements[i+1] = elements[i];
            elements[index] = element;
        }
        size++;
    }

    public int remove(int index){
        checkIndex(index);
        int temp = (int) elements[index];

        for (int i = index; i < size-1; i++){
            elements[i] = elements[i+1];
        }
        elements[size-1] = null;
        size--;
        return temp;
    }

    public int getSize(){
        return this.size;
    }

    public boolean contains(int element){
        for (int i = 0; i < size; i++){
            if (element == (int) elements[i]){
                return true;
            }
        }
        return false;
    }

    public int indexOf(int element){
        for (int i = 0; i < size; i++){
            if (element == (int) elements[i]){
                return i;
            }
        }
        return -1;
    }

    public boolean add(int element){
        ensureCapa();
        elements[size] = element;
        size++;
        return true;
    }

    public int get(int index){
        checkIndex(index);
        return (int) elements[index];
    }

    public void clear(){
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
}
