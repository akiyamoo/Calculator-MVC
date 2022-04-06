public class ReversePolishNotation {

    private Model model;
    private MyStack stack;
    private double leftValue;
    private double rightValue;


    public ReversePolishNotation(Model model) {
	this.model = model;
	stack = new MyStack();
	leftValue = 0;
        rightValue = 0;
    }

    public boolean isFunction(String c) {
	if (c.equals("%") || c.equals("sqrt") || c.equals("square") || c.equals("divOneToX")) {
	    return true;
	}
	return false;
    }

    public String getResult(String param) {
	//Which option should I use?
     	MyStack operands = stack;
	//Stack operands = new Stack(); 

	String[] values = param.split(" ");

	for (String value : values) {
	    
	    switch(value) {

		case "+":
		    calculateExpression(EnumOperation.PLUS, operands);
		    break;

		case "-":
		    calculateExpression(EnumOperation.MINUS, operands);
		    break;

		case "/":
		    calculateExpression(EnumOperation.DIV, operands);
		    break;

		case "*":
		    calculateExpression(EnumOperation.MULTIPLE, operands);
		    break;

		case "%":
		    calculateExpression(EnumOperation.PERCENT, operands);
		    break;

		case "divOneToX":
		    calculateExpression(EnumOperation.DIVX, operands);
		    break;

		case "sqrt":
		    calculateExpression(EnumOperation.SQRT, operands);
		    break;

		case "square":
		    calculateExpression(EnumOperation.SQUARE, operands);
		    break;

		default:
		    operands.push(value);
		    break;

	    }
 	}
	return operands.pop(); 
    }

    public void calculateExpression(EnumOperation operation, MyStack operands) {
	switch(operation) {
	    case PLUS:
	        //
	        rightValue = Double.parseDouble(operands.pop());
		leftValue = Double.parseDouble(operands.pop());

		//System.out.println(leftValue + " + " + rightValue);

		rightValue = leftValue + rightValue;		

		operands.push(rightValue + ""); // - Convert to String	
		leftValue = rightValue = 0; 

		break;
		//
	    case MINUS:
	        //
	        rightValue = Double.parseDouble(operands.pop());
		leftValue = Double.parseDouble(operands.pop());

		//System.out.println(leftValue + " - " + rightValue);

		rightValue = leftValue - rightValue;		

		// - Convert to String
		operands.push(rightValue + ""); 	
		leftValue = rightValue = 0; 


		break;
		//
	    case DIV:
	        //
	        rightValue = Double.parseDouble(operands.pop());
		leftValue = Double.parseDouble(operands.pop());

		//System.out.println(leftValue + " / " + rightValue);
		
		rightValue = leftValue / rightValue;		

		// - Convert to String
		operands.push(rightValue + "");
		leftValue = rightValue = 0; 

		break;
		//
	    case MULTIPLE:
	        //
	        rightValue = Double.parseDouble(operands.pop());
		leftValue = Double.parseDouble(operands.pop());
                
		//System.out.println(rightValue + " * " + leftValue);

		rightValue = leftValue * rightValue;		

		// - Convert to String
		operands.push(rightValue + ""); 	
		leftValue = rightValue = 0; 
		
		break;
	        //
	    case PERCENT:
	        //
	        leftValue = Double.parseDouble(operands.pop());
		
		leftValue = leftValue / 100.;

		//System.out.println(leftValue + " % ");

		operands.push(leftValue + ""); // - Convert to String	
		leftValue = 0; 
		
		break;
		//
	    case SQRT:
	        //
		leftValue = Double.parseDouble(operands.pop());
		
		leftValue = Math.sqrt(leftValue);

		//System.out.println(leftValue + " sqrt ");

		// - Convert to String
		operands.push(leftValue + ""); 	
		leftValue = 0; 

		break;
		//
	    case SQUARE:
	        //
		leftValue = Double.parseDouble(operands.pop());
		
		leftValue = leftValue * leftValue;

		//System.out.println(leftValue + " square ");

		// - Convert to String
		operands.push(leftValue + ""); 	
		leftValue = 0; 

		break;
		//
	    case DIVX:
	        //
		leftValue = Double.parseDouble(operands.pop());
		
		leftValue = 1. / leftValue;

		//System.out.println(leftValue + " OneDivToX ");

		// - Convert to String
		operands.push(leftValue + ""); 	
		leftValue = 0; 

		break;
		//
	    default:
		break;	
	}	
    	//return "OK";
    }

    public String convertToNotation(String result) {
	//System.out.println(result);

	String[] arr = result.split(" ");
	result = "";

	for (String i : arr) {
            //System.out.println(x + " test");

	    //if(isFunction(i)) {
	    //	result = result + i + " ";
	    //}
	    
	    if (isOperator(i)) {
	        
		while(!stack.isEmpty() && priorityOperator(i) >= priorityOperator(stack.peek())) {
		    result = result + stack.pop() + " ";
		    //System.out.println(result);
		}

		stack.push(i);

	    }
	    else {
	    	result = result + i + " ";
		//System.out.println(result);
	    }
 
	}

	while (!stack.isEmpty()) {
		result = result + stack.pop() + " ";
	}

	//System.out.println("Reverse notation = " + result);
	
	return getResult(result);
	
    }


    public boolean isOperator(String c) {

	if (c.equals("+") || c.equals("-") || c.equals("/") || c.equals("*")) {
	    return true;
	}

	return false;

    }

    private int priorityOperator(String c) {

	if (isFunction(c)) {
	    return 1;
	}
	else if (c.equals("+") || c.equals("-")) {
	    return 3;
	}
	else if (c.equals("/") || c.equals("*")) {
	    return 2;
	}
	return -1;
    }

}