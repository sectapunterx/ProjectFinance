package Finance.settings;

import java.util.HashMap;

final public class TextConstants {

    private static final HashMap<String, String> data = new HashMap<String, String>();

    public static String get(String key){
        if(data.containsKey(key))
            return data.get(key);
        else
            throw new RuntimeException(String.format("Key %s not found", key));
    }

    public static String[] getMonths(){
        String[] months = new String[12];
        months[0] = data.get("January");
        months[1] = data.get("February");
        months[2] = data.get("March");
        months[3] = data.get("April");
        months[4] = data.get("May");
        months[5] = data.get("June");
        months[6] = data.get("July");
        months[7] = data.get("August");
        months[8] = data.get("September");
        months[9] = data.get("October");
        months[10] = data.get("November");
        months[11] = data.get("December");
        return months;
    }

    public static void init(){
        data.put("ProgramName", "Финансы");
        data.put("Menu_File", "Файл");
        data.put("Menu_Edit", "Правка");
        data.put("Menu_View", "Вид");
        data.put("Menu_Help", "Справка");

        data.put("January", "Январь");
        data.put("February", "Февраль");
        data.put("March", "Март");
        data.put("April", "Апрель");
        data.put("May", "Май");
        data.put("June", "Июнь");
        data.put("July", "Июль");
        data.put("August", "Август");
        data.put("September", "Сентябрь");
        data.put("October", "Октябрь");
        data.put("November", "Ноябрь");
        data.put("December", "Декабрь");

        data.put("ERROR_TITLE_EMPTY", "Вы не ввели название.");
        data.put("ERROR_ALREADY_EXISTS", "Такая запись уже существует.");
        data.put("ERROR_DATE_FORMAT", "Неверный формат даты.");
        data.put("ERROR_CODE_EMPTY", "Вы не ввели код валюты. ");
        data.put("ERROR_CURRENCY_EMPTY", "Вы не выбрали валюту.");
        data.put("ERROR_ARTICLE_EMPTY", "Вы не выбрали статью.");
        data.put("ERROR_ACCOUNT_EMPTY", "Вы не выбрали счет.");
        data.put("ERROR_RATE_INCORRECT", "Некорректный курс валюты.");
        data.put("ERROR_AMOUNT_FORMAT", "Неверный формат суммы.");
        data.put("ERROR_NO_BASE_CURRENCY", "Необходима базовая валюта. Установите это значение в настройках.");

        data.put("YES", "Да");
        data.put("NO", "Нет");

    }

}
