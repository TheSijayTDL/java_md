package datastr;

import java.io.BufferedReader;
import java.io.FileReader;

public class MathExpressionTree<T> {
	private Node<T> root;

	private class Node<T> {
	    private T value;
	    private Node<T> left, right;
	      
	    public Node(T value) {
	        this.value = value;
	        this.left = null;
	        this.right = null;
	    }
	    
	    public T getValue() {
	    	return value;
	    }
	    
	    public Node<T> getRightChild() {
	        return this.right;
	    }
	    
	    public Node<T> getLeftChild() {
	        return this.left;
	    }
	    
	    public void setLeftChild(T value) {
	        if (value != null) {
	            this.left = new Node<T>(value);
	        } else {
	            this.left = null;
	        }
	    }

	    public void setLeftChild(Node<T> node) {
	        if (node != null) {
	            this.left = node;
	        } else {
	            this.left = null;
	        }
	    }
	    
	    public void setRightChild(T value) {
	        if (value != null) {
	            this.right = new Node<T>(value);
	        } else {
	            this.right = null;
	        }
	    }

	    public void setRightChild(Node<T> node) {
	        if (node != null) {
	            this.right = node;
	        } else {
	            this.right = null;
	        }
	    }
	}

	public MathExpressionTree(String expression) throws Exception {
	    root = buildTree(expression);
	}

	private boolean isOperator(char c) {
	    return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '√';
	}

	private int precedence(char c) {
	    if (c == '+' || c == '-') {
	        return 1;
	    } 
	    else if (c == '*' || c == '/') {
	        return 2;
	    } 
	    else if (c == '^' || c == '√') {
	        return 3;
	    } else {
	        return 0;
	    }
	}

	private Node<T> buildTree(String expression) throws Exception {
	    MyStack<Node<T>> valueStack = new MyStack<>();
	    MyStack<Character> operatorStack = new MyStack<>();
	    
	    for (int i = 0;  i < expression.length(); i++) {
	        char current = expression.charAt(i);
	        
	        if (Character.isDigit(current)) {
	            double num = 0;
	            // https://stackoverflow.com/questions/2627371/java-charat-convert-to-int
	            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
	                num = num * 10 + (expression.charAt(i) - '0');
	                i++;
	            }
	            i--;
	            valueStack.push(new Node(num));
	        } 
	        else if (isOperator(current)) {
	            while (!operatorStack.isEmpty() && precedence(operatorStack.top()) >= precedence(current)) {
	                Node<T> op = new Node(operatorStack.pop());
	                op.setRightChild(valueStack.pop());
	                op.setLeftChild(valueStack.pop());
	                valueStack.push(op);
	            }
	            operatorStack.push(current);
	        } 
	        else if (current == '(') {
	            operatorStack.push(current);
	        } 
	        else if (current == ')') {
	            while (operatorStack.top() != '(') {
	                Node<T> op = new Node(operatorStack.pop());
	                op.setRightChild(valueStack.pop());
	                op.setLeftChild(valueStack.pop());
	                valueStack.push(op);
	            }
	            operatorStack.pop();
	        }
	    }
	    while (!operatorStack.isEmpty()) {
	        Node<T> op = new Node(operatorStack.pop());
            op.setRightChild(valueStack.pop());
            op.setLeftChild(valueStack.pop());
	        valueStack.push(op);
	    }
	    return valueStack.pop();
	}
	
	private double evaluate(Node<T> node) {
	    if (node == null) {
	        return 0;
	    }
	    
	    if (node.left == null && node.right == null) {
	        return Double.parseDouble(node.value.toString());
	    }
	    
	    double leftValue = evaluate(node.left);
	    double rightValue = evaluate(node.right);
	    
	    switch((char)node.value) {
	        case '+': 
	        	return leftValue + rightValue;
	        case '-': 
	        	return leftValue - rightValue;
	        case '*': 
	        	return leftValue * rightValue;
	        case '/': 
	        	return leftValue / rightValue;
	        case '^': 
	        	return Math.pow(leftValue, rightValue);
	        case '√': 
	        	return Math.sqrt(rightValue);
	        default: 
	        	return 0;
	    }
	}

	public double evaluate() {
	    return evaluate(root);
	}
	
	public void printTreeWithText() throws Exception {
		this.printTreeWithText(this.root);
	}

	private void printTreeWithText(Node<T> temp) throws Exception {
		//if (!isEmpty()) {
			if (temp != null) {
				if (temp.getValue() != null) {
					System.out.print("Parent: " + temp.getValue());
				}
				if (temp.getLeftChild() != null) {
					System.out.print(" Left: " + temp.getLeftChild().getValue());
				}
				if (temp.getRightChild() != null) {
					System.out.print(" Right: " + temp.getRightChild().getValue() + "\n");
				}
				System.out.print("\n");
				if (temp.getLeftChild() != null) {
					printTreeWithText(temp.getLeftChild());
				}
				if (temp.getRightChild() != null) {
					printTreeWithText(temp.getRightChild());
				}
			}
		//}
	}
	
}