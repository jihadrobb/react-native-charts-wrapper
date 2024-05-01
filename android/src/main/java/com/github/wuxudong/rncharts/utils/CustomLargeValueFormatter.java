package com.github.wuxudong.rncharts.utils;

import com.github.mikephil.charting.formatter.LargeValueFormatter;

/* 
    This class is needed to change default formatted value.
    Yes you are able to change suffix in other ways, but it won't affect formatted value.
    Update this if needed, currently supported value are up to billions (Milyar in bahasa).
 */
public class CustomLargeValueFormatter extends LargeValueFormatter {

    @Override
    public String getFormattedValue(float value) {
        if (value >= 1000000000) { // Billions
            return formatValue(value / 1000000000f) + " ml";
        } else if (value >= 1000000) { // Millions
            return formatValue(value / 1000000f) + " jt";
        } else if (value >= 1000) { // Thousands
            return formatValue(value / 1000f) + " rb";
        } else {
            return super.getFormattedValue(value);
        }
    }

    private String formatValue(float value) {
        if (Math.round(value) == value) {
            // If the value is a whole number, return it without decimal
            return String.valueOf((int) value);
        } else {
            // If the value has decimals, return it with one decimal place
            return String.format("%.1f", value);
        }
    }
}
