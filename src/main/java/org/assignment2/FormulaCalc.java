package org.assignment2;

import java.util.Stack;

public class FormulaCalc {

    public static void main(String[] args) {
        System.out.println(Algorithm("H"));
        System.out.println(Algorithm("KBr"));
        System.out.println(Algorithm("H2O"));
        System.out.println(Algorithm("NaCl"));
        System.out.println(Algorithm("C6H12O6"));
        System.out.println(Algorithm("Ni(NO3)2"));
        System.out.println(Algorithm("Co3(Fe(CN)6)2"));
    }

    /**
     * Algorithm to compute the total number of protons in a molecular formula.
     *
     * @param formula Molecular formula
     * @return Total number of protons
     */
    public static int Algorithm(String formula) {
        Stack<Integer> stack = new Stack<>();
        int cumulativeSum = 0;

        for (int i = 0; i < formula.length(); i++) {
            char c = formula.charAt(i);

            if (Character.isUpperCase(c)) {
                if (!stack.isEmpty()) {
                    cumulativeSum += stack.pop();
                }
                String elementSymbol = String.valueOf(c);
                stack.push(getElementProtons(elementSymbol));
            } else if (Character.isLowerCase(c)) {
                // Add the cumulative sum for lowercase letters
                cumulativeSum += stack.pop();
                String elementSymbol = String.valueOf(c);
                stack.push(getElementProtons(elementSymbol));
            } else if (Character.isDigit(c)) {
                int multiplier = Character.getNumericValue(c);
                stack.push(stack.pop() * multiplier);
            } else if (c == '(') {
                // Push current cumulative sum and reset it
                stack.push(cumulativeSum);
                cumulativeSum = 0;
            } else if (c == ')') {
                // Pop the cumulative sum from the opening parenthesis
                int subexpressionSum = stack.pop();
                // Multiply it by the multiplier after the closing parenthesis
                int multiplier = Character.getNumericValue(formula.charAt(++i));
                cumulativeSum += subexpressionSum * multiplier;
            }
        }

        while (!stack.isEmpty()) {
            cumulativeSum += stack.pop();
        }

        return cumulativeSum;
    }

    private static int getElementProtons(String elementSymbol) {
        switch (elementSymbol) {
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

