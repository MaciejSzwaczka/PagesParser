
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maciejszwaczka
 */
public class XLSWriter {
   private static XLSWriter instance = null;
   protected XLSWriter() {
      // Exists only to defeat instantiation.
   }
   public static XLSWriter getInstance() {
      if(instance == null) {
         instance = new XLSWriter();
      }
      return instance;
   }
   public static void writeToXLS(List<Product> products,String category)
    {
        File file=new File(category+".xls");
        HSSFWorkbook workbook=new HSSFWorkbook();
        HSSFSheet sheet=workbook.createSheet("data");
        HSSFRow row=sheet.createRow(0);
        row.createCell(0).setCellValue("ID");
        row.createCell(1).setCellValue("Nazwa");
        row.createCell(2).setCellValue("Cena");
        row.createCell(3).setCellValue("Obrazy");
        row.createCell(4).setCellValue("Opis");
        row.createCell(5).setCellValue("Rozmiar");
        row.createCell(6).setCellValue("Sezon");
        row.createCell(7).setCellValue("Kolor");
        int rowNum=1;
        for(Product prod:products)
        {
            row=sheet.createRow(rowNum);
            String sizes="";
            String imgs="";
            for(String size:prod.getSizes())
            {
                if(!sizes.equals("")) {
                    sizes = sizes + "," + size;
                }
                else
                {
                    sizes=size;
                }
            }
            for(String img:prod.getImg())
            {
                if(!imgs.equals("")) {
                    imgs = imgs + "," + img;
                }
                else
                {
                    imgs=img;
                }
            }
            row.createCell(0).setCellValue(prod.getID());
            row.createCell(1).setCellValue(prod.getName());
            row.createCell(2).setCellValue(prod.getPrice());
            row.createCell(3).setCellValue(imgs);
            row.createCell(4).setCellValue(prod.getDescription());
            row.createCell(5).setCellValue(sizes);
            row.createCell(6).setCellValue(prod.getSeason());
            row.createCell(7).setCellValue(prod.getColour());
            rowNum++;
        }
        FileOutputStream fileOutputStream=null;
        OutputStreamWriter outputStreamWriter=null;
        try
        {
            file.createNewFile();
            System.setProperty("file.encoding","UTF-8");

            fileOutputStream = new FileOutputStream(file);
            workbook.write(fileOutputStream);
            fileOutputStream.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
