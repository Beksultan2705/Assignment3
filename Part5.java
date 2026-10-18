// PROGRAM 1
class Person {
    private String name;
    private int age;

    // ERROR 1: Constructors cannot have a return type (void).
    // ERROR 2: 'name = name' causes variable shadowing, fields remain null/0.
    public Person(String name, int age) { // Removed 'void'
        this.name = name; // Added 'this.'
        this.age = age;   // Added 'this.'
    }
    /*
     * QUESTION: After fixing the compile error, is name still null? Why?
     * ANSWER: If you only removed 'void' but didn't add 'this.', name would
     * still be null. The local parameter 'name' hides the instance variable 'name',
     * so it just assigns the parameter to itself.
     */
}

// PROGRAM 2 (Fixed)
class AnimalErr2 {
    // ERROR: No default constructor in parent.
    AnimalErr2() {} // FIX: Added default constructor
    AnimalErr2(String name) { }
}
class DogErr2 extends AnimalErr2 {
    DogErr2() {
        // OR FIX: explicit call: super("name");
    }
}
/* EXPLANATION: Dog() implicitly calls super(), but Animal only had a
 * parameterized constructor, meaning the default super() didn't exist. */

// PROGRAM 3 (Fixed)
class Base {
    public void show() { }
    public void lock() { } // ERROR 1 FIX: Removed 'final'
}
class Child extends Base {
    public void show() { } // ERROR 2 FIX: Added 'public' to match parent visibility
    public void lock() { }
}
/* EXPLANATION: You cannot override a 'final' method. Also, when overriding
 * a method, you cannot restrict its visibility (Base was public, Child was default). */

// PROGRAM 4 (Fixed)
class Counter {
    static int count = 0; // ERROR FIX: Made variable static
    static void increment() {
        count++;
    }
}
/* EXPLANATION: A static method cannot access a non-static instance variable. */


// ==================== PREDICT THE OUTPUT ====================

// QUESTION 1
class A { A() { System.out.println("A"); } }
class B extends A { B() { System.out.println("B"); } }
class C extends B { C() { System.out.println("C"); } }
// Execution: new C();
/*
 * OUTPUT:
 * A
 * B
 * C
 * EXPLANATION: new C() calls C's constructor -> calls B's -> calls A's.
 * A executes, then B executes, then C executes.
 */

// QUESTION 2
class ParentQ2 { void hello() { System.out.println("Parent"); } }
class ChildQ2 extends ParentQ2 { void hello() { System.out.println("Child"); } }
// Execution:
// Parent p = new Child(); p.hello();
// Child c = new Child(); c.hello();
/*
 * OUTPUT:
 * Child
 * Child
 * EXPLANATION: Due to Polymorphism/Dynamic Method Dispatch, the overridden
 * method of the actual object in memory (Child) is called at runtime,
 * regardless of the reference type (Parent or Child).
 */

// QUESTION 3
class TestQ3 {
    static int a = 0;
    int b = 0;
    TestQ3() { a++; b++; }
}
// Execution:
// Test t1 = new Test(); Test t2 = new Test(); Test t3 = new Test();
// System.out.println(Test.a + " " + t1.b);
/*
 * OUTPUT:
 * 3 1
 * EXPLANATION: 'a' is static, meaning it is shared among all objects. It increments
 * 3 times (once for each object created). 'b' is non-static, so each object has
 * its own copy. For t1, it was initialized and incremented exactly once.
 */