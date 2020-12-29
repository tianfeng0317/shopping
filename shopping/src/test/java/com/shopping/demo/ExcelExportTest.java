package com.shopping.demo;

import com.shopping.demo.product.dto.ProductDTO;
import com.shopping.demo.utils.ExportExcelUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author :tianfeng
 * @Date : 2020/12/22 17:31
 * @Description:
 */
public class ExcelExportTest {

    public static void main(String[] args) {

        ExportExcelUtils<ProductDTO> util = new ExportExcelUtils<ProductDTO>();

        List<ProductDTO> productDTOS = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setProductId("12fcdskj1231" + i);
            productDTO.setProductName("饼干" + i);
            productDTO.setProductNumber("" + i ++);
            productDTOS.add(productDTO);
        }
        String[] columnNames = {"商品Id", "商品名称", "商品数量"};
        try {
            String fileName="测试.xlsx";
//            util.exportExcel("各局自营餐情况报表", columnNames, productDTOS, new FileOutputStream("/home/catering/orderschedule/excelFile/"+fileName), ExportExcelUtils.EXCEl_FILE_2007);
            util.exportExcel("统计商品Test", columnNames, productDTOS, new FileOutputStream("D:/aaaa/"+fileName), ExportExcelUtils.EXCEl_FILE_2007);
            System.out.println("导出excel成功");
            System.out.println("导出excel");
            String filePath = "D:/aaaa/测试.xlsx";
            System.out.println(filePath);
            readTxt(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void readTxt(String filePath) {
        try {
            File file = new File(filePath);
            if(file.isFile() && file.exists()) {
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
                BufferedReader br = new BufferedReader(isr);
                String lineTxt = null;
                int num =0;
                long time1 = System.currentTimeMillis();
                while ((lineTxt = br.readLine()) != null) {
                    System.out.println(lineTxt);
                    num++;
                    System.out.println("总共"+num+"条数据！");
                }
                //System.out.println("总共"+num+"条数据！");
                long time2 = System.currentTimeMillis();
                long time = time1 - time2;
                System.out.println("共花费"+time+"秒");
                br.close();
            } else {
                System.out.println("文件不存在!");
            }
        } catch (Exception e) {
            System.out.println("文件读取错误!");
        }
    }
}
