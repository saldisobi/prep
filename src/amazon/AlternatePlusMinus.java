package amazon;

class AlternatePlusMinus {
    public String solution(int N) {
        StringBuilder sb = new StringBuilder();

       for(int i =0;i < N ; i ++){
           if(i % 2 == 0){
               sb.append('+');
           }else{
               sb.append('-');
           }
       }

       return sb.toString();
    }
}