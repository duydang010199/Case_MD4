package com.cg.util;

import com.cg.exception.DataInputException;
import com.cg.model.Product;
import com.cg.model.ProductAvatar;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class UploadUtil {

    public static final String PRODUCT_IMAGE_UPLOAD_FOLDER = "product_images";

    public final String IMAGE_UPLOAD_FOLDER = "product_images";
    public final String VIDEO_UPLOAD_FOLDER = "product_videos";

    public Map buildImageUploadParams(ProductAvatar productMedia) {
        if (productMedia == null || productMedia.getId() == null)
            throw new DataInputException("Không thể upload hình ảnh của sản phẩm chưa được lưu");

        String publicId = String.format("%s/%s", IMAGE_UPLOAD_FOLDER, productMedia.getId());

        return ObjectUtils.asMap(
                "public_id", publicId,
                "overwrite", true,
                "resource_type", "image"
        );
    }

    public Map buildImageDestroyParams(Product product, String publicId) {
        if (product == null || product.getId() == null)
            throw new DataInputException("Không thể destroy hình ảnh của sản phẩm không xác định");

        return ObjectUtils.asMap(
                "public_id", publicId,
                "overwrite", true,
                "resource_type", "image"
        );
    }

    public Map buildVideoUploadParams(ProductAvatar productMedia) {
        if (productMedia == null || productMedia.getId() == null)
            throw new DataInputException("Không thể upload video của sản phẩm chưa được lưu");

        String publicId = String.format("%s/%s", VIDEO_UPLOAD_FOLDER, productMedia.getId());

        return ObjectUtils.asMap(
                "public_id", publicId,
                "overwrite", true,
                "resource_type", "video"
        );
    }

    public Map buildVideoDestroyParams(Product product, String publicId) {
        if (product == null || product.getId() == null)
            throw new DataInputException("Không thể destroy video của sản phẩm không xác định");

        return ObjectUtils.asMap(
                "public_id", publicId,
                "overwrite", true,
                "resource_type", "video"
        );
    }
}
