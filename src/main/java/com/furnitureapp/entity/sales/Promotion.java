/*
Author: Ntumba Owin
Date of Creation: 4/7/2020
Desc: This is the Promotion class, it keeps track of all discounts the system can offer.

 */
package com.furnitureapp.entity.sales;

import java.time.LocalDate;

public class Promotion {
    //All attributes
    private String promoTitle;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    private String season;
    private int year;

    //Constructor
    private Promotion(PromotionBuilder builder) {
        this.promoTitle = builder.prodTitle;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.description = builder.description;
        this.season = builder.season;
        this.year = builder.year;
    }
    //Getters

    public String getPromoTitle() {
        return promoTitle;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }

    public String getSeason() {
        return season;
    }

    public int getYear() {
        return year;
    }

    //Display with toString

    @Override
    public String toString() {
        return "Promotion{" +
                "prodTitle='" + promoTitle + '\'' +
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
        private LocalDate startDate;
        private LocalDate endDate;
        private String description;
        private String season;
        private int year;

        //Setters

        public PromotionBuilder setProdTitle(String prodTitle) {
            this.prodTitle = prodTitle;
            return this;
        }

        public PromotionBuilder setStartDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public PromotionBuilder setEndDate(LocalDate endDate) {
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

        public PromotionBuilder setYear(int year) {
            this.year = year;
            return this;
        }

        //Copy of the class Promotion
        public PromotionBuilder copy(Promotion promotion){
            this.prodTitle = promotion.promoTitle;
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
