package com.cg.model.dto.product;

import com.cg.model.Product;
import com.cg.model.ProductAvatar;
import com.cg.model.dto.productAvatar.ProductAvatarDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.Size;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductCreateDTO implements Validator {
    private Long id;
    @NotEmpty(message = "Vui lòng nhập tên sản phẩm.")
    @Size(min = 5, max = 100, message = "Họ tên có độ dài từ 5 - 100 ký tự.")
    private String productName;

    @NotEmpty(message = "Bạn không được để trống giá .")
    private String price;

    @NotEmpty(message = "Bạn không được để trống số lượng .")
    private String quantity;
    @NotEmpty(message = "Xin vui lòng nhập mô tả sản phẩm.")
    private String description;

    MultipartFile file;

    private String fileType;

    public Product toProduct(ProductAvatar productAvatar){
        return new Product()
                .setId(id)
                .setProductName(productName)
                .setPrice(new BigDecimal(Long.parseLong(price)))
                .setQuantity(Integer.parseInt(quantity))
                .setDescription(description)
                .setProductAvatar(productAvatar);
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return ProductCreateDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductCreateDTO productCreateDTO = (ProductCreateDTO) target;
        String price = productCreateDTO.getPrice();
        if (price != null && price.length() > 0) {
            if (price.length() > 9){
                errors.rejectValue("price", "price.max","Giá sản phẩm tối đa là 999.999.999 $ ,vui lòng nhập lại giá sản phẩm.");
                return;
            }

            if (price.length() < 3){
                errors.rejectValue("price", "price.min","Giá sản phẩm thấp nhất là 100 $, vui lòng nhập lại giá sản phẩm.");
                return;
            }

            if (!price.matches("(^$|[0-9]*$)")){
                errors.rejectValue("price",  "price.number","Giá sản phẩm phải là số ,vui lòng nhập lại giá sản phẩm.");
                return;
            }

        } else {
            errors.rejectValue("price",  "price.null", "Sản phẩm không được để trống ,vui lòng nhập giá sản phẩm.");
        }

        String quantity = productCreateDTO.getQuantity();
        if (quantity != null && quantity.length() > 0) {
            if (quantity.length() > 6){
                errors.rejectValue("quantity", "quantity.max","Số lượng sản phẩm tối đa là 999.999 ,vui lòng nhập lại giá sản phẩm." );
                return;
            }

            if (!quantity.matches("(^$|[0-9]*$)")){
                errors.rejectValue("quantity",  "quantity.number","Số lượng sản phẩm phải là số ,vui lòng nhập lại giá sản phẩm..");
                return;
            }
            Long quantityLong = Long.parseLong(quantity);
            if (quantityLong < 0){
                errors.rejectValue("quantity", "quantity.min","Số lượng sản phẩm không thể âm , vui lòng nhập giá sản phẩm.");
            }
        } else {
            errors.rejectValue("quantity",  "quantity.null", "Vui lòng nhập số lượng sản phẩm, vui lòng nhập giá sản phẩm..");
        }
    }
}
