package amazon;

class AppendNumberZalando {
    public int solution(int N) {

        String input = String.valueOf(N);

        if (input.charAt(0) == '-') {
            //negative number here
            input = input.substring(0, 1) + '5' + input.substring(1);

            return Integer.parseInt(input);
        }

        for (int i = 0; i < input.length(); i++) {
            if (Character.getNumericValue(input.charAt(i)) <= 5) {
                input = input.substring(0, i) + '5' + input.substring(i);
                return Integer.parseInt(input);
            }
        }
        return Integer.parseInt(input);
    }

    public static void main(String args[]){
        System.out.println(new AppendNumberZalando().solution(268));
        System.out.println(new AppendNumberZalando().solution(670));
        System.out.println(new AppendNumberZalando().solution(0));
        System.out.println(new AppendNumberZalando().solution(-999));
    }
}