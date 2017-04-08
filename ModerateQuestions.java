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

}
