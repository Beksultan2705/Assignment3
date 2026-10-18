// TASKS 5 & 6: BankAccount
class BankAccount {
    // Task 6: Made accountNumber final
    private final String accountNumber;
    private String owner;
    private double balance;

    public BankAccount(String accountNumber, String owner, double balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    // Task 6: Only getter for accountNumber
    public String getAccountNumber() { return accountNumber; }
    public String getOwner() { return owner; }
    public double getBalance() { return balance; } // No setter for balance

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
        else System.out.println("Error: Deposit amount must be > 0.");
    }

    public void withdraw(double amount) {
        if (amount > balance) System.out.println("Error: Insufficient funds.");
        else if (amount <= 0) System.out.println("Error: Invalid amount.");
        else balance -= amount;
    }
}

// TASK 7: Point
class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Point() {
        this(0, 0); // Calls the other constructor
    }
    public Point move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
        return this; // Returns current object for method chaining
    }
    public void print() { System.out.println("Point(" + x + ", " + y + ")"); }
}

// TASK 8: Employee
class Employee {
    private static int nextId = 1000;
    private int id;

    public Employee() {
        this.id = nextId++;
    }
    public int getId() { return id; }

    /*
     * QUESTION: Why is 'id' non-static but 'nextId' static?
     * ANSWER: 'id' is non-static because every single employee needs their own
     * unique ID number (it belongs to the instance). 'nextId' is static because
     * it must be shared across all Employee objects to act as a global counter
     * that increments for each new hire (it belongs to the class).
     */
}

// TASK 9: MathUtils
class MathUtils {
    static int max(int a, int b) { return a > b ? a : b; }
    static boolean isEven(int a) { return a % 2 == 0; }
    static int factorial(int n) { return n <= 1 ? 1 : n * factorial(n - 1); }
    static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) if (n % i == 0) return false;
        return true;
    }
}

// TASK 10: Caller and member table
/*
 * Caller and member                 | Static variable | Non-static variable
 * ----------------------------------|-----------------|---------------------
 * Static method, directly           | Yes             | No
 * Static method, through an object  | Yes             | Yes (using obj ref)
 * Non-static method, directly       | Yes             | Yes
 */

public class Part2 {
    public static void main(String[] args) {
        // Task 6 check
        BankAccount acc = new BankAccount("KZ12", "Asan", 100);
        // acc.accountNumber = "KZ99"; // COMPILE ERROR: Cannot assign a value to final variable

        // Task 7 check
        new Point().move(1, 2).move(3, 4).print(); // Point(4, 6)

        // Task 8 check
        for (int i=0; i<5; i++) System.out.println(new Employee().getId());

        // Task 9 check
        System.out.println(MathUtils.max(10, 20));
    }
}