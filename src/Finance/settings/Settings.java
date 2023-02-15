package Finance.settings;

import org.ini4j.Ini;
import org.ini4j.IniPreferences;
import org.ini4j.Wini;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.prefs.Preferences;

final public class Settings {

    public static final File FONT_ROBOTO_LIGHT = new File("fonts\\Roboto-Light.ttf");
    public static final File SAVE_DIR = new File("saves\\");
    public static final String SAVE_FILE_EXT = "lth";

    public static final String FORMAT_AMOUNT = "%.2f";
    public static final String FORMAT_RATE = "%.4f";
    public static final String FORMAT_DATE = "dd.MM.yyyy";
    public static final String FORMAT_DATE_MONTH = "MMMM yyyy";
    public static final String FORMAT_DATE_YEAR = "yyyy";

    public static final int COUNT_OVERVIEW_ROWS = 10;

    public static final String[] CURRENCIES_CODES = new String[]{"RUB", "USD", "EUR", "BTC", "ETH"};

    private static final File FILE_SETTINGS = new File("saves\\settings.ini");
    private static File FILE_SAVE = new File("saves\\default.lth");

    public static void init() throws IOException {
        try {
            Ini ini = new Ini(FILE_SETTINGS);
            Preferences prefs = new IniPreferences(ini);
            String file = prefs.node("Settings").get("SAVE_FILE", null);
            if(file != null) {
                FILE_SAVE = new File(file);
            }
            System.out.println(FILE_SAVE.getAbsolutePath());
            setLocale();
        } catch (IOException e) {
            save();
        }
    }

    public static File getSaveFile(){
        return FILE_SAVE;
    }
    public static void setSaveFile(File file){
        FILE_SAVE = file;
        try {
            Ini ini = new Ini(FILE_SETTINGS);
            Preferences prefs = new IniPreferences(ini);
            prefs.node("Settings").put("SAVE_FILE", file.getAbsolutePath());
            ini.store();
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void setLocale(){
        Locale.setDefault(new Locale("ru", "RU"));
    }

    private static void save() throws IOException {
        try {
            Wini ini = new Wini(FILE_SETTINGS);
            ini.put("Settings", "SAVE_FILE", FILE_SAVE.getAbsolutePath().replace("\\", "\\\\"));
            ini.store();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
