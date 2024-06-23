package com.guy.currencydialog;

import android.content.Context;
import android.content.DialogInterface;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class CurrencyManager {

    public interface CallBack_Currency {
        void selected(String name, String Code, String symbol);
    }

    private static class Currency {
        String name;
        String code;
        String symbol;

        public Currency(String name, String code, String symbol) {
            this.name = name;
            this.code = code;
            this.symbol = symbol;
        }
    }

    private static Currency[] CURRENCIES;

    static {
        CURRENCIES = new Currency[] {
                new Currency("USD", "United States Dollar", "$"),
                new Currency("EUR", "Euro", "€"),
                new Currency("JPY", "Japanese Yen", "¥"),
                new Currency("GBP", "British Pound Sterling", "£"),
                new Currency("AUD", "Australian Dollar", "A$"),
                new Currency("CAD", "Canadian Dollar", "C$"),
                new Currency("CHF", "Swiss Franc", "Fr."),
                new Currency("CNY", "Chinese Yuan", "¥"),
                new Currency("SEK", "Swedish Krona", "kr"),
                new Currency("NZD", "New Zealand Dollar", "NZ$"),
                new Currency("MXN", "Mexican Peso", "$"),
                new Currency("SGD", "Singapore Dollar", "S$"),
                new Currency("HKD", "Hong Kong Dollar", "HK$"),
                new Currency("NOK", "Norwegian Krone", "kr"),
                new Currency("KRW", "South Korean Won", "₩"),
                new Currency("TRY", "Turkish Lira", "₺"),
                new Currency("INR", "Indian Rupee", "₹"),
                new Currency("RUB", "Russian Ruble", "₽"),
                new Currency("BRL", "Brazilian Real", "R$"),
                new Currency("ZAR", "South African Rand", "R"),
        };
    }


    public static void openCurrencyDialog(Context context, CallBack_Currency callBackCurrency) {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(context);
        builder.setTitle("Choose your currency");

        String[] lines = new String[CURRENCIES.length];
        for (int i = 0; i < CURRENCIES.length; i++) {
            Currency c = CURRENCIES[i];
            lines[i] = c.name + "(" + c.symbol + ")";
        }

        builder.setItems(lines, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Currency currency = CURRENCIES[which];

                if (callBackCurrency != null) {
                    callBackCurrency.selected(currency.name, currency.code, currency.symbol);
                }

            }
        });
        builder.create().show();
    }

}