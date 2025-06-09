public class PatternMatch {

    public int patternMatch(String a, String b) {
        int size = b.length();
        int iterations = 0;
        int instructions = 0;
        long startTime = System.nanoTime();

        System.out.println("");
        System.out.println("______________________________");
        System.out.println("Minha Resolucao");
        System.out.println("String a size: " + a.length());
        System.out.println("String b size: " + size);
        System.out.println("");


        for (int i = 0; i <= a.length() - size; i++) {
            iterations++;
            instructions++;
            if (a.substring(i, i + size).equals(b)) {
                instructions++;

                long endTime = System.nanoTime();
                print(iterations, instructions, endTime - startTime, i);

                return i;
            }
            instructions++;
        }

        instructions++;

        long endTime = System.nanoTime();
        print(iterations, instructions, endTime - startTime, -1);

        return -1;
    }



    public int search(String txt, String pat) {
        int M = pat.length();
        int N = txt.length();
        long patHash = hash(pat, M);
        int iterations = 0;
        int instructions = 0;
        long startTime = System.nanoTime();

        System.out.println("");
        System.out.println("______________________________");
        System.out.println("Rabin-Karp");
        System.out.println("String txt size: " + N);
        System.out.println("String pat size: " + M);
        System.out.println("");

        for (int i = 0; i <= N - M; i++) {
            iterations++;
            instructions++;
            long txtHash = hash(txt.substring(i, i + M), M);
            instructions++;
            if (patHash == txtHash) {
                instructions++;
                if (txt.substring(i, i + M).equals(pat)) {
                    instructions++;

                    long endTime = System.nanoTime();
                   print(iterations, instructions, endTime - startTime, i);

                    return i;
                }

            }

        }

        instructions++;

        long endTime = System.nanoTime();
        print(iterations, instructions, endTime - startTime, -1);

        return N;
    }

    private static final int R = 256;
    private static final int Q = 2147483647;
    private long hash(String s, int M) {
        long h = 0;
        for (int j = 0; j < M; j++)
            h = (h * R + s.charAt(j)) % Q;
        return h;
    }




    void KMPSearch(String txt, String pat) {
        int M = pat.length();
        int N = txt.length();
        int iterations = 0;
        int instructions = 0;
        long startTime = System.nanoTime();

        System.out.println("");
        System.out.println("______________________________");
        System.out.println("Knuth-Morris-Pratt");
        System.out.println("String txt size: " + N);
        System.out.println("String pat size: " + M);
        System.out.println("");


        int lps[] = new int[M];
        instructions++;
        computeLPSArray(pat, M, lps);
        instructions++;

        int i = 0;
        int j = 0;
        instructions += 2;

        while (i < N) {
            iterations++;
            instructions++;

            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
                instructions += 2;
            }

            if (j == M) {
                instructions++;
                long endTime = System.nanoTime();
                print(iterations, instructions, endTime - startTime, i - j);
                j = lps[j - 1];
                instructions++;
                return ;
            } else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                instructions += 2;
                if (j != 0) {
                    j = lps[j - 1];
                    instructions++;
                } else {
                    i++;
                    instructions++;
                }
            }
        }

        long endTime = System.nanoTime();
        print(iterations, instructions, endTime - startTime, -1);
    }

        void computeLPSArray(String pat, int M, int lps[]) {
            // tamanho do maior prefixo sufixo anterior
            int len = 0;
            int i = 1;
            lps[0] = 0; // lps[0] is always 0

            // loop calcula lps[i] for i = 1 to M-1
            while (i < M) {
                if (pat.charAt(i) == pat.charAt(len)) {
                    len++;
                    lps[i] = len;
                    i++;
                } else // (pat[i] != pat[len])
                {
                    if (len != 0) {
                        len = lps[len - 1];
                    } else // if (len == 0)
                    {
                        lps[i] = len;
                        i++;
                    }
                }
            }
        }



    public void print(int iteraction, int instructions, long time, int position) {
        System.out.println("Iteracoes: " + iteraction);
        System.out.println("Instrucoes: " + instructions);
        System.out.println("Execution time: " + time + " ns");
        if (position == -1)
            System.out.println("position = not_found");
        else
            System.out.println("position = " + position);
        System.out.println("______________________________");
    }
}