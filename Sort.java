public class Sort {

    public static void main(String[] args) {

        int[] array1 = {1,2,3,4,5};
        int[] array2 = {9,8,7,6};
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
            for (int j=i+1;j<array3.length; j++){
                if (array3[i] > array3[j]){
                    int temp = array3[j];
                    array3[j] = array3[i];
                    array3[i] = temp;
                }
            }
        }
        System.out.println("\n"+"Sorted Combined Array:");
        for(int i=0; i<array3.length; i++)
        {
            System.out.print(array3[i]+" ");
        }
    }

}