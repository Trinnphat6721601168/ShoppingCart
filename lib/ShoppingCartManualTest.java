package lib;
import java.util.ArrayList;

public class ShoppingCartManualTest {

    public static void run() {
        System.out.println("--- Starting Shopping Cart Calculator Tests ---");
        System.out.println(); // for spacing

        int passedCount = 0;
        int failedCount = 0;

        // Test 1: ตะกร้าเป็น null
        try {
            double total1 = ShoppingCartCalculator.calculateTotalPrice(null);
            if (total1 == 0.0) {
                System.out.println("1.PASSED: Null cart should return 0.0");
                passedCount++;
            } else {
                System.out.println("1.FAILED: Null cart expected 0.0 but got " + total1);
                failedCount++;
            }
        } catch (Exception e) {
            System.out.println("1.FAILED: Null cart caused an exception: " + e.getMessage());
            failedCount++;
        }

        // Test 2: ตะกร้าว่าง
        ArrayList<CartItem> emptyCart = new ArrayList<>();
        double total2 = ShoppingCartCalculator.calculateTotalPrice(emptyCart);
        if (total2 == 0.0) {
            System.out.println("2.PASSED: Empty cart should return 0.0");
            passedCount++;
        } else {
            System.out.println("2.FAILED: Empty cart expected 0.0 but got " + total2);
            failedCount++;
        }

        // Test 3: คำนวณปกติ ไม่มีส่วนลด
        ArrayList<CartItem> simpleCart = new ArrayList<>();
        simpleCart.add(new CartItem("NORMAL", "Bread", 25.0, 2)); // 50
        simpleCart.add(new CartItem("NORMAL", "Milk", 15.0, 1));      // 15
        double total3 = ShoppingCartCalculator.calculateTotalPrice(simpleCart);
        if (total3 == 65.0) {
            System.out.println("3.PASSED: Simple cart total is correct (65.0)");
            passedCount++;
        } else {
            System.out.println("3.FAILED: Simple cart total expected 65.0 but got " + total3);
            failedCount++;
        }

        // Test 4: คำนวณโปรโมชั่นลดจากการแถม
        ArrayList<CartItem> promotion1 = new ArrayList<>();
        promotion1.add(new CartItem("BOGO", "Bread", 25.0, 2)); // 25
        promotion1.add(new CartItem("BOGO", "Milk", 15.0, 3)); //30
        double total4 = ShoppingCartCalculator.calculateTotalPrice(promotion1);
        if (total4 == 55.0) {
            System.out.println("4.PASSED: Promotion1 total is correct (55.0)");
            passedCount++;
        } else {
            System.out.println("4.FAILED: Promotion1 total expected 55.0 but got " + total4);
            failedCount++;
        }

        // Test 5: คำนวณโปรโมชั่นซื้อ 6 ชิ้นขึ้นไปลด 10%
        ArrayList<CartItem> promotion2 = new ArrayList<>();
        promotion2.add(new CartItem("BULK", "Bread", 25.0, 6)); // 135
        promotion2.add(new CartItem("BULK", "Milk", 15.0, 8)); //108
        double total5 = ShoppingCartCalculator.calculateTotalPrice(promotion2);
        if (total5 == 243.0) {
            System.out.println("5.PASSED: Promotion2 total is correct (243.0)");
            passedCount++;
        } else {
            System.out.println("5.FAILED: Promotion2 total expected 243.0 but got " + total5);
            failedCount++;
        }

        // --- Test Summary ---
        System.out.println("\n--------------------");
        System.out.println("--- Test Summary ---");
        System.out.println("Passed: " + passedCount + ", Failed: " + failedCount);
        if (failedCount == 0) {
            System.out.println("Excellent! All tests passed!");
        } else {
            System.out.println("Some tests failed.");
        }
    }
}
