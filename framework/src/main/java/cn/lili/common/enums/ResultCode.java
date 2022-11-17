package cn.lili.common.enums;

/**
 * 返回状态码
 * 第一位 1:商品；2:用户；3:交易,4:促销,5:店铺,6:页面,7:设置,8:其他
 *
 * @author Chopper
 * @since 2020/4/8 1:36 下午
 */
public enum ResultCode {

    /**
     * 成功状态码
     */
    SUCCESS(200, "Successful"),

    /**
     * 失败返回码
     */
    ERROR(400, "Server is busy, please try again later"),

    /**
     * 失败返回码
     */
    DEMO_SITE_EXCEPTION(4001, "演示站点禁止使用"),
    /**
     * 参数异常
     */
    PARAMS_ERROR(4002, "Parameter Exception"),


    /**
     * 系统异常
     */
    WECHAT_CONNECT_NOT_EXIST(1001, "WeChat co-login not configured"),
    VERIFICATION_EXIST(1002, "Captcha service exception"),
    LIMIT_ERROR(1003, "Access is too frequent, please try again later"),
    ILLEGAL_REQUEST_ERROR(1004, "Illegal request, please refresh the page operation"),
    IMAGE_FILE_EXT_ERROR(1005, "Image formats not supported"),
    FILE_TYPE_NOT_SUPPORT(1010, "File types that are not supported for upload！"),
    PLATFORM_NOT_SUPPORTED_IM(1006, "Platform not opened IM"),
    STORE_NOT_SUPPORTED_IM(1007, "Shop is not open IM"),
    UNINITIALIZED_PASSWORD(1008, "Non-initialized password, unable to initialize settings"),
    /**
     * 分类
     */
    CATEGORY_NOT_EXIST(10001, "Product category does not exist"),
    CATEGORY_NAME_IS_EXIST(10002, "The category name already exists"),
    CATEGORY_PARENT_NOT_EXIST(10003, "The category name already exists"),
    CATEGORY_BEYOND_THREE(10004, "Up to three categories, failed to add"),
    CATEGORY_HAS_CHILDREN(10005, "A subcategory exists under this category and cannot be deleted"),
    CATEGORY_HAS_GOODS(10006, "There are products under this category that cannot be deleted"),
    CATEGORY_SAVE_ERROR(10007, "An item exists under this category that cannot be deleted"),
    CATEGORY_PARAMETER_NOT_EXIST(10012, "Category binding parameter group does not exist"),
    CATEGORY_PARAMETER_SAVE_ERROR(10008, "Failed to add category binding parameter group"),
    CATEGORY_PARAMETER_UPDATE_ERROR(10009, "Failed to add category binding parameter group"),
    CATEGORY_DELETE_FLAG_ERROR(10010, "Child class state cannot be inconsistent with parent class!") ,
    CATEGORY_COMMISSION_RATE_ERROR(10011, "Incorrect commission for category!") ,

    /**
     * 商品
     */
    GOODS_ERROR(11001, "Product exception, please try again later"),
    GOODS_NOT_EXIST(11001, "Product has been removed from the shelf"),
    GOODS_NAME_ERROR(11002, "Product name is incorrect, the name should be 2-50 characters"),
    GOODS_UNDER_ERROR(11003, "Product shelf failure"),
    GOODS_UPPER_ERROR(11004, "Product shelf failure"),
    GOODS_AUTH_ERROR(11005, "Product review failed"),
    POINT_GOODS_ERROR(11006, "The point product business is abnormal, please try again later"),
    POINT_GOODS_NOT_EXIST(11020, "Point product does not exist"),
    POINT_GOODS_CATEGORY_EXIST(11021, "The category of the current point product already exists"),
    GOODS_SKU_SN_ERROR(11007, "Product SKU item number cannot be empty"),
    GOODS_SKU_PRICE_ERROR(11008, "Product SKU price cannot be less than or equal to 0"),
    GOODS_SKU_COST_ERROR(11009, "Product SKU cost price cannot be less than or equal to 0"),
    GOODS_SKU_WEIGHT_ERROR(11010, "The weight of the product cannot be negative"),
    GOODS_SKU_QUANTITY_ERROR(11011, "Product inventory quantity cannot be a negative number"),
    GOODS_SKU_QUANTITY_NOT_ENOUGH(11011, "Product is out of stock"),
    MUST_HAVE_GOODS_SKU(11012, "Specification must have one!") ,
    GOODS_PARAMS_ERROR(11013, "Product parameter error, refresh and retry"),
    PHYSICAL_GOODS_NEED_TEMP(11014, "Delivery template needs to be selected for physical goods"),
    VIRTUAL_GOODS_NOT_NEED_TEMP(11015, "No need to select delivery template for virtual goods"),
    GOODS_NOT_EXIST_STORE(11017, "The current user is not authorized to operate this product"),
    GOODS_TYPE_ERROR(11016, "Need to select product type"),

