public class SearchandCount {
    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,6};
        int[] array2 = {9,8,7,6};
        int k=6;
        int count=0;
        int n = array1.length + array2.length;
        int[] array3 = new int[n];
        for (int i = 0; i < array1.length; i++) {
            array3[i]=array1[i];
        }
        for(int i=array1.length;i<n;i++){

            array3[i]=array2[i-array1.length];

        }
        for(int i=0; i<array3.length; i++)
        {
            System.out.print(array3[i]+" ");
        }
        for(int i=0; i<array3.length; i++)
        {
            if (array3[i]==k) {
                System.out.println("\n"+ "position of K is "+i);
                count++;
            }

        }
        System.out.println("\n"+"No.of times Element K is repeated: "+count);
    }
}
