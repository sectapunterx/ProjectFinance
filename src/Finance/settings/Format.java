package Finance.settings;

import Finance.model.Currency;
import Finance.model.Filter;
import org.jetbrains.annotations.NotNull;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Format {
    public static String amount(double amount) {
        return String.format(Settings.FORMAT_AMOUNT, amount);
    }

    public static @NotNull String amount(double amount, @NotNull Currency currency) {
        return String.format(Settings.FORMAT_AMOUNT, amount) + " " + currency.getCode();
    }

    public static String rate(double rate) {
        return String.format(Settings.FORMAT_RATE, rate);
    }

    public static @NotNull String rate(double rate, @NotNull Currency currency) {
        return String.format(Settings.FORMAT_RATE, rate) + " " + currency.getCode();
    }

    public static @NotNull String date(Date date) {
        return new java.text.SimpleDateFormat(Settings.FORMAT_DATE).format(date);
    }

    public static @NotNull String dateMonth(Date date) {
        return dateFormat(date, Settings.FORMAT_DATE_MONTH);
    }

    public static @NotNull String dateYear(Date date) {
        return dateFormat(date, Settings.FORMAT_DATE_YEAR);
    }
    private static @NotNull String dateFormat(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, new MainDateFormatSymbols());
        return sdf.format(date);
    }

    public static double fromAmountToNum(String amount) throws NumberFormatException {
        amount = amount.replaceAll(",", ".");
        return Double.parseDouble(amount);
    }

    public static String yesNo(boolean yes) {
        return yes ? TextConstants.get("YES") : TextConstants.get("NO");
    }

    public static String getTitleFilter(@NotNull Filter filter){
        Date time = filter.getTo();
        return switch (filter.getStep()) {
            case Filter.STEP_DAY -> date(time);
            case Filter.STEP_MONTH -> dateMonth(time);
            case Filter.STEP_YEAR -> dateYear(time);
            default -> "";
        };
    }

    private static class MainDateFormatSymbols extends DateFormatSymbols {
        @Override
        public String[] getMonths() {
            return TextConstants.getMonths();
        }
    }

}
