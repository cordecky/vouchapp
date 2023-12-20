package com.amberhammam.service;

import com.amberhammam.model.Voucher;

public interface VoucherService {
    byte[] createPdfVoucher(Voucher voucher);
}
