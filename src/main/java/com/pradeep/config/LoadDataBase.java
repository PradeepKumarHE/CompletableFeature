package com.pradeep.config;

import com.pradeep.entity.Product;
import com.pradeep.service.ProductService;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class LoadDataBase implements CommandLineRunner {

    private static final String FILE_LOCATION = "/home/pradeep/Data_folder/Bala.xlsx";
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    ProductService productService;
    
    @Override
    public void run(String... args) throws Exception {
        Workbook workbook =null;
        DataFormatter dataFormatter = new DataFormatter();
        List<Product> productList=new ArrayList<>();
        try {
            workbook = WorkbookFactory.create(new File(FILE_LOCATION));
            workbook.forEach(sheet -> {
                int index = 0;
                for(Row row : sheet) {
                    if(index++ == 0) continue;
                    Product product=new Product();
                    product.setProductId( (row.getCell(0)==null)?null: (long)row.getCell(0).getNumericCellValue());
                    product.setAlert_Id((row.getCell(1)==null)?null:  (long)row.getCell(1).getNumericCellValue());
                    product.setK((row.getCell(2)==null)?null: row.getCell(2).getStringCellValue());
                    product.setDescription((row.getCell(3)==null)?null: row.getCell(3).getStringCellValue());
                    product.setClassification((row.getCell(4)==null)?null: row.getCell(4).getStringCellValue());
                    product.setEvent((row.getCell(5)==null)?null: row.getCell(5).getStringCellValue());
                    product.setProductDefect((row.getCell(6)==null)?null: row.getCell(6).getStringCellValue());
                    product.setDrugSlashProduct(row.getCell((row.getCell(7)==null)?null:7).getStringCellValue());
                    product.setIdentifiableRef((row.getCell(8)==null)?null: row.getCell(8).getStringCellValue());
                    product.setUrl((row.getCell(9)==null)?null:row.getCell(9).getStringCellValue());
                    product.setPublishedDate(row.getCell(10).getDateCellValue());
                    product.setSource_type((row.getCell(11)==null)?null:row.getCell(11).getStringCellValue());
                    product.setLanguage((row.getCell(12)==null)?null:row.getCell(12).getStringCellValue());
                    product.setCountry((row.getCell(13)==null)?null:row.getCell(13).getStringCellValue());
                    product.setFavorite((row.getCell(14)==null)?null:(int)row.getCell(14).getNumericCellValue());
                    product.setNegative((row.getCell(15)==null)?null:row.getCell(15).getStringCellValue());
                    product.setSource_name((row.getCell(16)==null)?null:row.getCell(16).getStringCellValue());
                    product.setSource_url((row.getCell(17)==null)?null:row.getCell(17).getStringCellValue());
                    product.setParent_url((row.getCell(18)==null)?null:row.getCell(18).getStringCellValue());
                    product.setParentId((row.getCell(19)==null)?null:(long)row.getCell(19).getNumericCellValue());
                    product.setChildren((row.getCell(20)==null)?null:(int)row.getCell(20).getNumericCellValue());
                    product.setDirect_rea((row.getCell(21)==null)?null:(int)row.getCell(21).getNumericCellValue());
                    product.setCumulative((row.getCell(22)==null)?null:(int)row.getCell(22).getNumericCellValue());
                    product.setDomain_n((row.getCell(23)==null)?null:row.getCell(23).getStringCellValue());
                    product.setTags((row.getCell(24)==null)?null:row.getCell(24).getStringCellValue());
                    product.setScore((row.getCell(25)==null)?null:(int)row.getCell(25).getNumericCellValue());
                    product.setAlert_name((row.getCell(26)==null)?null:row.getCell(26).getStringCellValue());

                    productList.add(product);
                }
            });

            productService.saveProducts(productList);
        }catch (Exception e) {
           e.printStackTrace();
        }
    }
}
