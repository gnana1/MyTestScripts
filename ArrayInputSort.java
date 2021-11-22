import java.util.Scanner;

    public class ArrayInputSort {
        public static void main(String[] args) {

            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the number of elements you want in Array 1: ");
            //reading the number of elements from the that we want to enter
            int n=sc.nextInt();
            //creates an array in the memory of length 10
            int[] array1 = new int[n];
            System.out.println("Enter the elements of the array: ");

            for(int i=0; i<n; i++)
                {
                //reading array elements from the user
                array1[i]=sc.nextInt();
                }
            System.out.println("Array1 elements are: ");
            // accessing array elements using the for loop
            for (int i=0; i<n; i++)
                {
                System.out.print(array1[i]+" ");
                }

            System.out.println("\n"+"Enter the number of elements you want in Array 2: ");
            //reading the number of elements from the that we want to enter
            int m=sc.nextInt();
            //creates an array in the memory of length 10
            int[] array2 = new int[m];
            System.out.println("Enter the elements of the array: ");

            for(int i=0; i<m; i++)
                {
                    //reading array elements from the user
                    array2[i]=sc.nextInt();
                }
            System.out.println("Array2 elements are: ");
            // accessing array elements using the for loop
            for (int i=0; i<m; i++)
                {
                    System.out.print(array2[i]+" ");
                }

            // Define and initialize the combined Array
            int k = array1.length + array2.length;
            int[] array3 = new int[k];

            for (int i = 0; i < array1.length; i++)
                {
                    array3[i]=array1[i];
                }

            for(int i=array1.length;i<k;i++){

                array3[i]=array2[i-array1.length];

            }
            System.out.println("\n"+"combined Array: ");
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
