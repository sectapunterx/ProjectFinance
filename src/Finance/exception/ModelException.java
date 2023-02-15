package Finance.exception;

import Finance.settings.TextConstants;

public class ModelException extends Exception {

    public static final int TITLE_EMPTY = 1; // пустой заголовок
    public static final int ALREADY_EXISTS = 2; // уже существует
    public static final int DATE_FORMAT = 3; // неверный формат даты
    public static final int CODE_EMPTY = 4; // пустой код валюты
    public static final int CURRENCY_EMPTY = 5; // неуказанная валюта
    public static final int ARTICLE_EMPTY = 6; // неуказанная статья (при транзакции/переводе)
    public static final int ACCOUNT_EMPTY = 7; // неуказан счет (при транзакции/переводе)
    public static final int RATE_INCORRECT = 8; // некорректный курс валюты
    public static final int AMOUNT_FORMAT = 9; // неверный формат суммы
    public static final int NO_BASE_CURRENCY = 10; // не указана базовая валюта

    private final int code;

    public ModelException(int code){
        this.code = code;
    }

    public String getMessage(){
        return switch (code) {
            case TITLE_EMPTY -> TextConstants.get("ERROR_TITLE_EMPTY");
            case ALREADY_EXISTS -> TextConstants.get("ERROR_ALREADY_EXISTS");
            case DATE_FORMAT -> TextConstants.get("ERROR_DATE_FORMAT");
            case CODE_EMPTY -> TextConstants.get("ERROR_CODE_EMPTY");
            case CURRENCY_EMPTY -> TextConstants.get("ERROR_CURRENCY_EMPTY");
            case ARTICLE_EMPTY -> TextConstants.get("ERROR_ARTICLE_EMPTY");
            case ACCOUNT_EMPTY -> TextConstants.get("ERROR_ACCOUNT_EMPTY");
            case RATE_INCORRECT -> TextConstants.get("ERROR_RATE_INCORRECT");
            case AMOUNT_FORMAT -> TextConstants.get("ERROR_AMOUNT_FORMAT");
            case NO_BASE_CURRENCY -> TextConstants.get("ERROR_NO_BASE_CURRENCY");
            default -> "Unknown error";
        };
    }
}