    /**
     * 参数
     */
    PARAMETER_SAVE_ERROR(12001, "Parameter addition failure"),
    PARAMETER_UPDATE_ERROR(12002, "Parameter edit failed"),

    /**
     * 规格
     */
    SPEC_SAVE_ERROR(13001, "Specification modification failure"),
    SPEC_UPDATE_ERROR(13002, "Specification modification failed"),
    SPEC_DELETE_ERROR(13003, "Classification has been bound to this specification, please unlink it first"),

    /**
     * 品牌
     */
    BRAND_SAVE_ERROR(14001, "Brand addition failed"),
    BRAND_UPDATE_ERROR(14002, "Brand modification failed"),
    BRAND_DISABLE_ERROR(14003, "Brand Disable Failure"),
    BRAND_DELETE_ERROR(14004, "Brand deletion failed"),
    BRAND_NAME_EXIST_ERROR(20002, "Brand name duplicate!") ,
    BRAND_USE_DISABLE_ERROR(20003, "Category has been bound to a brand, please unlink it first"),
    BRAND_BIND_GOODS_ERROR(20005, "The brand has been bound to the product, please unassociate first"),
    BRAND_NOT_EXIST(20004, "Brand does not exist"),

    /**
     * 用户
     */
    USER_EDIT_SUCCESS(20001, "User Edit Successful"),
    USER_NOT_EXIST(20002, "User Not Exist"),
    USER_NOT_LOGIN(20003, "User Not Login"),
    USER_AUTH_EXPIRED(20004, "User Log Out, Please Log In"),
    USER_AUTHORITY_ERROR(20005, "No Permissions"),
    USER_CONNECT_LOGIN_ERROR(20006, "No Login inform Found"),
    USER_EXIST(20008, "This User Name or Phone Number Has Been Registered"),
    USER_PHONE_NOT_EXIST(20009, "Phone Number Not Exist"),
    USER_PASSWORD_ERROR(20010, "Incorrect Password"),
    USER_NOT_PHONE(20011, "Non-urrent User Phone Number"),
    USER_CONNECT_ERROR(20012, "Joint Third Party Login With Incorrect Authorization Information"),
    USER_RECEIPT_REPEAT_ERROR(20013, "Duplicate Member Invoice Information"),
    USER_RECEIPT_NOT_EXIST(20014, "Member Invoice Information Not Exist"),
    USER_EDIT_ERROR(20015, "User Edit Failure"),
    USER_OLD_PASSWORD_ERROR(20016, "Old password Incorrect"),
    USER_COLLECTION_EXIST(20017, "Unable Repeat Followers"),
    USER_GRADE_IS_DEFAULT(20018, "Membership Level Is The Default Membership Level"),
    USER_NOT_BINDING(20020, "Unbound Users"),
    USER_AUTO_REGISTER_ERROR(20021, "Auto-Registration Failed, Please Try Again Later"),
    USER_OVERDUE_CONNECT_ERROR(20022, "Authorization Information Has Expired, Please Re-Authorize/Login"),
    USER_CONNECT_BANDING_ERROR(20023, "The Current Joint Login Method, Has Been Bound To Other Accounts, Need To Unbind Operation"),
    USER_CONNECT_NOT_EXIST_ERROR(20024, "No Joint Login Information, Can't Realize One key Registration Function, Please Click The Third Party Login For Authorization"),
    USER_POINTS_ERROR(20024, "Insufficient Points"),

