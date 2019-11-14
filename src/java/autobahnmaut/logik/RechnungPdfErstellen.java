/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobahnmaut.logik;

import autobahnmaut.datenbank.UserManager;
import autobahnmaut.model.Rechnung;
import autobahnmaut.model.Rechnungsfahrten;
import autobahnmaut.model.Rechnungsposition;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


/**
 *
 * @author 17wi1188
 */
public class RechnungPdfErstellen {

    public static final String PDF = "/Users/17wi1188/Documents/document.pdf";

    public void createPdf(String filename) throws DocumentException,
            IOException {
        Date monat = Calendar.getInstance().getTime();

        Rechnung rechnung = new Rechnung();
        rechnung = UserManager.rechnungsdaten(3, monat);

        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document,
                new FileOutputStream(filename));
        document.open();

        PdfContentByte cb = writer.getDirectContent();
        BaseFont bf = BaseFont.createFont();
        //setImage(cb, "img/memory.png", 40); 
        
        String rechnungHead= "Rechnung "+rechnung.getNutzer().getName();
        
        document.add(getImage());
        document.add(getTitelHead(rechnungHead));
        
        ArrayList<Rechnungsposition> rpL = rechnung.getRechnungspostionsListe();
        
        for (Rechnungsposition rp : rpL) {
            document.add(getTitel(rp.getKennzeichen()));
            document.add(createTable(rp));
        }
        document.close();
        
        
//        for (Rechnungsposition rp : rpL){
//            System.out.println(rp.getKennzeichen());
//            ArrayList<Rechnungsfahrten> rfL = rp.getRechnungsfahrtenListe();
//            for (Rechnungsfahrten rf : rfL){
//            System.out.println(rf.getEndOrt());
//            
//        }
//        }

    }

    private PdfPTable createTable(Rechnungsposition rp) throws DocumentException {
        ArrayList<Rechnungsfahrten> rfL = new ArrayList<>();
        rfL = rp.getRechnungsfahrtenListe();
        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100);
        table.setSpacingAfter(10f);
        table.setSpacingBefore(15f);
        table.setWidths(new float[]{2f, 2f, 2f, 2f, 2f, 2f});
        Font fontHeader = new Font(Font.FontFamily.COURIER, 7, Font.BOLD, BaseColor.DARK_GRAY);
        PdfPCell headerCell = new PdfPCell(new Phrase("AUFFAHRTSZEIT", fontHeader));
        headerCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        headerCell.setPaddingBottom(5f);
        table.addCell(headerCell);

        headerCell = new PdfPCell(new Phrase("AUFFAHRTSORT", fontHeader));
        headerCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        headerCell.setPaddingBottom(5f);
        table.addCell(headerCell);

        headerCell = new PdfPCell(new Phrase("ABFAHRTSZEIT", fontHeader));
        headerCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        headerCell.setPaddingBottom(5f);
        table.addCell(headerCell);

        headerCell = new PdfPCell(new Phrase("ABFAHRTSORT", fontHeader));
        headerCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        headerCell.setPaddingBottom(5f);
        table.addCell(headerCell);

        headerCell = new PdfPCell(new Phrase("KM", fontHeader));
        headerCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        headerCell.setPaddingBottom(5f);
        table.addCell(headerCell);

        headerCell = new PdfPCell(new Phrase("PREIS", fontHeader));
        headerCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        headerCell.setPaddingBottom(5f);
        table.addCell(headerCell);

        for (Rechnungsfahrten rf : rfL) {
            System.out.println("Fahrt hinzu Rechnung");
            Date date = rf.getStartZeitpunkt();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String startDate = dateFormat.format(date);
            
            Date date2 = rf.getStartZeitpunkt();
            String startDate2 = dateFormat.format(date2);
            
               
            table.addCell(startDate);
            table.addCell(rf.getStartOrt());
            table.addCell(startDate2);
            table.addCell(rf.getEndOrt());
            System.out.println(rf.getEndOrt());
            table.addCell(rf.getKilometer()+"");
            table.addCell("Preis");
        }

        return table;
    }

    private Chunk getTitel(String titel){
        // Title        
        Font titleFont = new Font(Font.FontFamily.COURIER, 22, Font.BOLD, BaseColor.WHITE);
        Chunk titleObj = new Chunk(titel, titleFont);
        titleObj.setBackground(new BaseColor(33, 33, 233), 1f, 1f, 1f, 3f);        
        return titleObj;
    }
    
    private Chunk getTitelHead(String titel){
        // Title        
        Font titleFont = new Font(Font.FontFamily.COURIER, 22, Font.BOLD, BaseColor.WHITE);
        Chunk titleObj = new Chunk(titel, titleFont);
        titleObj.setBackground(new BaseColor(33, 33, 233), 1f, 1f, 1f, 3f);        
        return titleObj;
    }
    private Image getImage()
            throws MalformedURLException, IOException, DocumentException {
        String imagePath = "C:\\Users\\17wi1188\\Documents\\NetBeansProjects\\Autobahnmaut\\src\\java\\autobahnmaut\\logik\\RechnungIcon.PNG";
        Image img = Image.getInstance(imagePath);
        img.setAbsolutePosition(415, 650);
        img.scaleAbsolute(128f, 163f);
        
        return img;
    }

    private void printMeasures() {
        System.out.println("A4-Ma\u00DFe: " + PageSize.A4.getWidth() + "pt x "
                + PageSize.A4.getHeight() + "pt - "
                + (PageSize.A4.getWidth() * 0.3527) + "mm x "
                + (PageSize.A4.getHeight() * 0.3527) + "mm");
    }

    public static void main(String[] args) throws DocumentException,
            IOException {
        RechnungPdfErstellen ps = new RechnungPdfErstellen();
        ps.createPdf(PDF);
        ps.printMeasures();
        System.out.println("done");
    }
}
