package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import datastr.MathExpressionTree;

public class MainService {

	public static void main(String[] args) {
		try {
			String expr1 = "20 + 2^2";
			String expr2 = "(2+2)*2";
			String expr3 = "(2+4)*3-8";
			String expr4 = "2+3*5+4/2";
			String expr5 = "13+7";

		    MathExpressionTree<String> tree = new MathExpressionTree<>(expr1);
		    System.out.println(tree.evaluate());
		    //tree.printTreeWithText();
		    readExpressionFromFile("resources/expr.txt");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void readExpressionFromFile(String path) {
		try {
			File myFile = new File(path);
			BufferedReader reader = new BufferedReader(new FileReader(myFile));
			String line;
			
			while ((line = reader.readLine()) != null) {
				MathExpressionTree<String> tree = new MathExpressionTree<>(line);
				System.out.println(line + " = " + tree.evaluate());
			}
		} catch (Exception e) {
			e.printStackTrace();		
		}
	}
}
