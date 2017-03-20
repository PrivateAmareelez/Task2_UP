package part2.action;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextDateExtractor implements TextExtractor {
    @Override
    public List<String> extract(String text) {
        Pattern pattern = Pattern.compile("((0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d)");
        Matcher matcher = pattern.matcher(text);

        ArrayList<String> substrings = new ArrayList<>();
        while (matcher.find()) {
            substrings.add(matcher.group());
        }

        return substrings;
    }
}
