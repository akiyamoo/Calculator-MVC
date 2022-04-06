public class MyStack {

    private String[] stck;
    private int top;

    public MyStack() {
	top = -1;
	stck = new String[20];
    }

    public String pop() {
	String temp = stck[top];
	top = top - 1;
	return temp;	
    }

    public void push(String entity) {
	top = top + 1;
	stck[top] = entity;	
    }

    public String peek() {
     	return stck[top];
    }

    public boolean isEmpty() {
     	if (top > -1) return false;
	return true;
    }

}