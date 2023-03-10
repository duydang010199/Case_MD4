package com.cg.service.product;

import com.cg.model.Product;
import com.cg.model.dto.product.ProductCreateDTO;
import com.cg.model.dto.product.ProductDTO;
import com.cg.service.IGeneralService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface IProductService extends IGeneralService<Product> {
    List<ProductDTO> getAllProductDTO();

    boolean existsByProductName(String productName);

    boolean existsByProductNameAndIdNot(String productName, Long id);

    Product createWithAvatar(ProductCreateDTO productCreateDTO);

    Product saveWithAvatar(Product product, MultipartFile file);

    void softDelete(Long staffId);
}