    /**
     * 权限
     */
    PERMISSION_DEPARTMENT_ROLE_ERROR(21001, "The role is bound to a department, please delete one by one"),
    PERMISSION_USER_ROLE_ERROR(21002, "The role is bound to an administrator, please delete one by one"),
    PERMISSION_MENU_ROLE_ERROR(21003, "The menu is bound to a role, please delete or edit the role first"),
    PERMISSION_DEPARTMENT_DELETE_ERROR(21004, "The department has bound administrator, please delete or edit the administrator first"),
    PERMISSION_BEYOND_TEN(21005, "Up to 10 roles can be set"),

    /**
     * 分销
     */
    DISTRIBUTION_CLOSE(22000, "Distribution function is closed"),
    DISTRIBUTION_NOT_EXIST(22001, "Distributor does not exist"),
    DISTRIBUTION_IS_APPLY(22002, "Distributor has applied, no need to submit again"),
    DISTRIBUTION_AUDIT_ERROR(22003, "Review of distributor failed"),
    DISTRIBUTION_RETREAT_ERROR(22004, "Distributor Clearance Failed"),
    DISTRIBUTION_CASH_NOT_EXIST(22005, "Distributor withdrawal record does not exist"),
    DISTRIBUTION_GOODS_DOUBLE(22006, "Can't add distribution item repeatedly"),

    /**
     * 购物车
     */
    CART_ERROR(30001, "Exception for reading the shopping cart on the checkout page"),
    CART_NUM_ERROR(30010, "The number of purchases must be greater than 0"),
    CART_PINTUAN_NOT_EXIST_ERROR(30002, "The grouping activity is closed, please try again later"),
    CART_PINTUAN_LIMIT_ERROR(30003, "The number of purchases exceeded the limit of the group activity"),
    SHIPPING_NOT_APPLY(30005, "The shopping product does not support delivery to the current shipping address"),

    /**
     * 订单
     */
    ORDER_ERROR(31001, "Order creation exception, please try again later"),
    ORDER_NOT_EXIST(31002, "Order does not exist"),
    ORDER_DELIVERED_ERROR(31003, "Order status error, cannot confirm receipt"),
    ORDER_UPDATE_PRICE_ERROR(31004, "The amount of the paid order cannot be modified"),
    ORDER_LOGISTICS_ERROR(31005, "Logistics error"),
    ORDER_DELIVER_ERROR(31006, "Logistics error"),
    ORDER_NOT_USER(31007, "Order not from current member"),
    ORDER_TAKE_ERROR(31008, "Current order cannot be checked out"),
    MEMBER_ADDRESS_NOT_EXIST(31009, "Order without shipping address, please configure shipping address first"),
    ORDER_DELIVER_NUM_ERROR(31010, "There is no order to be shipped"),
    ORDER_NOT_SUPPORT_DISTRIBUTION(31011, "The shopping cart contains products that do not support delivery, please reselect the shipping address or reselect the products"),
    ORDER_NOT_EXIST_VALID(31041, "There are no valid products in the shopping cart, please check the products in the shopping cart, or reselect the products"),
    ORDER_CAN_NOT_CANCEL(31012, "Current order status cannot be cancelled"),
    ORDER_BATCH_DELIVER_ERROR(31013, "Bulk shipping, file reading failed"),
    ORDER_ITEM_NOT_EXIST(31014, "Current order item does not exist!") ,
    POINT_NOT_ENOUGH(31015, "The current member points are not enough to buy the current point products!") ,


