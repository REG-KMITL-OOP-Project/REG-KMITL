package dev.it22.kmitl.reg.ui.transcript;

import java.io.*;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;

public class Transcript {
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm");

    private static final String PDF_FILEPATH =  System.getProperty("user.home") + "/Downloads/transcript_" + dtf.format(LocalDateTime.now()) + ".pdf" ;

    private String name, dateOB, dateOA, degree, major, studentID, dateOG;

    Font headerFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
    Font tableHeaderFont = new Font(Font.FontFamily.TIMES_ROMAN, 7.5f, Font.BOLD);
    Font insideHeaderFont = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.BOLD);
    Font gradeHeaderFont = new Font(Font.FontFamily.TIMES_ROMAN, 7f, Font.BOLDITALIC);
    Font insideFont = new Font(Font.FontFamily.TIMES_ROMAN, 7, Font.NORMAL);
    Font tableHeader2Font = new Font(Font.FontFamily.TIMES_ROMAN, 5f, Font.BOLD);
    Font photoFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
    Font enterFont = new Font(Font.FontFamily.TIMES_ROMAN, 10.7f, Font.NORMAL);
    Font regularFont = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.NORMAL);
    Font subHeaderFont = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.BOLDITALIC);

    public Transcript() {
        Document document = new Document(PageSize.A4, 28.5f, 28.5f, 18.4f, 18.4f);

        name = "Mr. Asitara  Phumdokmai";
        dateOB = "July 14, 2006";
        dateOA = "2024";
        degree = "Bachelor of Science";
        major = "Information Technology";
        studentID = "67070199";
        dateOG = "N/A";

        String[] subHeaderList = {"Name", "Date of Birth", "Date of Admission", "Degree", "Major"};
        String[] informationList = {name, dateOB, dateOA, degree, major};
        float[] spaceList = {10f, 5.5f, 5.5f, 5.5f, 9f};

        try {
            PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(PDF_FILEPATH));

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
                        text = new Chunk("N/A", regularFont);
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


            table.addCell(createSubjectCell(0));
            table.addCell(createCreditCell(" \n3", insideFont, 0));
            table.addCell("");
            table.addCell("");
            table.addCell("");
            table.addCell("");


            document.add(table);

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

    private PdfPCell createSubjectCell(float padding){
        String []semester = {"1st Semester, Year, "+Integer.valueOf(dateOA) +"-"+ (Integer.valueOf(dateOA)+1), "2nd Semester, Year, "+(Integer.valueOf(dateOA)) +"-"+ (Integer.valueOf(dateOA)+1),
                "1st Semester, Year, "+Integer.valueOf(dateOA+1) +"-"+ (Integer.valueOf(dateOA)+2), "2nd Semester, Year, "+(Integer.valueOf(dateOA)+1) +"-"+ (Integer.valueOf(dateOA)+2),
                "1st Semester, Year, "+Integer.valueOf(dateOA+2) +"-"+ (Integer.valueOf(dateOA)+3), "2nd Semester, Year, "+(Integer.valueOf(dateOA)+2) +"-"+ (Integer.valueOf(dateOA)+3),
                "1st Semester, Year, "+Integer.valueOf(dateOA+3) +"-"+ (Integer.valueOf(dateOA)+4), "2nd Semester, Year, "+(Integer.valueOf(dateOA)+3) +"-"+ (Integer.valueOf(dateOA)+4)};
        String [][] subject = {{"MATHEMATICS FOR INFORMATION TECHNOLOGY", "INFORMATION TECHNOLOGY FUNDAMENTALS", "INTRODUCTION TO COMPUTER SYSTEMS", "PROBLEM SOLVING AND COMPUTER PROGRAMMING", "CHARM SCHOOL", "FOUNDATION ENGLISH 1", "FOUNDATION ENGLISH 2"},
                {"OBJECT-ORIENTED PROGRAMMING", "PROBABILITY AND STATISTICS"}};
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
                Chunk subjectChunk = new Chunk(subject[i][j], insideFont);
                Paragraph subjectP = new Paragraph(subjectChunk);
                cell.addElement(subjectP);
            }
            Paragraph gradeP = new Paragraph("                                         GPS : 3.75          GPA : 3.75", gradeHeaderFont);
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

    public static void main(String[] args) {
        new Transcript();
    }
}
