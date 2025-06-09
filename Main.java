public class Main {
    public static void main(String[] args){
        PatternMatch p = new PatternMatch();

        System.out.println("Caso 80");
        String a = "abcdefghijABCDEFGHIJabcdefghijABCDEFGHIJabcdefghijABCDEFGHIJabcdefghijABCDEFGHIJ";
        String b = "defghijABCD";

        p.patternMatch(a,b);
        p.search(a,b);
        p.KMPSearch(a, b);


        System.out.println("Caso 1000");
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < 500; i++) sb2.append("A");
        sb2.append("PATTERN_TO_MATCH");
        for (int i = 0; i < 1480; i++) sb2.append("B");
        String text2 = sb2.toString();

        String pattern2 = "PATTERN_TO_MATCH";

        p.patternMatch(text2,pattern2);
        p.search(text2,pattern2);
        p.KMPSearch(text2, pattern2);


        System.out.println("Caso 500000");
        StringBuilder sb3 = new StringBuilder();
        for (int i = 0; i < 30500; i++) sb3.append("Lorem ipsum ");
        sb3.append("SPECIAL_PATTERN_HERE");
        for (int i = 0; i < 8650; i++) sb3.append(" dolor sit amet");
        String text3 = sb3.toString();

        String pattern3 = "SPECIAL_PATTERN_HERE";

        p.patternMatch(text3,pattern3);
        p.search(text3,pattern3);
        p.KMPSearch(text3, pattern3);


        System.out.println("Caso 500000 - not found");
        String pattern30 = "Not_Found";

        p.patternMatch(text3,pattern30);
        p.search(text3,pattern30);
        p.KMPSearch(text3, pattern30);

        System.out.println("Caso 1000000");
        StringBuilder sb4 = new StringBuilder();
        for (int i = 0; i < 500000; i++) sb4.append("A");
        sb4.append("PATTERN_TO_MATCH");
        for (int i = 0; i < 500000; i++) sb4.append("B");
        String text4 = sb4.toString();

        String pattern4 = "PATTERN_TO_MATCH";
        p.patternMatch(text4,pattern4);
        p.search(text4,pattern4);
        p.KMPSearch(text4, pattern4);

    }
}
