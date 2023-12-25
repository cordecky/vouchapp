package com.amberhammam.pdf;

import com.amberhammam.model.Voucher;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;

@Slf4j
@Primary
@Component
public class PdfGeneratorSimple implements PdfGenerator {

    @Override
    public byte[] generatePdfTreatment(Voucher data) {
        Document document = new Document();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, baos);
            document.open();

            document.add(new Paragraph("Voucher"));
            document.add(new Paragraph("Dla: " + data.getName()));
            document.add(new Paragraph("Rodzaj zabiegu: " + data.getTreatment().getName()));
            document.close();
        } catch (Exception e) {
            log.error("Error while generating pdf", e);
        }

        return baos.toByteArray();
    }

    @Override
    public byte[] generatePdfValue(Voucher data) {
        Document document = new Document();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, baos);
            document.open();

            document.add(new Paragraph("Voucher"));
            document.add(new Paragraph("Dla: " + data.getName()));
            document.add(new Paragraph("Wartość vouchera: " + (
                    data.getSelectedValue() != null ? data.getSelectedValue() : data.getCustomValue()
            )));

            document.close();
        } catch (Exception e) {
            log.error("Error while generating pdf", e);
        }

        return baos.toByteArray();
    }
}
