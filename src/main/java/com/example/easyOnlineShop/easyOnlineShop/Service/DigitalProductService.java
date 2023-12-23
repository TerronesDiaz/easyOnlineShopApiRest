package com.example.easyOnlineShop.easyOnlineShop.Service;


import com.example.easyOnlineShop.easyOnlineShop.Dto.DigitalProductDTO;

import java.util.List;

public interface DigitalProductService {
    List<DigitalProductDTO> findAllDigitalProducts();

    String  addDigitalProduct(DigitalProductDTO physicalProductDTO);

    String editDigitalProduct(DigitalProductDTO physicalProductDTO);

}
