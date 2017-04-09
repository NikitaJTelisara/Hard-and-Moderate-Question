public class ModerateQuestions {
    public static void main(String[] args) {
        System.out.println("Swap numbers");
        swap2No(-7, 9);
        int[] a ={1,2,3,4,5,6,7,8,9};
        shufflecard(a);
        System.out.println("Shuffled cards");
        for(int a1:a){
            System.out.println(a1);
        }
        int[] a2 ={1,2,3,4,5,6,7,8,9};
        shufflecardRecur(a2,a2.length-1);
        System.out.println("Shuffled cards Recursive");
        for(int a11:a2){
            System.out.println(a11);
        }

        System.out.println("get tic tac toe winner for 3*3");
        int[][] m = {{1, 0, 2},
                {0, 0, 1},
                {1, 0, 2}};

        int res = getTicTactToeWinner(m);
        System.out.println(res);

        int[][] m1 = {{1, 0, 1},
                {0, 1, 1},
                {1, 0, 0}};

        res = getTicTactToeWinner(m1);
        System.out.println(res);

        int[][] m3 = {{1, 0, 1},
                {0, 0, 1},
                {1, 1, 1}};

        res = getTicTactToeWinner(m3);
        System.out.println(res);

        int[][] m4 = {{1, 1, 1, 1},
                {0, 1, 1, 0},
                {1, 1, 1, 0},
                {1, 0, 2, 2}};

        System.out.println("get tic tac toe winner for N*N");
        res = getTicTactToeWinnerForNByN(m4);
        System.out.println(res);
    }

    /*17.1 Write a function that adds two numbers. You should not use + or any arithmetic operators. */
    public static void swap2No(int a, int b) {
        System.out.println("a " + a);
        System.out.println("b " + b);
        b = a + b;
        a = b - a;
        b = b - a;
        System.out.println("a " + a);
        System.out.println("b " + b);
    }

    /* 18.2 shuffle a deck of cards */

    /* iterative */
    public static void shufflecard(int[] cards) {
        for (int i = 0; i < cards.length; i++) {
            //randomly swap it with an element in the array
            int k = randomswap(0, i);
            int temp = cards[i];
            cards[i] = cards[k];
            cards[k] = temp;
        }
    }

    public static int[] shufflecardRecur(int[] cards, int i) {
        if(i==0){return cards;}
        shufflecardRecur(cards,i-1);
        int  k = randomswap(0,i);
        int temp = cards[i];
        cards[i] = cards[k];
        cards[k] = temp;
        return cards;
    }

    public static int randomswap(int low, int high) {
        return (low + (int) (Math.random() * high - low + 1));
    }

    /* 0 -o
      1 -x
      2- empty
      return 3 if nobody won
      for 3*3 board
    */
    // 17.2
    public static int getTicTactToeWinner(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            /* check row */
            if (m[i][0] != 2 && m[i][0] == m[i][1] && m[i][1] == m[i][2]) {
                return m[i][0];
            }
            /* check col */
            if (m[0][i] != 2 && m[1][i] == m[1][i] && m[1][i] == m[2][i]) {
                return m[0][i];
            }

        }

        /* check diagonal */
        if (m[0][0] != 0 && m[0][0] == m[1][1] && m[1][1] == m[2][2]) {
            return m[0][0];
        }
        if (m[2][0] != 0 && m[2][0] == m[1][1] && m[1][1] == m[0][2]) {
            return m[2][0];
        }
        return 3;
    }

    /* 0 -o
      1 -x
      2- empty
      return 3 if nobody won
      for N*N board
    */
    public static int getTicTactToeWinnerForNByN(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            int x = m[i][0];
            if (x != 2) {
                for (int j = 0; j < m.length; j++) {
                    if (x != m[i][j]) {
                        break;
                    }
                    if (j == m.length - 1) {
                        return m[i][j];
                    }
                }
            }
            x = m[0][i];
            if (x != 2) {
                for (int j = 0; j < m.length; j++) {
                    if (x != m[j][i]) {
                        break;
                    }
                    if (j == m.length - 1) {
                        return m[j][i];
                    }
                }
            }
        }


        /* check diagonals */
        int x = m[0][0];
        if (x != 2) {
            for (int i = 1; i < m.length; i++) {
                if (x != m[i][i]) {
                    break;
                }
                if (i == m.length - 1) {
                    return m[0][0];
                }
            }

        }
        /* for rever diagonal m[k--][k++]*/
        int k = m.length - 1;
        x = m[k][0];
        if (x != 2) {
            for (int i = 1; i < m.length; i++) {
                if (x != m[k--][k++]) {
                    break;
                }
                if (i == m.length - 1) {
                    return m[k][0];
                }
            }

        }

        return 3;
    }
}
