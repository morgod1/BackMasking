public class ArrayStack implements BKStack {
    private double[] array;
    private int size;
    private int INITIAL_CAPACITY = 10;

    public ArrayStack() {
        this.array = new double[INITIAL_CAPACITY];
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int count() {
        return size;
    }

    public void push(double d) {
        expandCapacity();
        array[size++] = d;
    }

    public double pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        double poppedValue = array[--size];
        array[size] = 0;
        return poppedValue;
    }

    public double peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return array[size - 1];
    }

    private void expandCapacity() {
        if (size == array.length) {
            int newCapacity = array.length * 2;
            double[] newArray = new double[newCapacity];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
                array = newArray;
            }
        }
    }
}
