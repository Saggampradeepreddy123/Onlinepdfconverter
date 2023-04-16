package com.test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
public class ConvertTxtFileToPdf{
    public static void main(String[] args){

        FileInputStream fis=null;
        DataInputStream in =null;
        InputStreamReader isr=null;
        BufferedReader br=null;
        File sourceFile =new File("C:\Users\sagga\OneDrive\Desktop\abc.txt");
        File destFile =new File("C:\Users\sagga\OneDrive\Desktop\abc.pdf");

        try{
            com.itextpdf.text.Document pdfDoc =new com.itextpdf.text.Document();
            pdfWriter writer =Pdfwriter.getInstance(pdfDoc,new FileOutputStream(destFile));
            pdfDoc.open();
            pdfDoc.setMarginMirroring(true);
            pdfDoc.setMarginMirroring(36,72,108,180);
            pdfDoc.topMargin();


            BaseFont courier =BaseFont.createFont(BaseFont.COURIER,
            BaseFont.CP1252,BaseFont.EMBEDDED);
            Font myfont=new Font(courier);



            Font bold_font=new Font();


            bold_font.setStyle(Font.BOLD);
            bold_font.setSize(10);


            myfont.setStyle(Font.NORMAL);
            myfont.setSize(9);

            pdfDoc.add(new com.itextpdf.text.Paragraph("\n"));


            if(sourceFile.exists()){
                fis = new FileInputStream(sourceFile);
                in = new DataInputStream(fis);
                isr = new InputStreamReader(in);
                br = new BufferedReader(isr);

                String strLine;
                while((strLine =br.readLine())!=null){
                    com.itextpdf.text.Paragraph para =new com.itextpdf.text.Paragraph(strLine + "\n" ,myfont);
                    para.setAlignment(Element.ALIGN_JUSTIFIED);
                    pdf.Doc.add(para);
                
                }
                System.out.println("txt file converted to pdf successfully");
            }
            else{
                System.out.println("no file exists!");

            }
            pdfDoc.close();
        }
        catch(Exception ex){
            System.out.println("Error :1:" + ex.getmeassage());
        }
        finally{
            try{
                if(br!=null){
                    br.close();

                }
                if(fis!=null){
                    fis.close();

                }
                if(in !=null){
                    in.close();

                }
                if(isr!=null){
                    isr.close();
                }
            }
            catch(Exception ex){
                System.out.println("error :2:" + ex.getmessage());
            }
        }


            }




        }
    

    }





}
