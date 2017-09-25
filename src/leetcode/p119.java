package leetcode;
import java.util.*;
public class p119 {
	public static List<Integer> getRow2(int rowIndex) {
	    List<Integer> ret = new ArrayList<Integer>();
	    ret.add(1);
	    int a;
	    for (int i = 1; i <= rowIndex; i++) {
	        for (int j = i - 1; j >= 1; j--) {
	            int tmp = ret.get(j - 1) + ret.get(j);
	            a = ret.get(j);
	            ret.set(j, tmp);
	        }
	        ret.add(1);
	    }
	    return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> res = new ArrayList<>();
		res = getRow2(3);
		System.out.println(res);
		System.out.println(0 & 7);
	}

}
