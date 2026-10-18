// TASK 1: Rectangle
class Rectangle {
    double length;
    double width;

    void printInfo() {
        System.out.println("Rectangle: " + length + "x" + width);
    }
    double area() {
        return length * width;
    }
    void scale(double factor) {
        length *= factor;
        width *= factor;
    }
    boolean isSquare() {
        return length == width;
    }
}

// TASK 2: Car
class Car {
    String brand;
    int speed;
    int fuel;

    void accelerate(int amount) {
        speed += amount;
        fuel -= 1;
    }
    void brake(int amount) {
        speed -= amount;
        if (speed < 0) {
            speed = 0; // Speed must never go below 0
        }
    }
    void showStatus() {
        System.out.println(brand + " - Speed: " + speed + ", Fuel: " + fuel);
    }
}

// TASK 3: Real-life thing (Movie)
/*
 * +-----------------------------------------+
 * |                  Movie                  |
 * +-----------------------------------------+
 * | - title: String                         |
 * | - director: String                      |
 * | - durationMinutes: int                  |
 * | - rating: double                        |
 * +-----------------------------------------+
 * | + play(): void                          | (Takes nothing, returns nothing)
 * | + getDuration(): int                    | (Takes nothing, returns value)
 * | + updateRating(double newRating): void  | (Takes value, returns nothing)
 * | + isLongerThan(int minutes): boolean    | (Takes value, returns value)
 * +-----------------------------------------+
 */
class Movie {
    String title;
    String director;
    int durationMinutes;
    double rating;

    public Movie(String title, String director, int durationMinutes, double rating) {
        this.title = title;
        this.director = director;
        this.durationMinutes = durationMinutes;
        this.rating = rating;
    }

    void play() { System.out.println("Playing: " + title); }
    int getDuration() { return durationMinutes; }
    void updateRating(double newRating) { this.rating = newRating; }
    boolean isLongerThan(int minutes) { return durationMinutes > minutes; }
}

// TASK 4: Predict the output
class Student {
    String name; int rollNo; int marks;
    Student(String n, int r, int m) { name = n; rollNo = r; marks = m; }
    void addBonus(int b) { marks += b; }
    int getMarks() { return marks; }
}

public class Part1 {
    public static void main(String[] args) {
        // Task 4 execution
        Student a = new Student("Asan", 1, 70);
        Student b = a;
        b.addBonus(10);

        // Output prediction: 80
        System.out.println(a.getMarks());

        Student c = new Student("Asan", 1, 70);

        // Output prediction: false
        System.out.println(a == c);

        /*
         * QUESTION: When you write b = a, is the object copied or only the reference?
         * ANSWER: Only the reference is copied. Both variables 'a' and 'b'
         * now point to the exact same object in the memory. Modifying 'b' changes 'a'.
         */
    }
}