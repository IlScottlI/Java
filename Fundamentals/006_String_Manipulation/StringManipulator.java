public class StringManipulator {
    public String trimAndConcat(String i, String j) {
        return i.trim() + j.trim();
    }
    public Integer getIndexOrNull(String k, char l) {
        if (k.indexOf(l) > 0) {
            return k.indexOf(l);
        } else {
            return null;
        }
    }
    public Integer getIndexOrNull(String word, String s) {
        if (word.indexOf(s) > 0) {
            return word.indexOf(s);
        } else {
            return null;
        }
    }
    public String concatSubstring(String string1, int start, int end, String string2) {
        
        return string1.substring(start,end) + string2;
    }
}