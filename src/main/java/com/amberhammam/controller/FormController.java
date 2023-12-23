package com.amberhammam.controller;

import com.amberhammam.model.Treatment;
import com.amberhammam.model.Voucher;
import com.amberhammam.service.TreatmentService;
import com.amberhammam.service.VoucherService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/")
public class FormController {
    private final VoucherService voucherService;
    private final TreatmentService treatmentService;

    @Autowired
    public FormController(VoucherService voucherService, TreatmentService treatmentService) {
        this.voucherService = voucherService;
        this.treatmentService = treatmentService;
    }

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("voucher", new Voucher());
        model.addAttribute("treatments", treatmentService.getTreatments().stream().map(Treatment::getName).toArray());
        return "devForm";
    }

    @PostMapping("/generateVoucher")
    public void generateVoucher(Voucher voucher, HttpServletResponse response) throws IOException {
        byte[] pdfContent = voucherService.createPdfVoucher(voucher);

        response.setContentType("application/pdf");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=voucher.pdf";
        response.setHeader(headerKey, headerValue);
        response.getOutputStream().write(pdfContent);
    }
}

