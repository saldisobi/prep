package amazon;

public class RobotMovement {

    public boolean judgeCircle(String moves) {
        int x = 0 ;
        int y = 0;

        for(int i = 0; i < moves.length(); i++){
            if(moves.charAt(i) == 'U'){
                y++;
            }else if(moves.charAt(i) == 'D'){
                y--;
            }else if(moves.charAt(i) == 'L'){
                x--;
            }else if(moves.charAt(i) == 'R'){
                x++;
            }else{
                return false;
            }
        }

        return (x == 0 && y == 0);

    }


    public static void main(String args[]){
        System.out.println(new RobotMovement().judgeCircle("UD"));
    }
}