            /**
             * 支付
             */
            PAY_UN_WANTED(32000, "The current order does not need to be paid, just return to the order list and wait for the system order to be released"),
            PAY_SUCCESS(32001, "Payment successful"),
            PAY_INCONSISTENT_ERROR(32002, "The payment amount and the amount due do not match"),
            PAY_DOUBLE_ERROR(32003, "Order has been paid, cannot make another payment"),
            PAY_CASHIER_ERROR(32004, "Error getting cashier information"),
            PAY_ERROR(32005, "Payment operation is abnormal, please try again later"),
            PAY_BAN(32006, "The current order does not require payment, please return to the order list to operate again"),
            PAY_PARTIAL_ERROR(32007, "The order has been partially paid, please go to the order center for payment"),
            PAY_NOT_SUPPORT(32008, "Payment is not supported at this time"),
            PAY_CLIENT_TYPE_ERROR(32009, "Wrong client"),
            PAY_POINT_ENOUGH(32010, "Insufficient points to redeem"),
            PAY_NOT_EXIST_ORDER(32011, "Payment order does not exist"),
            CAN_NOT_RECHARGE_WALLET(32012, "Can't use the balance for recharge"),


            /**
             * 售后
             */
            AFTER_SALES_NOT_PAY_ERROR(33001, "The current order is not paid and cannot be applied for after-sales"),
            AFTER_SALES_CANCEL_ERROR(33002, "The current after-sales order cannot be canceled"),
            AFTER_SALES_BAN(33003, "Order status does not allow after-sales application, please contact the platform or merchant"),
            AFTER_SALES_DOUBLE_ERROR(33004, "After-sales has been reviewed, cannot repeat operation"),
            AFTER_SALES_LOGISTICS_ERROR(33005, "Logistics company error, please select again"),
            AFTER_STATUS_ERROR(33006, "After-sales status error, please refresh the page"),
            RETURN_MONEY_OFFLINE_BANK_ERROR(33007, "When the account type is bank transfer, the bank information cannot be empty"),
            AFTER_SALES_PRICE_ERROR(33004, "The refund amount requested is wrong"),
            AFTER_GOODS_NUMBER_ERROR(33008, "Wrong quantity of goods applied for after-sale"),

            /**
             * 投诉
             */
            COMPLAINT_ORDER_ITEM_EMPTY_ERROR(33100, "Order does not exist"),
            COMPLAINT_SKU_EMPTY_ERROR(33101, "The product has been removed from the shelves, if you need to complain, please contact the platform customer service"),
            COMPLAINT_ERROR(33102, "Complaint exception, please try again later"),
            COMPLAINT_NOT_EXIT(33103, "The current complaint record does not exist"),
            COMPLAINT_ARBITRATION_RESULT_ERROR(33104, "Arbitration result cannot be empty when ending an order complaint"),
            COMPLAINT_APPEAL_CONTENT_ERROR(33105, "When a merchant complains, the complaint cannot be empty"),
            COMPLAINT_CANCEL_ERROR(33106, "The complaint has been completed, no need to cancel the complaint operation"),


            /**
             * 余额
             */
            WALLET_NOT_EXIT_ERROR(34000, "Wallet does not exist, please contact the administrator"),
            WALLET_INSUFFICIENT(34001, "Balance is not enough to pay the order, please top up!") ,
            WALLET_WITHDRAWAL_INSUFFICIENT(34002, "Insufficient cash available for withdrawal!") ,
            WALLET_WITHDRAWAL_FROZEN_AMOUNT_INSUFFICIENT(34006, "Insufficient frozen amount, cannot process withdrawal request!") ,
            WALLET_ERROR_INSUFFICIENT(34003, "Failed to withdraw change!") ,
            WALLET_REMARK_ERROR(34004, "Please fill in the audit note!") ,
            WALLET_EXIT_ERROR(34000, "Wallet already exists, cannot repeat creation"),
            WALLET_APPLY_ERROR(34005, "Withdrawal application exception!") ,

            /**
             * 评价
             */
            EVALUATION_DOUBLE_ERROR(35001, "Unable to submit a duplicate evaluation"),

