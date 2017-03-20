package action;

import javax.swing.*;
import java.util.regex.Pattern;

public class TextProcessor {
    private JComboBox type;

    public TextProcessor(JComboBox comboBox) {
        type = comboBox;
    }

    public boolean check(String s) {
        switch ((String) type.getSelectedItem()) {
            case "Natural number": {
                Pattern naturalNumber = Pattern.compile("\\+?[1-9][0-9]*");
                return naturalNumber.matcher(s).matches();
            }
            case "Integer": {
                Pattern integerNumber = Pattern.compile("0|([-+]?[1-9][0-9]*)");
                return integerNumber.matcher(s).matches();
            }
            case "Float": {
                Pattern integerNumber = Pattern.compile("0|([-+]?[1-9][0-9]*)");
                Pattern floatNumber = Pattern.compile("[-+]?(0|[1-9]\\d*)[.,][0-9]*");
                Pattern floatNumberExp = Pattern.compile("[-+]?[0-9]*[.,]?[0-9]+([eE][-+]?[0-9]+)?");
                return floatNumber.matcher(s).matches() || floatNumberExp.matcher(s).matches() ||
                        integerNumber.matcher(s).matches();
            }
            case "E-mail": {
                Pattern email = Pattern.compile("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}");
                return email.matcher(s.toLowerCase()).matches();
            }
            case "Date": {
                Pattern date = Pattern.compile("(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d");
                return date.matcher(s).matches();
            }
            case "Time": {
                Pattern time = Pattern.compile("(0\\d|1\\d|2[0-3]):[0-5]\\d:[0-5]\\d");
                return time.matcher(s).matches();
            }
            default: {
                return false;
            }
        }
    }

}
