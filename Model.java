public class Model {

    private Viewer viewer;
    private ReversePolishNotation reversePolishNotation;

    private String result;
    private String temp;

    private boolean checkComma;

    public Model(Viewer viewer) {
	this.viewer = viewer;
	this.reversePolishNotation = new ReversePolishNotation(this);
	result = "";
	temp = "";
//	System.out.println(this.viewer);
    }


    private String deleteValue(String values) {
    	if (!values.equals("")) {
    	    values = values.substring(0, values.length() - 1);
	    return values;
	}
	return values;
    }


    private String checkCommaAndZero(String value) {
	if (value.substring(value.length() - 2).equals(".0")) {
	    value = temp.substring(0, value.length() - 2);
	    return value;
	}
	return value;
    }


    public void doAction(String message) {
	if (viewer.getcheckBlockButtons()) {
	    viewer.setOpenEnabledButtons();
	}

	switch(message) {
	    //
	    case "One":
		temp = temp + "1";
		break;
	    //
	    case "Two": 
                temp = temp + "2";
		break;
	    //	
	    case "Three": 
                temp = temp + "3";
		break;
	    //		
	    case "Four": 
                temp = temp + "4";
		break;
            //	
	    case "Five": 
                temp = temp + "5";
		break;
	    //	
	    case "Six":
                temp = temp + "6";
		break;
	    //	
	    case "Seven": 
                temp = temp + "7";
		break;
	    //	
	    case "Eight":
                temp = temp + "8";
		break;
	    //	
	    case "Nine": 
                temp = temp + "9";
		break;
	    //	
	    case "Zero":
                temp = temp + "0";
		break;
	    //	
	    case "Plus": 
		if (temp.equals("")) 
		    return;

                result = result + temp + " + ";
		temp = "";

		return;
	    //	
	    case "Minus": 
		if (temp.equals("")) 
		    return;

                result = result + temp + " - ";
		temp = "";

		return;
	    //	
	    case "Div":
		if (temp.equals("")) 
		    return; 

                result = result + temp + " / ";
		temp = "";

		return;
	    //	
	    case "Multiple": 
		if (temp.equals("")) return;

                result = result + temp + " * ";
		temp = "";

		return;
	    //	
	    case "Equal": 	
		//System.out.println(result);

	        result = result + temp;

		if (reversePolishNotation.isOperator(result.charAt(result.length() - 2) + "")) // check Result 
		    return;

		temp = reversePolishNotation.convertToNotation(result);
		temp = checkCommaAndZero(temp);
		result = "";
		viewer.setBlockEnabledButtons();

		break;
	    //	
	    case "Clear":
		temp = "";
		viewer.update("0");
		String[] arr = result.split(" ");
		result = "";
		for (int i = 0; i < arr.length; i++) {
		    result = result + arr[i] + " ";
		}
		viewer.updateExspression(result);

		return;
	    //	
	    case "Clear All":
		temp = "";
		result = "";
		viewer.update("0");              
		viewer.updateExspression(result);		
		return;
	    //	
	    case "Comma":
		if (!checkComma)
		    temp = temp + ".";
		break;
	    //	
	    case "Plus or minus":
		if (!temp.equals("")) {
		    double value = Double.parseDouble(temp);
		    value = value * -1;
		    temp = value + "";
		    temp = checkCommaAndZero(temp);
		    break;
		}
		return;
	    //	
	    case "Delete":
		temp = deleteValue(temp);
		break;
	    //
	    case "Percent":
	    	if (temp.equals("")) return;

                temp = reversePolishNotation.convertToNotation(temp + " %");
		temp = checkCommaAndZero(temp);
		//temp = "";

		break;
	    //
	    case "X div one":
	    	if (temp.equals("")) 
		    return;

                temp = reversePolishNotation.convertToNotation(temp + " divOneToX");
		temp = checkCommaAndZero(temp);

		//temp = "";

		break;
	    //	
	    case "Sqrt":
	    	if (temp.equals("")) 
		    return;

                temp = reversePolishNotation.convertToNotation(temp + " sqrt");
                temp = checkCommaAndZero(temp);

		break;
	    //	
	    case "Square":
	    	if (temp.equals("")) 
		    return;

                temp = reversePolishNotation.convertToNotation(temp + " square");
                temp = checkCommaAndZero(temp);
		
		break;
	    //	
	    default: 
		break;
	}

	if (temp.contains(".")) 
	    checkComma = true;
	else 
	    checkComma = false;

	//System.out.println("Expression = " + result + temp);
	
	viewer.updateExspression(result + temp);
	if (temp.equals("")) 
	    viewer.update("0");
	else
	    viewer.update(temp);
    }

 

}