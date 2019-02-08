import java.util.Scanner;

class Hello {
 public static void main(String[] args ) {
   System.out.println("Hello there, how are you doing?");
   System.out.println("What is your name?");
   Scanner reader = new Scanner(System.in);
   String name = reader.nextLine();
   System.out.println("Hello " + name);
   System.out.println("YEettt");
 }
}
