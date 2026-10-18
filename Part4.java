// TASK 15: Shape
class Shape {
    String color = "Red";
    void describe() { System.out.println("I am a shape. Color: " + color); }
}
class Circle extends Shape {
    int radius = 5;
    @Override
    void describe() {
        super.describe();
        System.out.println("I am a Circle with radius " + radius);
    }
}
class Square extends Shape {
    int side = 4;
    @Override
    void describe() {
        super.describe();
        System.out.println("I am a Square with side " + side);
    }
}

// TASK 16: Vehicles
class Vehicle { void start() { System.out.println("Vehicle starts"); } }
class Car2 extends Vehicle { @Override void start() { System.out.println("Car goes vroom"); } }
class Bike extends Vehicle { @Override void start() { System.out.println("Bike starts pedaling"); } }
class Truck extends Vehicle { @Override void start() { System.out.println("Truck honks loudly"); } }

// TASK 17: Constructor Chain
class LivingBeing { LivingBeing() { System.out.println("LivingBeing"); } }
class Animal2 extends LivingBeing { Animal2() { System.out.println("Animal"); } }
class Dog2 extends Animal2 { Dog2() { System.out.println("Dog"); } }
/*
 * OUTPUT ORDER: LivingBeing -> Animal -> Dog
 * EXPLANATION: The parent constructor runs first because the child class inherits
 * properties from the parent. The child object cannot be fully created and initialized
 * until the parent object's state is guaranteed to be set up in memory.
 * (An implicit super() is called in the first line of the child constructor).
 */

// TASK 18: Variable Hiding
class ParentStr { String type = "ParentType"; }
class ChildStr extends ParentStr {
    String type = "ChildType";

    void printTypes() {
        String type = "LocalType";

        System.out.println(type);       // Result: LocalType (Closest scope)
        System.out.println(this.type);  // Result: ChildType (Instance variable of Child)
        System.out.println(super.type); // Result: ParentType (Hidden variable of Parent)
    }
}

// TASK 19: Animal and Dog Sound
class AnimalSound {
    void sound() { System.out.println("Animal sound"); }
}
class DogSound extends AnimalSound {
    @Override // This is OVERRIDING (same signature as parent)
    void sound() { System.out.println("Woof"); }

    // This is OVERLOADING (same method name, different parameters)
    void sound(int times) {
        for(int i=0; i<times; i++) System.out.print("Woof ");
        System.out.println();
    }
}

// TASK 20 & 21: Casting and toString
class AnimalTask20 { void sound() {} }
class DogTask20 extends AnimalTask20 {
    void fetch() {}

    // TASK 21: Override toString
    @Override
    public String toString() {
        return "Student[name=Asan, roll=1, marks=75]";
    }
}

public class Part4 {
    public static void main(String[] args) {
        // Task 16 array loop
        Vehicle[] arr = { new Car2(), new Bike(), new Truck() };
        for(Vehicle v : arr) v.start();

        // Task 20 check
        AnimalTask20 a = new DogTask20();
        a.sound();
        // a.fetch(); // COMPILE ERROR!
        /*
         * WHY IT FAILS: The reference variable 'a' is of type AnimalTask20.
         * The compiler only allows you to call methods that exist in the reference type.
         * Since fetch() is not defined in AnimalTask20, it fails, even though the
         * actual object in memory is a Dog.
         */
        ((DogTask20) a).fetch(); // This compiles because of the explicit downcast.
    }
}