package lib;
import java.util.ArrayList;

public class ShoppingCartCalculator {

    /**
     * เมธอดทที่ตรวจสอบสินค้า เพื่อนำโปรโมชั่นมาคำนวนกับสินค้าโดยใช้ price,quantity:
     * - ส่งค่ากลับ 0.0 เมื่อ sku เป็น null หรือ empty
     * - คำนวนราคาปกติเมื่อ sku="NORMAL"
     * - คำนวนราคา โปรโมชั่นลดโดยการแถม (ซื้อ 2 จ่าย 1 ,ซื้อ 3 จ่าย 2,ซื้อ 4 จ่าย 2) เมื่อsku="BOGO"
     * - คำนวนราคา โปรโมชั่นลด 10% (เมื่อซื้อ 6 ชิ้นขึ้นไป) sku = "BULK"
     * @param item ประกอบด้วย (sku,name,price,quantity)
     * sku คือ string ของโค้ดสินค้าใช้ตรวจจำแนกการคำนวนสินค้าโปรโมชั่น
     * name คือ ชื่อสินค้า , price คือ ราคาสินค้า , quantity คือ จำนวนสินค้า
     * @return ราคารวมทั้งหมดหลังคำนวนโปรโมชั่น
     */
    public static double calculateTotalPrice(ArrayList<CartItem> items) {
        // TODO: เขียนโค้ด Implementation ที่นี่
        double count1=0,count2=0;
        if( items==null|| items.isEmpty() )
        {return 0.0; }
        else for (CartItem item : items) {
        if (item.sku().equals("NORMAL") ){ //คำนวณปกติ
            if(item.name().equals("Bread")  ) {
            count1 += item.price() * item.quantity(); }
            else if(item.name().equals("Milk"))
            {count2+=item.price() * item.quantity();}}

        if (item.sku().equals("BOGO") ) //ลดราคาจากยการแถม
        {if(item.name().equals("Bread")  ) {
            count1 += item.price() *(Math.ceil(item.quantity()/2.0)); }
            else if(item.name().equals("Milk"))
            {count2+=item.price() *(Math.ceil(item.quantity()/2.0));}
        }
        if (item.sku().equals("BULK") ) //ซื้อ 6 ชิ้นขึ้นไป ลดราคา10%
        {   
           if(item.name().equals("Bread")  ) {
           count1 += item.price() * item.quantity();
            if (item.quantity()>=6) {
          count1-=count1*10/100;}
        }
           else if(item.name().equals("Milk"))
           {count2+=item.price() * item.quantity();
           if (item.quantity()>=6 ) {
            count2-=count2*10/100; }
          }  } }
            return count1+count2;
        
    }
}