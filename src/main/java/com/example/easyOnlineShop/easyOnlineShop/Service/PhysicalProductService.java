package com.example.easyOnlineShop.easyOnlineShop.Service;


import com.example.easyOnlineShop.easyOnlineShop.Dto.PhysicalProductDTO;

import java.util.List;

public interface PhysicalProductService {
    List<PhysicalProductDTO> findAllPhysicalProducts();

    String  addPhysicalProduct(PhysicalProductDTO physicalProductDTO);

    String editPhysicalProduct(PhysicalProductDTO physicalProductDTO);

}