            /**
             * 活动
             */
            PROMOTION_GOODS_NOT_EXIT(40000, "Current promotional item does not exist!") ,
            PROMOTION_GOODS_QUANTITY_NOT_EXIT(40020, "The current promotion product is not in stock!") ,
            PROMOTION_SAME_ACTIVE_EXIST(40001, "Similar activity already exists during the activity time, please choose to close and delete the activity for the current period"),
            PROMOTION_START_TIME_ERROR(40002, "The activity start time cannot be less than the current time"),
            PROMOTION_END_TIME_ERROR(40003, "The activity end time cannot be less than the current time"),
            PROMOTION_TIME_ERROR(40004, "The event start time must be greater than the end time"),
            PROMOTION_TIME_NOT_EXIST(40011, "The activity start time and activity end time cannot be null"),
            PROMOTION_SAME_ERROR(40005, "The same activity already exists for the current time period!") ,
            PROMOTION_GOODS_ERROR(40006, "Please select the product to participate in the event"),
            PROMOTION_STATUS_END(40007, "The current activity has been stopped"),
            PROMOTION_UPDATE_ERROR(40008, "The current activity has started/ended and cannot be edited!") ,
            PROMOTION_ACTIVITY_GOODS_ERROR(40009, "The current activity has started can't add products"),
            PROMOTION_ACTIVITY_ERROR(400010, "The current promotion does not exist"),
            PROMOTION_LOG_EXIST(40011, "The event has been attended and a duplicate has been sent to attend"),

            /**
             * 优惠券
             */
            COUPON_LIMIT_ERROR(41000, "Collection limit exceeded"),
            COUPON_EDIT_STATUS_SUCCESS(41001, "Modify status successfully!") ,
            COUPON_CANCELLATION_SUCCESS(41002, "Member coupon voided successfully"),
            COUPON_EXPIRED(41003, "Voucher is used/expired and cannot be used"),
            COUPON_EDIT_STATUS_ERROR(41004, "Voucher modification status failed!") ,
            COUPON_RECEIVE_ERROR(41005, "The current Voucher has been claimed, come early next time"),
            COUPON_NUM_INSUFFICIENT_ERROR(41006, "The number of coupons left to collect is not enough"),
            COUPON_NOT_EXIST(41007, "Current Voucher does not exist"),
            COUPON_DO_NOT_RECEIVER(41030, "The current Voucher is not allowed to be actively claimed"),
            COUPON_ACTIVITY_NOT_EXIST(410022, "Current Voucher activity does not exist"),
            COUPON_SAVE_ERROR(41020, "Failed to save Voucher"),
            COUPON_ACTIVITY_SAVE_ERROR(41023, "Failed to save Voucher campaign"),
            COUPON_DELETE_ERROR(41021, "Failed to delete Voucher"),
            COUPON_LIMIT_NUM_LESS_THAN_0(41008, "Collection limit quantity cannot be negative"),
            COUPON_LIMIT_GREATER_THAN_PUBLISH(41009, "The number of pickup limits exceeds the number of issues"),
            COUPON_DISCOUNT_ERROR(41010, "Voucher discount must be less than 10 and greater than 0"),
            COUPON_SCOPE_TYPE_GOODS_ERROR(41011, "The product list cannot be empty when the current associated range type is the specified product"),
            COUPON_SCOPE_TYPE_CATEGORY_ERROR(41012, "The range associated id cannot be empty when the current association range type is part of the product category"),
            COUPON_SCOPE_TYPE_STORE_ERROR(41013, "The range associated id cannot be empty when the current association range type is partial store category"),
            COUPON_SCOPE_ERROR(41014, "The specified product range association id is invalid!") ,
            COUPON_MEMBER_NOT_EXIST(41015, "There is no current member Voucher"),
            COUPON_MEMBER_STATUS_ERROR(41016, "The current member Voucher has expired/invalidated and cannot be changed!") ,


