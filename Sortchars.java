public class Sortchars {

    public static void main(String[] args) {
        char[] array1 = {'d','f','a','c'};
        char[] array2 = {'g','n','a','n','b'};
        int n = array1.length + array2.length;
        char[] array3 = new char[n];
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
                    char temp = array3[j];
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
