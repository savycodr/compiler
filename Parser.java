package com.compiler;

import java.util.*;

class Parser{

  Parser(){

  }

  boolean parse(String s){
    System.out.println(s);
    boolean isGood = true;

    // A stack: first in last out
    Stack stack = new Stack();

    // cycle through each character in the array
    for (int i=0; i<s.length(); i++){
      String ch = s.split("")[i];
      switch (ch){
        case "{":
          stack.push("}");
          break;
        case "(":
          stack.push(")");
          break;
        case "[":
          stack.push("]");
          break;
        case "}":
          if (stack.empty() || !stack.pop().equals("}"))
            isGood=false;
            break;
        case "]":
        if (stack.empty() || !stack.pop().equals("]"))
          isGood=false;
          break;
        case ")":
        if (stack.empty() || !stack.pop().equals(")"))
          isGood=false;
          break;
        }
      if (!isGood)
        break;
    }
    
    System.out.println("Is a Good String? " + isGood);
    return isGood;
    
  }

  public  static void main(String args[]){

    System.out.println("Hi Heather");
    Parser parser = new Parser();
    parser.parse("{}");
    parser.parse("{[]}");
    parser.parse("{([]}");

    
  }
}