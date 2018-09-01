import java.util.Arrays;

public class test {
	static int[] a = {1,3,4,6,7,8,9,10};
	static int[] b = {2,4,6,8,10};
	static int[] c = {5,6,7,8,9,11,12,13,14};

	static int[][] xx = {a, b, c, {6, 8, 9, 10}};

	public static int[] mergeInt(int[][]arr) {
		int[] newArr= new int[0];
		
		if (arr.length < 2)
			return arr[0];

		for(int i = 0, j = 0; i < arr[0].length && j < arr[1].length; )
		{
			//System.out.println("arr[0]["+i+"] = "+arr[0][i]+", arr[1]["+j+"] = "+arr[1][j]);
			if (arr[0][i] < arr[1][j])
			{
				i+=1;
			}
			else if (arr[0][i] > arr[1][j])
			{
				j+=1;
			}
			else // arr[0][i] == arr[1][j]
			{
				newArr  = Arrays.copyOf(newArr, newArr.length + 1);
				newArr[newArr.length - 1] = arr[0][i];
				i+=1;
				j+=1;
			}
		}

		arr[1] = newArr;
		
		return mergeInt(Arrays.copyOfRange(arr, 1, arr.length));
	}

	public static void main(String []args) {
   		System.out.println(xx.length);
		int[] ret = mergeInt(xx);

   		System.out.println(Arrays.toString(ret));
	}
}
