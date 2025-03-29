package dev.it22.kmitl.reg.ui.transcript;

import java.io.*;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.model.auth.Account;
import dev.it22.kmitl.reg.model.auth.Student;

public class Transcript {
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm");

    public static String pdfFilepath =  System.getProperty("user.home") + "/Downloads/transcript_" + dtf.format(LocalDateTime.now()) + ".pdf" ;

    private String name ,
            dateOB ,
            dateOA,
            degree,
            major,
            studentID,
            dateOG = "N/A";

    Font headerFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
    Font tableHeaderFont = new Font(Font.FontFamily.TIMES_ROMAN, 7f, Font.BOLD);
    Font insideHeaderFont = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.BOLD);
    Font insideFooterFont = new Font(Font.FontFamily.TIMES_ROMAN, 7, Font.BOLD);
    Font insideFooterRFont = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.BOLD, BaseColor.RED);
    Font insideFooterNFont = new Font(Font.FontFamily.TIMES_ROMAN, 7, Font.NORMAL);
    Font gradeHeaderFont = new Font(Font.FontFamily.TIMES_ROMAN, 7f, Font.BOLDITALIC);
    Font insideFont = new Font(Font.FontFamily.TIMES_ROMAN, 7, Font.NORMAL);
    Font tableHeader2Font = new Font(Font.FontFamily.TIMES_ROMAN, 5f, Font.BOLD);
    Font photoFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
    Font enterFont = new Font(Font.FontFamily.TIMES_ROMAN, 10.7f, Font.NORMAL);
    Font regularFont = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.NORMAL);
    Font subHeaderFont = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.BOLDITALIC);


    String []semester;
    String [][] subject;
    String[][] subjectNumberList;
    int[][] creditsList;
    String[][] gradeList;

    public Transcript(String name,String dateOB,String dateOA,String degree, String major, String studentID, String[] semester, String [][] subject, String[][] subjectNumberList, int[][] creditsList, String[][] gradeList ) {
        this.name=name;
        this.dateOB=dateOB;
        this.dateOA=dateOA;
        this.degree=degree;
        this.major=major;
        this.studentID=studentID;
        this.semester=semester;
        this.subject=subject;
        this.subjectNumberList=subjectNumberList;
        this.creditsList=creditsList;
        this.gradeList=gradeList;

        Document document = new Document(PageSize.A4, 28.5f, 28.5f, 18.4f, 18.4f);

        String[] subHeaderList = {"Name", "Date of Birth", "Date of Admission", "Degree", "Major"};
        String[] informationList = {name, dateOB, dateOA, degree, major};
        float[] spaceList = {10f, 5.5f, 5.5f, 5.5f, 9f};

        try {
            PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(pdfFilepath));

            document.open();

            Paragraph headerUnOf = new Paragraph("( Unofficial Transcript )", headerFont);
            headerUnOf.setAlignment(Element.ALIGN_CENTER);
            document.add(headerUnOf);
            for (int i = 0; i<4; i++){
                document.add(new Paragraph("\n",enterFont));
            }

            for (int i = 0; i<5; i++){
                Chunk subHeader = new Chunk(subHeaderList[i], subHeaderFont);
                Chunk text = new Chunk(informationList[i], regularFont);
                Chunk space = new Chunk(" ", regularFont);
                space.setWordSpacing(spaceList[i]);
                Paragraph eachLine = new Paragraph();
                eachLine.add(subHeader);
                eachLine.add(space);
                eachLine.add(text);
                eachLine.setIndentationLeft(2.7f);
                if (subHeaderList[i].equals("Date of Birth") || subHeaderList[i].equals("Date of Admission")){
                    Chunk sepSpace = new Chunk(" ", subHeaderFont);
                    if (subHeaderList[i].equals("Date of Birth")){
                        subHeader = new Chunk("Student ID", subHeaderFont);
                        text = new Chunk(studentID, regularFont);
                        space = new Chunk(" ", subHeaderFont);
                        space.setWordSpacing(13.5f);
                        for (int k = 0; k<94 - (informationList[i].length()*2); k++){
                            eachLine.add(sepSpace);
                        }
                    }
                    else if(subHeaderList[i].equals("Date of Admission")){

                        subHeader = new Chunk(" Date of Graduation", subHeaderFont);
                        text = new Chunk(dateOG, regularFont);
                        space = new Chunk(" ", subHeaderFont);
                        space.setWordSpacing(10.5f);
                        sepSpace.setWordSpacing(162);

                    }
                    eachLine.add(sepSpace);
                    eachLine.add(subHeader);
                    eachLine.add(space);
                    eachLine.add(text);
                }

                if (i!=4){
                    eachLine.setSpacingAfter(-2.4f);
                }
                else {
                    eachLine.setSpacingAfter(4f);
                }
                document.add(eachLine);
                }


            PdfContentByte canvas = pdfWriter.getDirectContent();

            float rightMargin = PageSize.A4.getWidth()-85;
            float topMargin = PageSize.A4.getHeight()-123.5f;
            canvas.setLineWidth(0.58f);
            canvas.rectangle(rightMargin, topMargin, 62.5f, 68);
            canvas.stroke();

            ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, new Phrase("Photo",photoFont), rightMargin + 62.5f / 2f, topMargin + 61 / 2f, 0);

            PdfPTable table = new PdfPTable(6);
            table.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.getDefaultCell().setNoWrap(true);
            table.setWidthPercentage(new float[]{250.5f,25f, 25f, 250.5f, 25f, 25f}, PageSize.A4);


            PdfPCell creditCell = createHeaderCell("CREDIT", tableHeader2Font,3.5f);
            PdfPCell gradeCell = createHeaderCell("GRADE", tableHeader2Font,3.5f);
            PdfPCell courseCell = createHeaderCell("COURSE TITLE", tableHeaderFont,2.5f);

            table.addCell(courseCell);
            table.addCell(creditCell);
            table.addCell(gradeCell);
            table.addCell(courseCell);
            table.addCell(creditCell);
            table.addCell(gradeCell);


            table.addCell(createSubjectCell());
            table.addCell(createSubjectCell(7, "credit"));
            table.addCell(createSubjectCell(7, "grade"));
            table.addCell("");
            table.addCell("");
            table.addCell("");
            table.addCell("");

            document.add(table);

            LocalDateTime ldt = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM dd, yyyy", Locale.ENGLISH);
            Chunk date = new Chunk("Date ", insideFooterFont);
            Chunk issue = new Chunk("Issued: ", insideFooterFont);
            issue.setWordSpacing(10.5f);

            Chunk nowDate = new Chunk(ldt.format(dtf), insideFooterNFont);
            nowDate.setUnderline(0.3f,-1);

            Chunk space = new Chunk(" ", insideFooterFont);
            space.setWordSpacing(89f);

            Chunk unoff = new Chunk("This document is unofficial transcript.", insideFooterFont);

            Paragraph footer = new Paragraph();
            footer.add(date);
            footer.add(issue);
            footer.add(nowDate);
            footer.add(space);
            footer.add(unoff);
            footer.setSpacingBefore(-5f);
            footer.setIndentationLeft(13f);
            document.add(footer);

            footer = new Paragraph("This is unofficial transcript use for OOP project presentation only!!", insideFooterRFont);
            footer.setAlignment(Element.ALIGN_CENTER);
            footer.setSpacingBefore(10f);
            document.add(footer);

            document.close();
            System.out.println("Student ID: ");
        }catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        }
    }

    private PdfPCell createHeaderCell(String text, Font font, float padding) {
        PdfPCell cell = new PdfPCell(new Phrase(text,font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPaddingTop(padding);
        cell.setNoWrap(true);
        cell.setFixedHeight(14);
        return cell;
    }

    private PdfPCell createSubjectCell(){
        PdfPCell cell = new PdfPCell();
        cell.setPaddingTop(-5);
        cell.setNoWrap(true);
        for (int i = 0; i<subject.length; i++){
            Chunk underLText = new Chunk(semester[i], insideHeaderFont);
            underLText.setUnderline(0.3f, -1);
            Paragraph semesterP = new Paragraph("                              ", insideHeaderFont);
            semesterP.add(underLText);
            //semesterP.setAlignment(Element.ALIGN_CENTER);
            cell.addElement(semesterP);
            for (int j = 0; j<subject[i].length; j++) {
                Chunk subjectNumber = new Chunk(subjectNumberList[i][j] + " ", insideFont);
                subjectNumber.setWordSpacing(4f);
                Chunk subjectChunk = new Chunk(subject[i][j], insideFont);
                Paragraph subjectP = new Paragraph();
                subjectP.add(subjectNumber);
                subjectP.add(subjectChunk);
                subjectP.setSpacingBefore(-5f);
                subjectP.setSpacingAfter(-0.25f);
                subjectP.setIndentationLeft(1f);
                cell.addElement(subjectP);
            }
            Paragraph gradeP = new Paragraph("GPS : 3.75          GPA : 3.75", gradeHeaderFont);
            gradeP.setIndentationLeft(70.5f);
            cell.addElement(gradeP);
        }
        footerFormat(cell,"Total  number of credit earned:  21\n",11f, insideFooterFont, 35f);

        footerFormat(cell,"Cumulative GPA:  3.75", insideFooterFont, 52.8f);

        footerFormat(cell,"-------------------------------- Transcript Closed --------------------------------", 0.1f, gradeHeaderFont);

        footerFormat(cell,"Checked by   ______________________________________________", 11f, insideFooterNFont, 22f);

        footerFormat(cell,  "(Xx Xxxxxxxxx Xxxxxxxxxxxxx)", insideFooterNFont, 125f);

        return cell;
    }

    private void footerFormat(PdfPCell cell, String text, float spaceBefore, Font font, float indentLeft) {
        Paragraph footerP = new Paragraph(text, font);
        footerP.setSpacingBefore(spaceBefore);
        footerP.setIndentationLeft(indentLeft);
        cell.addElement(footerP);
    }

    private void footerFormat(PdfPCell cell, String text, Font font, float indentLeft) {
        footerFormat(cell, text, 0f, font, indentLeft);
    }

    private void footerFormat(PdfPCell cell, String text, float spaceBefore, Font font) {
        footerFormat(cell, text, spaceBefore, font, 0f);
    }

    private PdfPCell createSubjectCell(float leftIndent, String type){
        PdfPCell cell = new PdfPCell();
        cell.setPaddingTop(-4.6f);
        cell.setNoWrap(true);
        for (int i = 0; i<subject.length; i++){
            Chunk enterChunk = new Chunk(" ", insideHeaderFont);
            Paragraph semesterP = new Paragraph(enterChunk);
            semesterP.setSpacingAfter(0.25f);
            //semesterP.setAlignment(Element.ALIGN_CENTER);
            cell.addElement(semesterP);
            for (int j = 0; j<subject[i].length; j++) {
                Paragraph subjectP = new Paragraph();
                if (type.equals("credit")) {
                    subjectP = new Paragraph(creditsList[i][j] + "", insideFont);
                    subjectP.setIndentationLeft(leftIndent +0.5f);
                }
                else if (type.equals("grade")) {
                    try {
                        subjectP = new Paragraph(gradeList[i][j], insideFont);
                    }
                    catch (ArrayIndexOutOfBoundsException e) {
                        subjectP = new Paragraph("", insideFont);
                    }
                    subjectP.setIndentationLeft(leftIndent-1.5f);
                }
                subjectP.setSpacingAfter(0.18f);
                cell.addElement(subjectP);
            }
            Paragraph gradeP = new Paragraph(" ", gradeHeaderFont);
            cell.addElement(gradeP);
        }
        return cell;
    }

    private PdfPCell createCreditCell(String text, Font font, float padding) {
        PdfPCell cell = new PdfPCell(new Phrase(text,font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPaddingTop(padding);
        cell.setNoWrap(true);
        return cell;
    }
}
