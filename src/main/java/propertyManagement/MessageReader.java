package propertyManagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessageReader {

    private MessageReader(){

    }

    private static final Logger logger = LoggerFactory.getLogger(MessageReader.class);
    private static ResourceBundle resourceBundle;
    private static final String languageCode;
    private static final String countryCode;
    private static final Locale locale;

    static {
        logger.info("Message Reader Loaded...");
        languageCode = ApiProperties.getProperty("language.code",Locale.ENGLISH.getLanguage());
        countryCode = ApiProperties.getProperty("country.code",Locale.ENGLISH.getCountry());
        locale = new Locale(languageCode,countryCode);
        loadResourceBundle();
    }

    private static void loadResourceBundle(){
        if(resourceBundle == null){
            resourceBundle = ResourceBundle.getBundle("messages",locale);
        }
    }

    public static String getMessage( String key)  {
        return  resourceBundle.getString(key);
    }

    public static String getDynamicMessage(String key,String... params) {
        String msg = getMessage(key);
        return MessageFormat.format(msg,params);
    }

}
