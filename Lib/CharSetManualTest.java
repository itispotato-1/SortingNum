class CharSetManualTest {

    public static void main(String[] args) {
        System.out.println("--- Starting CharSet Manual Tests ---");
        int passed = 0;
        int failed = 0;

        // Test 1: การสร้าง, เพิ่มข้อมูล, และการเรียงลำดับ
        System.out.println("\n--- Testing add() and sorting ---");
        CharSet set1 = new CharSet();
        set1.add('c');
        set1.add('a');
        set1.add('b');
        String expected1 = "{a, b, c}";
        if (set1.toString().equals(expected1)) {
            System.out.println("PASSED: Add and sort works correctly.");
            passed++;
        } else {
            System.out.println("FAILED: Expected " + expected1 + " but got " + set1.toString());
            failed++;
        }

        // Test 2: การเพิ่มข้อมูลที่ซ้ำซ้อน
        System.out.println("\n--- Testing adding duplicates ---");
        set1.add('a'); // เพิ่ม 'a' ที่มีอยู่แล้ว
        if (set1.size() == 3) {
            System.out.println("PASSED: Adding a duplicate does not change the size.");
            passed++;
        } else {
            System.out.println("FAILED: Size should be 3 but got " + set1.size());
            failed++;
        }

        // Test 3: การลบข้อมูล
        System.out.println("\n--- Testing remove() ---");
        set1.remove('b');
        String expected2 = "{a, c}";
        if (set1.toString().equals(expected2)) {
            System.out.println("PASSED: Remove works correctly.");
            passed++;
        } else {
            System.out.println("FAILED: Expected " + expected2 + " but got " + set1.toString());
            failed++;
        }

        // Test 4: การตรวจสอบข้อมูล (contains)
        System.out.println("\n--- Testing contains() ---");
        if (set1.contains('a') && !set1.contains('b')) {
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