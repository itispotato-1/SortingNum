/**
 * ADT ที่เก็บ Integer แบบไม่ซ้ำกันและเรียงลำดับ
 */
public class IntegerSet {
    private int count = 0;
    private int Set[] = new int[1];
    private int SetTemp[];
    private int Temp;
    // Rep Inariant (RI):
    // - ห้ามมีตัวอักษรซ้ำและค่าไม่เป็นNull
    // - มีการเรียงตัวอักษรจากน้อยไปหามาก
    // Abstaction Function (AF):
    //  -add(int num) : เพิ่มตัวอักษรเข้าไปในSet
    //  -remove(int num) : ลบตัวอักษรตัวนั้นในSet
    //  -size() : เช็กขนาดของSet
    //  -contains(int num) : เช็กว่าตัวนั้นในSetหรือไม่

    /**
     * เป็นMethodที่เพิ่มค่านั้นไปในSet
     * 
     * @param num : ค่าที่จะเพิ่ม
     */
    public int add(int num) {
        for (int i = 0; i < size(); i++) {
            if (Set[i] == num) {
                return 0;
            }
        }
        SetTemp = new int[count + 1];   //ไว้สลับArrไปเก็บในTemp
        for (int i = 0; i < size(); i++) {
            SetTemp[i] = Set[i];
        }
        SetTemp[count++] = num;

        Set = new int[count + 1];       
        for (int i = 0; i < size(); i++) {//ไว้สลับTempไปเก็บที่เดิม
            Set[i] = SetTemp[i];
        }
        checkRep();
        return 0;
    }

    /**
     * เป็นMethodที่หาขนาดของSetนี้
     * 
     * @return ค่าจำนวนขนาดของSetนี้
     */
    public int size() {
        return count;
    }

    /**
     * เป็นMethodที่ลบค่าตัวอักษรที่ที่รับมา
     * 
     * @param num : ค่าที่จะลบ
     */
    public void remove(int num) {
        for (int i = 0; i < size(); i++) {
            if (num == Set[i]) { //ถ้าเจอตัวที่จะลบ
                SetTemp = new int[count];   
                for (int j = 0; j < size(); j++) {//สลับSetเก่าไปเก็บที่ Tempก่อนเปลี่ยน
                    SetTemp[j] = Set[j];    
                }
                Set = new int[--count];
                for (int j = 0; j < size(); j++) {//สลับSetใหม่มาคืน
                    if (j < i) {
                        Set[j] = SetTemp[j];
                    } else {
                        Set[j] = SetTemp[j + 1];
                    }
                }
                break;
            }
        }
    }

    /**
     * เป็นMethodที่เปรียบเทียบตัวอักษรที่รับมากับค่าทื่มีอยู้ ถ้าจริงจะส่งค่า true
     * ,ถ้าเท็จจะส่งค่า false
     * 
     * @param num : ค่าที่จะเทียบ
     * @return true,false
     */
    public boolean contains(int num) {
        for (int i = 0; i < size(); i++) {
            if (Set[i] == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * เป็นMethodที่แปลงSetให้ใส่ {} และ , คันระหว่างตัวเลขนั้น
     * 
     * @return {เซ็ตตัวอักษร ,เซ็ตตัวอักษร...}
     */
    public String toString() {

        String tran = "{";
        if (count != 0) {
            tran += Integer.toString(Set[0]);
            for (int i = 1; i < size(); i++) {
                tran += ", " + Integer.toString(Set[i]);
            }

        }
        tran += "}";
        return tran;
    }

    /**
     * เป็นMethodที่เช็กการเรียงลำดับและจัดลำดับให้ถูก
     */
    private void checkRep() {
        if (size() != 1) {
            for (int i = count - 1; i > 0; i--) {
                if (Set[i] < Set[i - 1]) {
                    Temp = Set[i];
                    Set[i] = Set[i - 1];
                    Set[i - 1] = Temp;
                }
            }
        }
    }

}
