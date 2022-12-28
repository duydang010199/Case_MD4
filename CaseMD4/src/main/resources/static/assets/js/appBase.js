class AppBase {
    static DOMAIN_SERVER = "http://localhost:8097";
    static CUSTOMER_API = this.DOMAIN_SERVER + "/api/customers";
    static PROVINCE_URL = "https://vapi.vnappmob.com/api/province/";

    static API_PRODUCT = this.DOMAIN_SERVER + '/api/products';

    static SERVER_CLOUDINARY = "https://res.cloudinary.com";
    static CLOUDINARY_NAME = "/dp0z9sav0";
    static CLOUDINARY_SCALE_450_350 = "c_limit,w_450,h_350,q_100";
    static CLOUDINARY_SCALE_120_100 = "c_limit,w_120,h_100,q_100";
    static CLOUDINARY_SCALE_280_200 = "c_limit,w_280,h_200,q_100";

    static CLOUDINARY_URL = this.SERVER_CLOUDINARY + this.CLOUDINARY_NAME + '/image/upload';

    static AlertMessageEn = class {
        static SUCCESS_CREATED = "Successful data generation !";
        static SUCCESS_UPDATED = "Data update successful !";
        static SUCCESS_DEACTIVATE = "Deactivate the customer successfully !";

        static ERROR_400 = "The operation failed, please check the data again.";
        static ERROR_401 = "Unauthorized - Your access token has expired or is not valid.";
        static ERROR_403 = "Forbidden - You are not authorized to access this resource.";
        static ERROR_404 = "Not Found - The resource has been removed or does not exist";
        static ERROR_500 = "Internal Server Error - The server system is having problems or cannot be accessed.";

        static ERROR_LOADING_PROVINCE = "Loading list of provinces - cities failed !";
        static ERROR_LOADING_DISTRICT = "Loading list of district - ward failed !"
        static ERROR_LOADING_WARD = "Loading list of wards - communes - towns failed !";

        static ERROR_LOADING_PRODUCT = "Loading list of products failed !"
    }

    static AlertMessageVi = class {
        static SUCCESS_REGISTER = "Bạn đã đăng ký thành công !";
        static SUCCESS_LOGIN = "Bạn đã đăng nhập thành công !";

        static SUCCESS_CREATED = "Tạo dữ liệu thành công !";
        static SUCCESS_DELETE = "Xóa dữ liệu thành công !";
        static SUCCESS_UPDATED = "Cập nhật dữ liệu thành công !";

        static ERROR_400 = "Thao tác không thành công, vui lòng kiểm tra lại dữ liệu.";
        static ERROR_401 = "Unauthorized - Access Token của bạn hết hạn hoặc không hợp lệ.";
        static ERROR_403 = "Forbidden - Bạn không được quyền truy cập tài nguyên này.";
        static ERROR_404 = "Not Found - Tài nguyên này đã bị xóa hoặc không tồn tại";
        static ERROR_500 = "Internal Server Error - Hệ thống Server đang có vấn đề hoặc không truy cập được.";

        static ERROR_LOADING_PROVINCE = "Tải danh sách tỉnh - thành phố không thành công !";
        static ERROR_LOADING_DISTRICT = "Tải danh sách quận - phường - huyện không thành công !";
        static ERROR_LOADING_WARD = "Tải danh sách phường - xã - thị trấn không thành công !";
    }


    static showAlertSuccess(t) {
        Swal.fire({
            position: 'top-end',
            icon: 'success',
            title: t,
            showConfirmButton: false,
            timer: 1500
        })
    }

    static showAlertError(t) {
        Swal.fire({
            position: 'center',
            icon: 'error',
            title: t,
            showConfirmButton: true
        })
    }

    static showError401() {
        Swal.fire({
            icon: 'error',
            title: 'Access Denied',
            text: 'Thông tin danh tính không hợp lệ!',
        })
    }

    static showError403() {
        Swal.fire({
            icon: 'error',
            title: 'Access Denied',
            text: 'Bạn không được phép thực hiện chức năng này!',
        })
    }

    static showError500() {
        Swal.fire({
            icon: 'error',
            title: 'Internal Server Error',
            text: 'Hệ thống Server đang có vấn đề hoặc không truy cập được.',
        })
    }

    static Notify = class {
        static showSuccessAlert(m) {
            $.notify(m, "success");
        }

        static showErrorAlert(m) {
            $.notify(m, "error");
        }
    }

}

class ProductAvatar{
    constructor(id, fileName, fileFolder, fileUrl, fileType, cloudId, ts, product) {
        this.id = id;
        this.fileName = fileName;
        this.fileFolder = fileFolder;
        this.fileUrl = fileUrl;
        this.fileType = fileType;
        this.cloudId = cloudId;
        this.ts = ts;
        this.product = product;
    }
}

class Product {
    constructor(id, productName, price, quantity, description, productAvatar) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.productAvatar = productAvatar;
    }
}