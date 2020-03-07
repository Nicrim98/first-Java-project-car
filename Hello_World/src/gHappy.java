public class gHappy {
    public static boolean gHappy(String str) {
        //klasa sprawdzajaca czy w slowie  wszystkie literki 'g' maja chociaz jedno 'g' sasiadujace
        boolean a = true;  // ustawiona flaga na false
        int b = str.lastIndexOf('g'); // sprawdzenie gdzie g występuje ostatni raz
        StringBuffer s = new StringBuffer(str);
        s.append(" ");
        for (int i = 0; i < b; i++) {
            if (s.charAt(i) != 'g' && s.charAt(i + 1) == 'g' && s.charAt(i + 2) != 'g') {
                a = false;
                break;
            } // sprawdzenie czy gdzies g jest samo
        }
        if (str.length() == 1) {
            a = false;
        } // jeżeli podany string jest jedno literowy to nie moze byc on happy
        return a;
    }
}