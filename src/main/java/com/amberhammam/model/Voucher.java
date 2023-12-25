package com.amberhammam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voucher {
    String name;
    Treatment treatment;
    Integer selectedValue;
    Integer customValue;

}
