public class bobthere {
    static class bobThere {
        public static boolean bobThere(String str) {
            boolean a = false;
            for (int i = 0; i < str.length(); i++) {
                if (i + 2 <= str.length() - 1) {
                    if (str.charAt(i) == 'b' && str.charAt(i + 2) == 'b') {
                        a = true;
                        break;
                    }
                }
            }
            return a;
        }
    }
}