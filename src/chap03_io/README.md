# บทที่ 3: การรับและแสดงผลข้อมูลในภาษา Java (Input and Output in Java)

บทนี้นำเสนอพื้นฐานสำคัญในการเขียนโปรแกรมที่สามารถสื่อสารกับผู้ใช้ได้  
ทั้งการแสดงผลข้อมูลออกทางหน้าจอ และการรับค่าจากผู้ใช้ผ่านทางแป้นพิมพ์  
ครอบคลุมคำสั่งพื้นฐานอย่าง `print`, `println`, `printf`, การจัดรูปแบบข้อความ, และการใช้ `Scanner` สำหรับการรับข้อมูล

---

## 🔹 รายชื่อโปรแกรมตัวอย่าง

| ชื่อไฟล์ | คำอธิบาย |
|----------|-----------|
| `PrintExample1.java` | ตัวอย่างการใช้ `System.out.print()` แสดงข้อความต่อเนื่อง |
| `PrintlnExample1.java` | ตัวอย่างการใช้ `System.out.println()` แสดงข้อความแบบขึ้นบรรทัดใหม่ |
| `HorizontalOutputExample.java` | การแสดงผลข้อความแนวนอน |
| `VerticalListExample.java` | การแสดงผลแบบแนวตั้ง |
| `MultiLineMessageExample.java` | การใช้ `\n` แสดงข้อความหลายบรรทัด |
| `EscapeCharacterExample.java` | การใช้อักขระพิเศษ เช่น `\t`, `\"`, `\\` |
| `TextConcatExample.java` | การเชื่อมข้อความกับตัวแปรด้วยเครื่องหมาย `+` |
| `PrintfExample.java` | การใช้ `System.out.printf()` จัดรูปแบบข้อความ |
| `FormatSpecifierExample.java` | การใช้รูปแบบ `%d`, `%f`, `%s`, `%c` |
| `DecimalPrecisionExample.java` | การกำหนดตำแหน่งทศนิยม เช่น `%.2f` |
| `StringFormatExample.java` | การใช้ `String.format()` จัดรูปแบบข้อความเพื่อเก็บในตัวแปร |
| `ScannerImportExample.java` | ตัวอย่างการ import ไลบรารี `Scanner` และสร้างอ็อบเจกต์ |
| `MultiInputExample.java` | การรับข้อมูลหลายชนิดจากผู้ใช้ (เช่น int, double, String) |
| `ScannerFixExample.java` | ตัวอย่างการจัดการปัญหา `nextLine()` ตามหลัง `nextInt()` |
| `ScannerProblemExample.java` | สาธิตข้อผิดพลาดที่พบบ่อยในการใช้ `Scanner` |
| `StudentInfoExample.java` | โปรแกรมรับข้อมูลนักศึกษาและแสดงผลอย่างครบถ้วน |
| `SumExample.java` | รับค่าตัวเลขและแสดงผลรวม |
| `TableFormatExample.java` | แสดงผลข้อมูลแบบตารางโดยใช้ `printf()` |

---

## 🧠 จุดประสงค์ของบทเรียน

- เข้าใจรูปแบบการแสดงผลข้อมูลแบบต่าง ๆ ใน Java
- ฝึกใช้คำสั่ง `print`, `println`, `printf` และ escape characters
- รู้จักการใช้ `Scanner` เพื่อรับค่าหลากหลายประเภท
- เรียนรู้ปัญหาที่เกิดจากการรับข้อมูล และวิธีการจัดการอย่างถูกต้อง

---

## 📝 หมายเหตุ

นักศึกษาสามารถนำโปรแกรมเหล่านี้ไปทดลองแก้ไข และปรับปรุงเพิ่มเติม  
เพื่อฝึกทักษะการแสดงผลข้อมูล และเตรียมพร้อมสำหรับหัวข้อถัดไป เช่น การคำนวณ และการใช้คำสั่งควบคุม