            /**
             * 拼团
             */
            PINTUAN_MANUAL_OPEN_SUCCESS(42001, "Manual opening of the collocation activity was successful"),
            PINTUAN_MANUAL_CLOSE_SUCCESS(42002, "Manually close the group activity successfully"),
            PINTUAN_ADD_SUCCESS(42003, "Add group activity successfully"),
            PINTUAN_EDIT_SUCCESS(42004, "Modify group activity successfully"),
            PINTUAN_DELETE_SUCCESS(42005, "Delete group activity successful"),
            PINTUAN_MANUAL_OPEN_ERROR(42006, "Failed to open the group activity manually"),
            PINTUAN_MANUAL_CLOSE_ERROR(42007, "Failed to close the group activity manually"),
            PINTUAN_ADD_ERROR(42008, "Failed to add group activity"),
            PINTUAN_EDIT_ERROR(42009, "Failed to modify group activity"),
            PINTUAN_EDIT_ERROR_ITS_OPEN(42019, "The grouping activity has been opened, can't modify the grouping activity!") ,
            PINTUAN_DELETE_ERROR(42010, "Failed to delete grouping activity"),
            PINTUAN_JOIN_ERROR(42011, "Can't participate in the group activity you started!") ,
            PINTUAN_LIMIT_NUM_ERROR(42012, "The purchase quantity exceeds the limit quantity of the group activity!") ,
            PINTUAN_NOT_EXIST_ERROR(42013, "The current group activity does not exist!") ,
            PINTUAN_GOODS_NOT_EXIST_ERROR(42014, "The current grouping product does not exist!") ,

            /**
             * 满额活动
             */
            FULL_DISCOUNT_EDIT_SUCCESS(43001, "Modify full promotion successful"),
            FULL_DISCOUNT_EDIT_DELETE(43002, "Delete full offer successful"),
            FULL_DISCOUNT_MODIFY_ERROR(43003, "The currently edited full promotion has already started or has ended and cannot be modified"),
            FULL_DISCOUNT_NOT_EXIST_ERROR(43004, "The current full promotion to be operated does not exist!") ,
            FULL_DISCOUNT_WAY_ERROR(43005, "Please select a discount method!") ,
            FULL_DISCOUNT_GIFT_ERROR(43006, "Please select a free item!") ,
            FULL_DISCOUNT_COUPON_TIME_ERROR(43007, "The validity of the complimentary coupon must be within the campaign time"),
            FULL_DISCOUNT_MONEY_ERROR(43008, "Please fill in the full amount"),
            FULL_DISCOUNT_MONEY_GREATER_THAN_MINUS(43009, "The full reduction amount cannot be greater than the discount threshold"),
            FULL_RATE_NUM_ERROR(43010, "Please fill in the discount value"),

            /**
             * 直播
             */
            STODIO_GOODS_EXIST_ERROR(44001, "Live product already exists"),
            COMMODITY_ERROR(44002, "Failed to add live product"),

            /**
             * 秒杀
             */
            SECKILL_NOT_START_ERROR(45000, "There is no limited time offer today, please check back tomorrow.") ,
            SECKILL_NOT_EXIST_ERROR(45001, "The currently participating seconds do not exist!") ,
            SECKILL_APPLY_NOT_EXIST_ERROR(45010, "The current participating seconds does not exist!") ,
            SECKILL_UPDATE_ERROR(45002, "The current spike event has already started and cannot be modified!") ,
            SECKILL_PRICE_ERROR(45003, "The price of the event cannot be greater than the original price of the product"),
            SECKILL_TIME_ERROR(45004, "Moment parameter exception"),
            SECKILL_DELETE_ERROR(45005, "The status of the second event activity cannot be deleted"),
            SECKILL_OPEN_ERROR(45010, "The status of the second kill event activity cannot be deleted"),
            SECKILL_CLOSE_ERROR(45006, "The status of the second-kill event cannot be closed"),


