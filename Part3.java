// TASK 11: Printer
class Printer {
    void print(int a)     { System.out.println("Called int version: " + a); }
    void print(String a)  { System.out.println("Called String version: " + a); }
    void print(double a)  { System.out.println("Called double version: " + a); }
    void print(boolean a) { System.out.println("Called boolean version: " + a); }
}

// TASK 12: Overloading Area
class AreaCalc {
    // 1. Circle
    double area(double radius) { return 3.14 * radius * radius; }

    // 2. Rectangle
    // RULE USED vs Method 1: Different NUMBER of parameters (2 instead of 1)
    double area(double length, double width) { return length * width; }

    // 3. Triangle
    // RULE USED vs Method 2: Different NUMBER & TYPES of parameters (added boolean)
    double area(double base, double height, boolean isTriangle) { return 0.5 * base * height; }
}

// TASK 13: Student Constructors
class Student3 {
    String name; int rollNo; int marks;

    public Student3(String name, int rollNo, int marks) { // Longest
        this.name = name; this.rollNo = rollNo; this.marks = marks;
    }
    public Student3(String name) {
        this(name, 0, 0); // Calls the longest using default values
    }
    public Student3() {
        this("Unknown", 0, 0); // Calls the longest using default values
    }
}

// TASK 14: Overloading Prediction
public class Part3 {
    static void show(int x)    { System.out.println("int"); }
    static void show(double x) { System.out.println("double"); }
    static void show(String x) { System.out.println("String"); }

    public static void main(String[] args) {
        show(5);     // Output: int (Exact match)
        show(5.0);   // Output: double (Exact match, 5.0 is double by default)
        show('A');   // Output: int (Widening: char 'A' converts to its ASCII int value 65)
        show("A");   // Output: String (Exact match)
        show(5L);    // Output: double (Widening: long can't match int, so it widens to double)
    }
}