import java.util.Arrays;

public class test_for {
	static int[] a = {1,3,4,6,7,8,9,10};
	static int[] b = {2,4,6,8,10};
	static int[] c = {5,6,7,8,9,11,12,13,14};

	static int[][] xx = {a, b, c};

	public int[] mergeInt(int[][]arr) {
		int[] newArr= new int[0];
		
		for(int i = 0, j = 0; i < arr[0].length && j < arr[1].length; )
		{
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
		
		return newArr;
	}

	public static void main(String []args) {
		test_for t = new test_for();
		int[] ret = xx[0];

		System.out.println("xx array len = " + xx.length);
		for (int i = 0; i < xx.length - 1; i++)
		{
			System.out.println("process array index: " + i);
			int[][] arry = {ret, xx[i+1]};
			ret = t.mergeInt(arry);
		}

		System.out.println(Arrays.toString(ret));
	}
}
