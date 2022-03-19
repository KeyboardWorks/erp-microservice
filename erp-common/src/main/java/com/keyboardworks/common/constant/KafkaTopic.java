package com.keyboardworks.common.constant;

public class KafkaTopic {

    public static class Purchasing {

        public static final String CREATE_PURCHASE_ORDER = "purchasing.create-purchase-order";

    }

    public static class Sales {

        public static final String CREATE_SALES_ORDER = "sales.create-sales-order";

    }

    public static class Inventory {

        public static final String CREATE_GOODS_ISSUE = "inventory.create-goods-issue";
        public static final String CREATE_GOODS_RECEIPT = "inventory.create-goods-receipt";

    }

}
