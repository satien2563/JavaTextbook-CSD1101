package chap07_Method;

public class Ex7_3i_TextFormatter {
    // เมธอดจัดการข้อความ: ตัดช่องว่างหัวท้าย
    public static String formatText(String text) {
        return text.trim();
    }

    // เมธอดจัดการข้อความ: แปลงเป็นตัวพิมพ์ใหญ่
    public static String formatText(String text, boolean toUpperCase) {
        if (toUpperCase) {
            return text.toUpperCase();
        } else {
            return text.toLowerCase();
        }
    }

    // เมธอดจัดการข้อความ: เพิ่ม prefix และ suffix
    public static String formatText(String text, String prefix, String suffix) {
        return prefix + text.trim() + suffix;
    }

    public static void main(String[] args) {
        String sample = "   java Programming   ";

        System.out.println("ตัดช่องว่าง: [" + formatText(sample) + "]");
        System.out.println("แปลงเป็นพิมพ์ใหญ่: " + formatText(sample, true));
        System.out.println("แปลงเป็นพิมพ์เล็ก: " + formatText(sample, false));
        System.out.println("เพิ่ม prefix/suffix: " + formatText(sample, "[", "]"));
    }
}
