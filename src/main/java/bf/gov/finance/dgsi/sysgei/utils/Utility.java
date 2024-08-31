/*
 * Copyright (c) 2023 Mohamskab
 */

package bf.gov.finance.dgsi.sysgei.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 * @author : <a href="siguizana08@gmail.com">BRAHIMA TRAORE </a>.
 * @version : 1.0
 * @since : 03/09/2022-10:15
 **/
@SuppressWarnings("ALL")
public final class Utility {
    /**
     * Formate String en LocalDate.
     *
     * @param date
     * @return LocalDate
     */
    public static LocalDate formateStringToLocalDate(final String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        return LocalDate.parse(date, formatter);
    }

    /**
     * Formate LocalDate to String.
     *
     * @param localDate
     * @return String
     */
    public static String formateLocalDateToString(final LocalDate localDate) {
        return localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    /**
     * Formate Instance to string.
     *
     * @param instant
     * @return String
     */
    public static String formatInstantToString(final Instant instant) {
        if (instant != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
                    .withLocale(Locale.UK)
                    .withZone(ZoneId.systemDefault());
            return formatter.format(instant);
        }
        return null;
    }

    /**
     * Formate LocalDate to letter.
     *
     * @param localDate
     * @return String
     */
    public static String formatLocalDateToLetter(final LocalDate localDate) {
        return localDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
    }

    /**
     * formats the amount to jasper amount. exp: 100 000 000.
     *
     * @param amount
     * @return the formatted amount as string
     */
    public static String formatAmountForJasper(final Double amount) {
        Locale locale = new Locale("fr", "FR");
        DecimalFormat decimalFormat = (DecimalFormat)
                NumberFormat.getNumberInstance(locale);
        decimalFormat.applyPattern("###,###");
        return decimalFormat.format(amount).replace("\u00A0", " ");
    }

    /**
     * ormats the amount to jasper amount. exp: 100 000 000.
     *
     * @param amount
     * @return String
     */
    public static String formatAmountForJasper(final BigDecimal amount) {
        Locale locale = new Locale("fr", "FR");
        DecimalFormat decimalFormat = (DecimalFormat)
                NumberFormat.getNumberInstance(locale);
        decimalFormat.applyPattern("###,###");
        return decimalFormat.format(amount).replace("\u00A0", " ");
    }

    /**
     * Génération du numero de commande.
     *
     * @param lastNume
     * @return String
     */
    public static String generateSequenceNumber(final String lastNume) {
        DecimalFormat df = new DecimalFormat("000000");
        int value = Integer.parseInt(lastNume) + 1;
        return df.format(value);
    }

    /**
     * Faire la somme d'une liste de BiDecimal.
     *
     * @param valeurs
     * @return BigDecimal
     */
    public static BigDecimal somme(final List<BigDecimal> valeurs) {
        final BigDecimal[] total = {BigDecimal.ZERO};
        valeurs.forEach(s -> {
            total[0] = total[0].add(s);
        });
        return total[0];
    }

    /**
     * Article key.
     *
     * @param lastNume
     * @return String
     */
    public static String generateKey(final String lastNume) {
        DecimalFormat df = new DecimalFormat("000000");
        int value = Integer.parseInt(lastNume) + 1;
        return df.format(value);
    }

    /**
     * Returns zero when the given BigDecimal is null.
     *
     * @param bigDecimal
     * @return BigDecimal
     */
    public static BigDecimal zeroIfNull(final BigDecimal bigDecimal) {
        return bigDecimal == null ? BigDecimal.ZERO : bigDecimal;
    }

    /**
     * Returns zero when the given Long is null.
     *
     * @param aLong
     * @return Long
     */
    public static Long zeroIfNull(final Long aLong) {
        return aLong == null ? 0L : aLong;
    }

    /**
     * Returns zero when the given Integer is null.
     *
     * @param integer
     * @return Integer
     */
    public static Integer zeroIfNull(final Integer integer) {
        return integer == null ? 0 : integer;
    }

    /**
     * Returns zero when the given Double is null.
     *
     * @param aDouble
     * @return Double
     */
    public static Double zeroIfNull(final Double aDouble) {
        return aDouble == null ? 0D : aDouble;
    }

    /**
     * Return moth number.
     *
     * @param date Integer
     * @return Integer
     */
    public static Integer monthNumberFromLocalDate(final Instant date) {
        if (date != null) {
            LocalDate myDate = LocalDate.ofInstant(date, ZoneId.systemDefault());
            if (myDate != null) {
                return myDate.getMonth().getValue();
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    /**
     * Build mois list.
     *
     * @return {@link HashMap <Integer, String>}
     */
    public static HashMap<Integer, String> buildMoisList() {
        HashMap<Integer, String> hashMapList = new HashMap<>();
        hashMapList.put(1, "JANVIER");
        hashMapList.put(2, "FÉVRIER");
        hashMapList.put(3, "MARS");
        hashMapList.put(4, "AVRIL");
        hashMapList.put(5, "MAI");
        hashMapList.put(6, "JUIN");
        hashMapList.put(7, "JUILLET");
        hashMapList.put(8, "AOÛT");
        hashMapList.put(9, "SEPTEMBRE");
        hashMapList.put(10, "OCTOBRE");
        hashMapList.put(11, "NOVEMBRE");
        hashMapList.put(12, "DÉCECEMBRE");
        return hashMapList;
    }

}
