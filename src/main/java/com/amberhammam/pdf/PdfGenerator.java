package com.amberhammam.pdf;

import com.amberhammam.model.Voucher;

public interface PdfGenerator {
    byte[] generatePdfTreatment(Voucher data);
    byte[] generatePdfValue(Voucher data);

}
