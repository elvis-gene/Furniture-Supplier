/*
Author: Ntumba Owin
Date of Creation: 4/7/2020
Desc: This is the Promotion class, it keeps track of all discounts the system can offer.

 */
package com.furnitureapp.entity.sales;

public class Promotion {
    //All attributes
    private String prodTitle;
    private String startDate;
    private String endDate;
    private String description;
    private String season;
    private String year;

    //Constructor
    private Promotion(PromotionBuilder builder) {
        this.prodTitle = builder.prodTitle;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.description = builder.description;
        this.season = builder.season;
        this.year = builder.year;
    }
    //Getters

    public String getProdTitle() {
        return prodTitle;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }

    public String getSeason() {
        return season;
    }

    public String getYear() {
        return year;
    }

    //Display with toString

    @Override
    public String toString() {
        return "Promotion{" +
                "prodTitle='" + prodTitle + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", description='" + description + '\'' +
                ", season='" + season + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

    //Builder Pattern Design implementation
    public static class PromotionBuilder{
        //constructor
        public PromotionBuilder(){}
        //All attributes in the builder class
        private String prodTitle;
        private String startDate;
        private String endDate;
        private String description;
        private String season;
        private String year;

        //Setters

        public PromotionBuilder setProdTitle(String prodTitle) {
            this.prodTitle = prodTitle;
            return this;
        }

        public PromotionBuilder setStartDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        public PromotionBuilder setEndDate(String endDate) {
            this.endDate = endDate;
            return this;
        }

        public PromotionBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public PromotionBuilder setSeason(String season) {
            this.season = season;
            return this;
        }

        public PromotionBuilder setYear(String year) {
            this.year = year;
            return this;
        }

        //Copy of the class Promotion
        public PromotionBuilder copy(Promotion promotion){
            this.prodTitle = promotion.prodTitle;
            this.startDate = promotion.startDate;
            this.endDate = promotion.endDate;
            this.description = promotion.description;
            this.season = promotion.season;
            this.year = promotion.year;
            return this;
        }

        //Create a PromotionBuilder constructor
        public Promotion build(){  return new Promotion(this);   }
    }
}
