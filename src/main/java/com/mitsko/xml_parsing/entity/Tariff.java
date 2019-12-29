package com.mitsko.xml_parsing.entity;

import java.util.ArrayList;
import java.util.Objects;

public class Tariff {
    private String name;
    private String operatorName;
    private String payroll;
    private String inCallPrice;
    private String outCallPrice;
    private String homePhoneCallPrice;
    private String SMSPrice;
    private ArrayList<String> favoriteNumbers;
    private String charging;
    private String connectionPrice;

    public static class Builder {
        private String name;
        private String operatorName;
        private String payroll;
        private String inCallPrice;
        private String outCallPrice;
        private String homePhoneCallPrice;
        private String SMSPrice;
        private ArrayList<String> favoriteNumbers;
        private String charging;
        private String connectionPrice;

        public Builder() {
        }

        public Builder(String name, String operatorName, String payroll,
                        String inCallPrice, String outCallPrice, String homePhoneCallPrice,
                        String SMSPrice, ArrayList<String> favoriteNumbers, String charging,
                        String connectionPrice) {
            this.name = name;
            this.operatorName = operatorName;
            this.payroll = payroll;
            this.inCallPrice = inCallPrice;
            this.outCallPrice = outCallPrice;
            this.homePhoneCallPrice = homePhoneCallPrice;
            this.SMSPrice = SMSPrice;
            this.favoriteNumbers = favoriteNumbers;
            this.charging = charging;
            this.connectionPrice = connectionPrice;
        }

        public void withName(String name) {
            this.name = name;
        }

        public void withOperatorName(String operatorName) {
            this.operatorName = operatorName;
        }

        public void withPayroll(String payroll) {
            this.payroll = payroll;
        }

        public void withInCallPrice(String inCallPrice) {
            this.inCallPrice = inCallPrice;
        }

        public void withOutCallPrice(String outCallPrice) {
            this.outCallPrice = outCallPrice;
        }

        public void withHomePhoneCallPrice(String homePhoneCallPrice) {
            this.homePhoneCallPrice = homePhoneCallPrice;
        }

        public void withSMSPrice(String SMSPrice) {
            this.SMSPrice = SMSPrice;
        }

        public void withFavoriteNumbers(ArrayList<String> favoriteNumbers) {
            this.favoriteNumbers = favoriteNumbers;
        }

        public void withCharging(String charging) {
            this.charging = charging;
        }

        public void withConnectionPrice(String connectionPrice) {
            this.connectionPrice = connectionPrice;
        }

        public Tariff build() {
            return new Tariff(this);
        }
    }

    private Tariff(Builder builder) {
        this.name = builder.name;
        this.operatorName = builder.operatorName;
        this.payroll = builder.payroll;
        this.inCallPrice = builder.inCallPrice;
        this.outCallPrice = builder.outCallPrice;
        this.homePhoneCallPrice = builder.homePhoneCallPrice;
        this.SMSPrice = builder.SMSPrice;
        this.favoriteNumbers = builder.favoriteNumbers;
        this.charging = builder.charging;
        this.connectionPrice = builder.connectionPrice;
    }

    /*public Tariff() {
        favoriteNumbers = new ArrayList<>();
    }*/

   /* public Tariff(String name, String operatorName, String payroll,
                  String inCallPrice, String outCallPrice, String homePhoneCallPrice,
                  String SMSPrice, ArrayList<String> favoriteNumbers, String charging,
                  String connectionPrice) {
        this.name = name;
        this.operatorName = operatorName;
        this.payroll = payroll;
        this.inCallPrice = inCallPrice;
        this.outCallPrice = outCallPrice;
        this.homePhoneCallPrice = homePhoneCallPrice;
        this.SMSPrice = SMSPrice;
        this.favoriteNumbers = favoriteNumbers;
        this.charging = charging;
        this.connectionPrice = connectionPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getPayroll() {
        return payroll;
    }

    public void setPayroll(String payroll) {
        this.payroll = payroll;
    }

    public String getInCallPrice() {
        return inCallPrice;
    }

    public void setInCallPrice(String inCallPrice) {
        this.inCallPrice = inCallPrice;
    }

    public String getOutCallPrice() {
        return outCallPrice;
    }

    public void setOutCallPrice(String outCallPrice) {
        this.outCallPrice = outCallPrice;
    }

    public String getHomePhoneCallPrice() {
        return homePhoneCallPrice;
    }

    public void setHomePhoneCallPrice(String homePhoneCallPrice) {
        this.homePhoneCallPrice = homePhoneCallPrice;
    }

    public String getSMSPrice() {
        return SMSPrice;
    }

    public void setSMSPrice(String SMSPrice) {
        this.SMSPrice = SMSPrice;
    }

    public ArrayList<String> getFavoriteNumbers() {
        return favoriteNumbers;
    }

    public void setFavoriteNumbers(ArrayList<String> favoriteNumbers) {
        this.favoriteNumbers = favoriteNumbers;
    }

    public String getFavoriteNumber(int index) {
        return favoriteNumbers.get(index);
    }

    public void setFavoriteNumber(int index, String favoriteNumber) {
        favoriteNumbers.add(index, favoriteNumber);
    }

    public String getCharging() {
        return charging;
    }

    public void setCharging(String charging) {
        this.charging = charging;
    }

    public String getConnectionPrice() {
        return connectionPrice;
    }

    public void setConnectionPrice(String connectionPrice) {
        this.connectionPrice = connectionPrice;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tariff tariff = (Tariff) o;
        return payroll.equals(tariff.payroll) &&
                inCallPrice.equals(tariff.inCallPrice) &&
                outCallPrice.equals(tariff.outCallPrice) &&
                homePhoneCallPrice.equals(tariff.homePhoneCallPrice) &&
                SMSPrice.equals(tariff.SMSPrice) &&
                charging.equals(tariff.charging) &&
                connectionPrice.equals(tariff.connectionPrice) &&
                name.equals(tariff.name) &&
                operatorName.equals(tariff.operatorName) &&
                favoriteNumbers.equals(tariff.favoriteNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, operatorName, payroll, inCallPrice, outCallPrice, homePhoneCallPrice, SMSPrice, favoriteNumbers, charging, connectionPrice);
    }

    @Override
    public String toString() {
        return "Tariff{" +
                "name='" + name + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", payroll=" + payroll +
                ", inCallPrice=" + inCallPrice +
                ", outCallPrice=" + outCallPrice +
                ", homePhoneCallPrice=" + homePhoneCallPrice +
                ", SMSPrice=" + SMSPrice +
                ", favoriteNumbers=" + favoriteNumbers +
                ", charging=" + charging +
                ", connectionPrice=" + connectionPrice +
                '}';
    }
}
