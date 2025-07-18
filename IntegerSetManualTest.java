class IntegerSetManualTest {
    public static void main(String[] args) {
        System.out.println("--- Starting IntegerSet Manual Tests ---");
        int passed = 0;
        int failed = 0;

        // Test 1: การสร้าง, เพิ่มข้อมูล, และการเรียงลำดับ
        System.out.println("\n--- Testing add() and sorting ---");
        IntegerSet set1 = new IntegerSet();
        set1.add(34);
        set1.add(1);
        set1.add(2);
        String expected1 = "{1, 2, 34}";
        if (set1.toString().equals(expected1)) {
            System.out.println("PASSED: Add and sort works correctly.");
            passed++;
        } else {
            System.out.println("FAILED: Expected " + expected1 + " but got " + set1.toString());
            failed++;
        }

        // Test 2: การเพิ่มข้อมูลที่ซ้ำซ้อน
        System.out.println("\n--- Testing adding duplicates ---");
        set1.add(1); // เพิ่ม 1 ที่มีอยู่แล้ว
        if (set1.size() == 3) {
            System.out.println("PASSED: Adding a duplicate does not change the size.");
            passed++;
        } else {
            System.out.println("FAILED: Size should be 3 but got " + set1.size());
            failed++;
        }

        // Test 3: การลบข้อมูล
        System.out.println("\n--- Testing remove() ---");
        set1.remove(2);
        String expected2 = "{1, 34}";
        if (set1.toString().equals(expected2)) {
            System.out.println("PASSED: Remove works correctly.");
            passed++;
        } else {
            System.out.println("FAILED: Expected " + expected2 + " but got " + set1.toString());
            failed++;
        }

        // Test 4: การตรวจสอบข้อมูล (contains)
        System.out.println("\n--- Testing contains() ---");
        if (set1.contains(1) && !set1.contains(0)) {
            System.out.println("PASSED: Contains works correctly after removal.");
            passed++;
        } else {
            System.out.println("FAILED: Contains check is incorrect.");
            failed++;
        }

        // --- สรุปผล ---
        System.out.println("\n--------------------");
        System.out.println("--- Test Summary ---");
        System.out.println("Passed: " + passed + ", Failed: " + failed);
        if (failed == 0) {
            System.out.println("Excellent! All tests passed!");
        } else {
            System.out.println("Some tests failed.");
        }
    }
}