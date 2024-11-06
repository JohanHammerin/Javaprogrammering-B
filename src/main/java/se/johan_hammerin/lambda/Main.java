package se.johan_hammerin.lambda;

public class Main {
    public static void main(String[] args) {

        String name = "Johan";
        char symbol = '!';
        MyInterface myInterface = (argName, argSymbol) -> {
            System.out.println("Hello World " + argName);
            System.out.println("It is a nice day! " + argSymbol);
        };

        MyInterface myInterFace2 = (argName, argSymbol) -> System.out.println("Hello " + argName + argSymbol);
        myInterface.message(name, symbol);
        myInterFace2.message(name, symbol);
        new MyFrame();
    }




}






/* lambda expression = 	feature for Java 8 and above
 * 						also known as an anonymous method
 * 						a shorter way to write anonymous classes with only one method
 *
 *						need to use a functional interface or use a pre-defined functional interface
 *						they contain only one abstract method
 *						ex. ActionListener, Runnable, (user-defined)
 *
 *						A Lambda expression can be used in any place where a functional interface is required
 *						How to use a lambda expression:
 *						(arguments) -> {statement/s}
 */