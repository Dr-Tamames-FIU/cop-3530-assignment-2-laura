package org.assignment2;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Stack;

public class FormulaCalc {

    public static void main(String[] args) throws FileNotFoundException {
    Scanner scnr = new Scanner(new File("Formulas.txt"));
        while (scnr.hasNextLine()) {
            String formula = scnr.nextLine();
            int protons = Algorithm(formula);
            System.out.println(protons);
        }
        scnr.close();
    }

    /**
     * Algorithm
     * @param a Molecular formula
     * @return Total number of protons
     */
    public static int Algorithm(String a)
    {
        Stack<Integer> stack = new Stack<>();
        int protons = 0;
        int multiple = 1;
        String element = "";

        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            
       /* Use the class exercise for Lecture 6 and particularly, the answers on:
          https://itamames.github.io/Lecture6Answers/
          You can see how to parse an array in there.
          Once you are dealing character by character, you can set a multiple if statement to check if that character is a capital letter, a small case letter, a number, or a parenthesis.
          For each of these 4 options, you need to perform a decision.

        //If is a capital letter 
           if (Character.isUpperCase(c)) {
        
            //if the stack is not empty
            if (!element.isEmpty()) {
                //pop 1:
                //add it to cumulative sum
                    protons += getElementProtons(element) * multiple;
                    element = "";
                }
           //request the string value and add it to stack.
           stack.push(multiple);
			multiple = 1;     
           element += c;
        }

        //else if is a lowercase letter
        else if (Character.isLowerCase(c)) {
                element += c;
            } 
            //pop stack to clear it.
            //grab the prior letter and request the string value and add it to stack

        
        //else if it is a number
            //pop 1:
            //multiply times the number
            //add it to a cumulative sum
        else if (Character.isDigit(c)) {
				int digit = Character.getNumericValue(c);
				while (i + 1 < a.length() && Character.isDigit(a.charAt(i + 1))) {
					digit = digit * 10 + Character.getNumericValue(a.charAt(++i));
				}
				multiple = digit;
			} 
      
        //else if parenthesis
else if (c == '(') {
				stack.push(multiple);
				multiple = 1;
			} 
			else if (c == ')') {
				protons += getElementProtons(element) * multiple;
				multiple = stack.pop();
			}
		}

		if (!element.isEmpty()) {
			protons += getElementProtons(element) * multiple;
		}

		return protons;
	}

    
  private static int getElementProtons(String c) 
  {
    
    switch (c) 
    {
    case "H": return 1;
    case "He": return 2;
    case "Li": return 3;
    case "Be": return 4;
    case "B": return 5;
    case "C": return 6;
    case "N": return 7;
    case "O": return 8;
    case "F": return 9;
    case "Ne": return 10;
    case "Na": return 11;
    case "Mg": return 12;
    case "Al": return 13;
    case "Si": return 14;
    case "P": return 15;
    case "S": return 16;
    case "Cl": return 17;
    case "K": return 19;
    case "Ar": return 18;
    case "Ca": return 20;
    case "Sc": return 21;
    case "Ti": return 22;
    case "V": return 23;
    case "Cr": return 24;
    case "Mn": return 25;
     case "Fe": return 26;
     case "Ni": return 28;
     case "Co": return 27;
     case "Cu": return 29;
     case "Zn": return 30;
     case "Ga": return 31;
     case "Ge": return 32;
     case "As": return 33;
     case "Se": return 34;
     case "Br": return 35;
     case "Kr": return 36;
     case "Rb": return 37;
     case "Sr": return 38;
     case "Y": return 39;
     case "Zr": return 40;
     case "Nb": return 41;
     case "Mo": return 42;
     case "Tc": return 43;
     case "Ru": return 44;
     case "Rh": return 45;
     case "Pd": return 46;
     case "Ag": return 47;
     case "Cd": return 48;
     case "In": return 49;
     case "Sn": return 50;
     case "Sb": return 51;
     case "I": return 53;
     case "Te": return 52;
     case "Xe": return 54;
     default: return 0;
    }
  }
}

