

public class queens {
    
// tnb : total no of boxes
//tnq : total no of queens
// bno : box number
// qno : queen no    
public static int queenCombination(int tnb, int tnq, int bno, int qno, String ans){

    if(qno == tnq){
        System.out.println(ans);
        return 1;
    }

    int count =0;

    for(int i = bno ; i<tnb ; i++){
        count += queenCombination(tnb, tnq, i+1, qno+1, ans+ "b"+ String.valueOf(i) + "q" + String.valueOf(qno)+" ");
    }

    return count;

}

//=====================================================================//

public static void queenCombination_(){
    int tnb =4;
    int tnq =3;
    // boolean [] boxes = false;

    System.out.println(queenCombination(tnb, tnq, 0, 0, ""));


}


   public static void main(String[] args) {
    queenCombination_();
    }
}