            /**
             * 优惠券活动
             */
            COUPON_ACTIVITY_START_TIME_ERROR(46001, "Activity Time Is Less Than The Current Time, Can Not Be Edited To Delete The Operation"),
            COUPON_ACTIVITY_MEMBER_ERROR(46002, "Specify The Precise Issuance Of Coupons, Then You Must Specify The Members, Members Can Not Be Empty"),
            COUPON_ACTIVITY_ITEM_ERROR(46003, "Coupon Campaigns Must Specify Coupons And Cannot Be Empty"),
            COUPON_ACTIVITY_ITEM_MUST_NUM_ERROR(46004, "Coupon Campaign Specifies Up To 10 Coupons"),
            COUPON_ACTIVITY_ITEM_NUM_ERROR(46005, "Number Of Coupons Must Be Greater Than 0"),

            /**
             * 其他促销
             */
            MEMBER_SIGN_REPEAT(47001, "Please Do Not Sign In Repeatedly"),
            POINT_GOODS_ACTIVE_STOCK_ERROR(47002, "Active inventory quantity cannot be higher than the product inventory"),
            POINT_GOODS_ACTIVE_STOCK_INSUFFICIENT(47003, "Insufficient stock of point products"),

            /**
             * 砍价活动
             */
            KANJIA_GOODS_ACTIVE_STOCK_ERROR(48001, "The active inventory quantity cannot be higher than the product inventory"),
            KANJIA_GOODS_ACTIVE_PRICE_ERROR(48002, "The minimum purchase amount cannot be higher than the product amount"),
            KANJIA_GOODS_ACTIVE_HIGHEST_PRICE_ERROR(48003, "The maximum cut price cannot be 0 and cannot exceed the product amount"),
            KANJIA_GOODS_ACTIVE_LOWEST_PRICE_ERROR(48004, "The minimum price cannot be 0 and cannot exceed the product amount"),
            KANJIA_GOODS_ACTIVE_HIGHEST_LOWEST_PRICE_ERROR(48005, "The minimum cut amount cannot be higher than the maximum cut amount"),
            KANJIA_GOODS_ACTIVE_SETTLEMENT_PRICE_ERROR(48006, "The settlement amount cannot be higher than the product amount"),
            KANJIA_GOODS_DELETE_ERROR(48007, "Deleting cut-price item is abnormal"),
            KANJIA_GOODS_UPDATE_ERROR(48012, "Update bargain item exception"),
            KANJIA_ACTIVITY_NOT_FOUND_ERROR(48008, "Bargain record does not exist"),
            KANJIA_ACTIVITY_LOG_MEMBER_ERROR(48009, "The current member has helped to cut"),
            KANJIA_ACTIVITY_MEMBER_ERROR(48010, "The current member has already started this price cutting activity"),
            KANJIA_ACTIVITY_NOT_PASS_ERROR(48011, "The current price cut does not meet the conditions and cannot be purchased"),
            KANJIA_NUM_BUY_ERROR(48012, "Incorrect number of bargain items purchased"),

            /**
             * 店铺
             */
            STORE_NOT_EXIST(50001, "This store does not exist"),
            STORE_NAME_EXIST_ERROR(50002, "Store name already exists!") ,
            STORE_APPLY_DOUBLE_ERROR(50003, "A store already exists, no need to apply again!") ,
            STORE_NOT_OPEN(50004, "The member has not opened a store"),
            STORE_NOT_LOGIN_ERROR(50005, "Not logged into the store"),
            STORE_CLOSE_ERROR(50006, "Store is closed, please contact administrator"),
            FREIGHT_TEMPLATE_NOT_EXIST(50010, "Current template does not exist"),

            /**
             * 结算单
             */
            BILL_CHECK_ERROR(51001, "Only billed statements can be reconciled"),
            BILL_COMPLETE_ERROR(51002, "Only audited statements can be paid"),

            /**
             * 文章
             */
            ARTICLE_CATEGORY_NAME_EXIST(60001, "Article category name already exists"),
            ARTICLE_CATEGORY_PARENT_NOT_EXIST(60002, "Article category parent category does not exist"),
            ARTICLE_CATEGORY_BEYOND_TWO(60003, "Up to secondary category, operation failed"),
            ARTICLE_CATEGORY_DELETE_ERROR(60004, "A subcategory exists under this article category and cannot be deleted"),
            ARTICLE_CATEGORY_HAS_ARTICLE(60005, "An article exists under this article category and cannot be deleted"),
            ARTICLE_CATEGORY_NO_DELETION(60007, "The default article category cannot be deleted"),
            ARTICLE_NO_DELETION(60008, "The default article cannot be deleted"),


