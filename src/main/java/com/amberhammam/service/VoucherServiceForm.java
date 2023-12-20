package com.amberhammam.service;

import com.amberhammam.model.Voucher;
import com.amberhammam.pdf.PdfGenerator;
import org.springframework.stereotype.Service;

@Service
public class VoucherServiceForm implements VoucherService {
    private final PdfGenerator pdfGenerator;

    public VoucherServiceForm(PdfGenerator pdfGenerator) {
        this.pdfGenerator = pdfGenerator;
    }

    @Override
    public byte[] createPdfVoucher(Voucher voucher) {
        if (voucher.getTreatment() != null)
            return pdfGenerator.generatePdfTreatment(voucher);
        else if (voucher.getValue() != null)
            return pdfGenerator.generatePdfValue(voucher);
        else
            throw new IllegalArgumentException("Nieprawidłowy voucher");
    }
}
