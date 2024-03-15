package com.bakirwebservice.productservice.model.constants;


public class PropertyConstants {
    //MICROSERVICES PATHS
    public static final String REST_TEMPLATE_REQUEST_MICROSERVICE_TOKEN_SERVICE_EXTRACT_USERNAME ="${app.routesMicroservices.tokenService.extractUsername}";

    public static final String REST_TEMPLATE_REQUEST_MICROSERVICE_PAYMENT_SERVICE_CREATE_ORDER = "${app.routesMicroservices.paymentService.createOrder}";

    //CONTROLLER PATHS
    public static final String REQUEST_CATEGORYSERVICE = "${app.routesController.requestmapping.categoryServiceController}";

    public static final String REQUEST_PRODUCTSERVICE = "${app.routesController.requestmapping.productServiceController}";

    public static final String PRODUCT_LIST = "${app.routesController.product.productListResponse}";

    public static final String PRODUCT_LIST_BY_NAME = "${app.routesController.product.productListByCategoryName}";

    public static final String CATEGORY_LIST = "${app.routesController.category.categoryListResponse}";

    public static final String REQUEST_PRODUCT_CREATE_ORDER_WITH_PRODUCT_CODE = "${app.routesController.product.buyWithProductCode}";

    public static final String REQUEST_PRODCUT_DETAILS = "${app.routesController.product.productDetails}";

}