            /**
             * 页面
             */
            PAGE_NOT_EXIST(61001, "Page does not exist"),
            PAGE_OPEN_DELETE_ERROR(61002, "The current page is open and cannot be deleted"),
            PAGE_DELETE_ERROR(61003, "The current page is the only page and cannot be deleted"),
            PAGE_RELEASE_ERROR(61004, "The page has been published, no need to submit again"),

            /**
             * 设置
             */
            SETTING_NOT_TO_SET(70001, "This parameter does not need to be set"),
            ALIPAY_NOT_SETTING(70002, "Alipay payment is not configured"),
            ALIPAY_EXCEPTION(70003, "Paypal payment error, please try again later"),
            ALIPAY_PARAMS_EXCEPTION(70004, "Alipay parameter is abnormal"),
            LOGISTICS_NOT_SETTING(70005, "You have not configured the express inquiry yet"),
            ORDER_SETTING_ERROR(70006, "The system order configuration is abnormal"),
            ALI_SMS_SETTING_ERROR(70007, "You have not configured Aliyun SMS yet"),
            SMS_SIGN_EXIST_ERROR(70008, "SMS signature already exists"),

            /**
             * 站内信
             */
            NOTICE_NOT_EXIST(80001, "Current message template does not exist"),
            NOTICE_ERROR(80002, "Modify station message exception, please try again later"),
            NOTICE_SEND_ERROR(80003, "Sending station message is abnormal, please check the system log"),

            /**
             * OSS
             */
            OSS_NOT_EXIST(80101, "OSS is not configured"),
            OSS_EXCEPTION_ERROR(80102, "File upload failed, please try again later"),
            OSS_DELETE_ERROR(80103, "Image deletion failed"),

            /**
             * 验证码
             */
            VERIFICATION_SEND_SUCCESS(80201, "SMS verification code, sent successfully"),
            VERIFICATION_ERROR(80202, "Verification failed"),
            VERIFICATION_CODE_INVALID(80204, "Verification code is invalid, please recheck"),
            VERIFICATION_SMS_CHECKED_ERROR(80210, "SMS verification code error, please recheck"),

            /**
             * 微信相关异常
             */
            WECHAT_CONNECT_NOT_SETTING(80300, "WeChat joint login information is not configured"),
            WECHAT_PAYMENT_NOT_SETTING(80301, "WeChat payment information is not configured"),
            WECHAT_QRCODE_ERROR(80302, "WeChat QR code generation exception"),
            WECHAT_MP_MESSAGE_ERROR(80303, "WeChat applet small message subscription exception"),
            WECHAT_JSAPI_SIGN_ERROR(80304, "WeChat JsApi signature exception"),
            WECHAT_CERT_ERROR(80305, "Certificate acquisition failed"),
            WECHAT_MP_MESSAGE_TMPL_ERROR(80306, "Failed to get WeChat template message id"),
            WECHAT_ERROR(80307, "WeChat interface exception"),
            APP_VERSION_EXIST(80307, "APP version already exists"),

            /**
             * 其他
             */
            CUSTOM_WORDS_EXIST_ERROR(90000, "Current custom split exists!") ,
            CUSTOM_WORDS_NOT_EXIST_ERROR(90001, "Current custom participle does not exist!") ,
            CUSTOM_WORDS_SECRET_KEY_ERROR(90002, "Secret key verification failed!") ,
            CONNECT_NOT_EXIST(90000, "Login method does not exist!") ,
            ELASTICSEARCH_INDEX_INIT_ERROR(90003, "Index initialization failed!") ,
            PURCHASE_ORDER_DEADLINE_ERROR(90004, "Supply and demand list, has exceeded the registration deadline"),
            INDEX_BUILDING(90005, "Index is being generated");

    private final Integer code;
    private final String message;


    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

}