
import java.util.HashMap;
public class MajorityElementHashmap {

    /* Program for finding out majority element in an array */

    private static void findMajority(int[] arr)
        {
            HashMap<Integer,Integer> map = new HashMap<>();

            for(int i = 0; i < arr.length; i++) {
                if (map.containsKey(arr[i])) {
                    int count = map.get(arr[i]) +1;
                    if (count > arr.length /2) {
                        System.out.println("Majority element is " + arr[i]);
                        return;
                    } else
                        map.put(arr[i], count);

                }
                else
                    map.put(arr[i],1);
            }
            System.out.println("Majority element does not exist");
        }


        /* Driver program to test the above functions */
        public static void main(String[] args)
        {
            int[] arr = new int[] {1,3,4,4,1,4,4};

            findMajority(arr);
        }

}
