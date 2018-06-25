
/**
 * Stack
 *
 * @author Edgar B
 * @version 1.0.0
 */
public class Stack {
    int x;
    Stack next;
    boolean empty;

    /**
     * Constructors for objects of class Stack
     */
    public Stack() {
        empty = true;
    }
    public Stack(Stack st) {
        x = st.x;
        next = st.next;
        empty = st.empty;
    }

    /**
     * Add a number.
     */
    public void push(int v) {
        if (empty) {
            x = v;
            empty = false;
        } else {
            next = new Stack(this);
            x = v;
        }
    }

    /**
     * Returns the first number.
     */
    public int top() {
        return x;
    }

    /**
     * Returns the first number and erases it.
     */
    public int pop() {
        int p = x;
        x = next.x;
        next = next.next;
        return p;
    }

    public static void main(String[] args) {
        Stack st = new Stack();
        int a = 5;
        System.out.println("Add " + a);
        st.push(a);
        a = 10;
        System.out.println("Add " + a);
        st.push(a);
        a = 15;
        System.out.println("Add " + a);
        st.push(a);
        a = 20;
        System.out.println("Add " + a);
        st.push(a);
        a = 25;
        System.out.println("Add " + a);
        st.push(a);
        System.out.println("El primer número del stack: " + st.top());
        System.out.println("Pop al primer número: " + st.pop());
        System.out.println("Nuevo primer num: " + st.top());
        System.out.println("Pop it again! " + st.pop());
        System.out.println("Nuevo primer num: " + st.top());
    }
}
