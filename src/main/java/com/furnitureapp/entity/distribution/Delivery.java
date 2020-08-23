package com.furnitureapp.entity.distribution;


import java.time.LocalDateTime;

public class Delivery {
    private Long deliveryCode;
    private Long saleCode;
    private Long employeeCode;
    private String deliveryAddress;
    private LocalDateTime dateTimeReceived;
    private LocalDateTime dateTimeSet;
    private int trackingNum;
    private String deliveryStatus;

    private Delivery(DeliveryBuilder deliveryBuilder){
        this.deliveryCode = deliveryBuilder.deliveryCode;
        this.employeeCode = deliveryBuilder.employeeCode;
        this.saleCode = deliveryBuilder.saleCode;
        this.deliveryAddress = deliveryBuilder.deliveryAddress;
        this.dateTimeReceived = deliveryBuilder.dateTimeReceived;
        this.dateTimeSet = deliveryBuilder.dateTimeSet;
        this.trackingNum = deliveryBuilder.trackingNum;
        this.deliveryStatus = deliveryBuilder.deliveryStatus;
    }

    public Long getDeliveryCode() {

        return deliveryCode;
    }

    public Long getSaleCode() {
        return saleCode;
    }

    public Long getEmployeeCode() {
        return employeeCode;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public LocalDateTime getDateTimeReceived() {
        return dateTimeReceived;
    }

    public LocalDateTime getDateTimeSet() {
        return dateTimeSet;
    }

    public int getTrackingNum() {
        return trackingNum;
    }

    public String isDeliveryStatus() {
        return  deliveryStatus;
    }

    public static class DeliveryBuilder{
        private Long deliveryCode;
        private Long saleCode;
        private Long employeeCode;
        private String deliveryAddress;
        private LocalDateTime dateTimeReceived;
        private LocalDateTime dateTimeSet;
        private int trackingNum;
        private String deliveryStatus;

        public DeliveryBuilder(){}

        public DeliveryBuilder setDeliveryCode(Long deliveryCode) {
            this.deliveryCode = deliveryCode;
            return this;
        }

        public DeliveryBuilder setSaleCode(Long saleCode) {
            this.saleCode = saleCode;
            return this;
        }

        public DeliveryBuilder setEmployeeCode(Long employeeCode) {
            this.employeeCode = employeeCode;
            return this;
        }

        public DeliveryBuilder setDeliveryAddress(String deliveryAddress) {
            this.deliveryAddress = deliveryAddress;
            return this;
        }

        public DeliveryBuilder setDateTimeReceived(LocalDateTime dateTimeReceived) {
            this.dateTimeReceived = dateTimeReceived;
            return this;
        }

        public DeliveryBuilder setDateTimeSet(LocalDateTime dateTimeSet) {
            this.dateTimeSet = dateTimeSet;
            return this;
        }

        public DeliveryBuilder setTrackingNum(int trackingNum) {
            this.trackingNum = trackingNum;
            return this;
        }

        public DeliveryBuilder setDeliveryStatus(String deliveryStatus) {
            this.deliveryStatus = deliveryStatus;
            return this;
        }

        public DeliveryBuilder copy(Delivery delivery){
            this.deliveryCode = delivery.deliveryCode;
            this.saleCode = delivery.saleCode;
            this.employeeCode = delivery.employeeCode;
            this.dateTimeReceived = delivery.dateTimeReceived;
            this.dateTimeSet = delivery.dateTimeSet;
            this.trackingNum = delivery.trackingNum;
            this.deliveryAddress = delivery.deliveryAddress;
            this.deliveryStatus = delivery.deliveryStatus;
            return this;
        }

        public Delivery build(){
            return new Delivery(this);
        }

    }
}
