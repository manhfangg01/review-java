package lambdaex;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;

public class LambdaExamples {

    // 1. BIẾN TOÀN CỤC (INSTANCE FIELD)
    // Nằm trên Heap, không cần effectively final
    int instanceCounter = 0;

    // 2. BIẾN TĨNH (STATIC FIELD)
    // Nằm trên Heap, không cần effectively final
    static int staticCounter = 0;

     void main() {
         // --- TRƯỜNG HỢP 1: BIẾN CỤC BỘ (LOCAL VARIABLE) ---
         int localVal = 10;
         // biến mà từ khi được khởi tạo mà không hề bị thay đổi giá trị thì được coi là effectively final
         Runnable r1 = () -> {
             // Có thể đọc localVal vì nó là effectively final (không bị gán lại)
             System.out.println("LocalVal: " + localVal);

             // localVal = 20; // LỖI BIÊN DỊCH: Biến cục bộ dùng trong lambda phải là final/effectively final
         };

         // --- TRƯỜNG HỢP 2: BIẾN TOÀN CỤC (FIELDS) ---
         Runnable r2 = () -> {
             instanceCounter++; // CHẠY NGON: Vì capture tham chiếu 'this'
             staticCounter++;   // CHẠY NGON: Vì truy cập trực tiếp vùng nhớ static
             System.out.println("Instance: " + instanceCounter + ", Static: " + staticCounter);
         };

         // --- TRƯỜNG HỢP 3: MẸO DÙNG MẢNG (ARRAY TRICK) ---
         // Dùng để "lách luật" khi muốn thay đổi giá trị biến cục bộ
         int[] wrapper = {0};
         Runnable r3 = () -> {
             wrapper[0]++; // Hợp lệ: Tham chiếu 'wrapper' không đổi, chỉ nội dung mảng đổi
             System.out.println("Wrapper value: " + wrapper[0]);
         };

         // --- TRƯỜNG HỢP 4: DÙNG ATOMIC (AN TOÀN ĐA LUỒNG) ---
         AtomicInteger atomicInt = new AtomicInteger(0);
         Runnable r4 = () -> {
             int newVal = atomicInt.incrementAndGet(); // Cách chuẩn mực để thay đổi giá trị trong Lambda
             System.out.println("Atomic value: " + newVal);
         };

         // Thực thi thử
         System.out.println("--- Execution ---");
         r1.run();
         r2.run();
         r3.run();
         r4.run();


    }
}
