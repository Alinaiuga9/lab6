package lab7;

import lab7.Circle;
import lab7.Form;
import lab7.Square;
import lab7.Triangle;

public class Main {
    public static void main(String[] args) {

        // 7.6.1. Contor instante
        Triangle tri = new Triangle(1.1F, 2.0F, "red");
        Circle c = new Circle(1.5F, "yellow");
        Square sq = new Square(1.2F, "blue");
        System.out.println("Area = " + tri.getArea()+" details: " + tri);
        System.out.println("Area = " + c.getArea() + " details: " + c);
        System.out.println("Area = " + sq.getArea() + " details: " + sq);
        System.out.println("Total instance count is " + Form.getInstanceCount());   // sau tri.getInstanceCount() sau sq.getInstanceCount()

      /*  //7.6.2 Password maker singleton
        PasswordMaker pm2 = PasswordMaker.getInstance();
        System.out.println("\n7.6.2 a+b) Generated passwords: ");
        System.out.println("1:" + PasswordMaker.getInstance().getPassword());
        System.out.println("2:" + PasswordMaker.getInstance().getPassword());
        System.out.println("3:" + PasswordMaker.getInstance().getPassword());
        System.out.println("4:" + pm2.getPassword());
        System.out.println("5:" + pm2.getPassword());
        System.out.println("\n7.6.2 c) Number of time getInstance() has been called: "+PasswordMaker.getCallingCounts());
*/
    }
}



/*
package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
/

 */