package Tests;

import Pages.ConcortHotelPage;
import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

/*
    Web sayfasinda webelementleri duzenlemek icin HTML tablo oluşturabiliriz
    HTML tablo farkli sekillerde olusturulabilir ama genellikle <table>, <theader>,
    <tbody>, <tr>, <th> ve <td> attribute’leri kullanılır.
 */
public class WebTables {

    /*  -- Bir class oluşturun : WebTables
        -- login( ) metodun oluşturun ve oturum açın.
        https://www.concorthotel.com/ adresine gidin
        Username : manager
        Password : Manager1!
        -- tableListOfUsers( ) metodu oluşturun
        -- Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        -- Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.

        -- printRows( ) metodu oluşturun //tr
        -- table body’sinde bulunan toplam satir(row) sayısını bulun.
        -- Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        -- 4.satirdaki(row) elementleri konsolda yazdırın.

    */
    ConcortHotelPage  concortHotelPage=new ConcortHotelPage();
    @Test
    public  void  login( ){
        //Programı daha dinamik hale getirmek için oturumu methodla yapalım.
        concortHotelPage.loginConcortHotel();
    }
    @Test(dependsOnMethods = "login")
    public  void  tableListOfUsers( ){
   /* Aşağıdaki gibi sadece Webelement şeklinde getText() ile yazdırabiliriz. Ya da
   List'te atayıp her değeri for-each ile tek tek alırız..
   */
       // -- Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody

        System.out.println(concortHotelPage.tableTbody.getSize());
       // -- Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.

        System.out.println(concortHotelPage.tableTbody.getText());
        System.out.println(concortHotelPage.tableColumns.getText());


    }
    @Test(dependsOnMethods = "tableListOfUsers")
    public  void  printRows( ) {
   //tbody//tr
        System.out.println(concortHotelPage.tableRow.size());
        List<WebElement> tableRow=concortHotelPage.tableRow;
        for (WebElement w: tableRow
             ) {
            System.out.println(w.getText());
        }
        System.out.println("4. Satır : "+tableRow.get(3).getText());
        Driver.closeDriver();
    }


}
