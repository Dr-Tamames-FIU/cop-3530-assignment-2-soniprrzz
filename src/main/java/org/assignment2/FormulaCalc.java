package org.assignment2;

import java.util.Stack;

public class FormulaCalc {

    public static void main(String[] args) {
        // Testing the Algorithm method
        System.out.println(Algorithm("H"));           
        System.out.println(Algorithm("KBr"));          
        System.out.println(Algorithm("H2O"));         
        System.out.println(Algorithm("NaCl"));        
        System.out.println(Algorithm("C6H12O6"));     
        System.out.println(Algorithm("Ni(NO3)2"));     
        System.out.println(Algorithm("Co3(Fe(CN)6)2")); 
    }

    /**
     * Algorithm to compute the total number of protons in a given molecular formula.
     *
     * @param formula Molecular formula
     * @return Total number of protons
     */
    public static int Algorithm(String formula) {
        Stack<Integer> stack = new Stack<>();
        int cumulativeSum = 0;
    
        for (int i = 0; i < formula.length(); i++) {
            char currentChar = formula.charAt(i);
    
            if (Character.isUpperCase(currentChar)) {
                // If it's a capital letter
                if (!stack.isEmpty()) {
                    cumulativeSum += stack.pop();
                }
    
                int atomicNumber;
                if (i + 1 < formula.length() && Character.isLowerCase(formula.charAt(i + 1))) {
                    atomicNumber = getElementProtons(formula.substring(i, i + 2));
                    i++;
                } else {
                    atomicNumber = getElementProtons(formula.substring(i, i + 1));
                }
    
                stack.push(atomicNumber);
            } else if (Character.isDigit(currentChar)) {
                // If it's a number, accumulate it
                int count = currentChar - '0';
                while (i + 1 < formula.length() && Character.isDigit(formula.charAt(i + 1))) {
                    count = count * 10 + (formula.charAt(++i) - '0');
                }
    
                // Multiply by the last element's atomic number and add to the cumulative sum
                cumulativeSum += count * (stack.isEmpty() ? 1 : stack.pop());
            } else if (currentChar == '(') {
                // If it's an opening parenthesis, push the cumulative sum to the stack
                stack.push(cumulativeSum);
                cumulativeSum = 0; // Reset cumulative sum
            } else if (currentChar == ')') {
                // If it's a closing parenthesis, pop the stack, multiply by the number, and add to the cumulative sum
                int count = 1;
                if (i + 1 < formula.length() && Character.isDigit(formula.charAt(i + 1))) {
                    count = formula.charAt(++i) - '0';
                }
                
                // Multiply by the last element's atomic number (if there is one) and add to the cumulative sum
                cumulativeSum += (stack.isEmpty() ? 1 : stack.pop()) * count;
            }
        }
    
        // Add any remaining values in the stack to the cumulative sum
        while (!stack.isEmpty()) {
            cumulativeSum += stack.pop();
        }
    
        return cumulativeSum;
    }
    
    
    private static int getElementProtons(String symbol) {
        switch (symbol) {
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



