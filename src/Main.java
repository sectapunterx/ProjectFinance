import Finance.settings.Format;
import Finance.settings.Settings;
import Finance.settings.TextConstants;

import java.awt.*;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        init();
        System.out.println(Format.dateMonth(new Date()));
        //System.out.println(TextConstants.get("ProgramName"));
        //System.out.println(Arrays.toString(TextConstants.getMonths()));
    }

    private static void init() throws RuntimeException, IOException {
        Settings.init();
        TextConstants.init();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, Settings.FONT_ROBOTO_LIGHT));
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}