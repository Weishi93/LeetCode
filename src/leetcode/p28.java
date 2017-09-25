package leetcode;
import java.util.*;
public class p28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "asasdsdasdsdasdasdasda";
		String b = "sdas";
		System.out.println(strStr(a, b));
//		for(int i = 0; i <= a.length() - 4; i++) {
//			System.out.println(a.substring(i, i + 4));
//		}
	}
	public static int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0) {
            return 0;
        }
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i <= haystack.length() - needle.length(); i++) {
            if(!map.containsKey(haystack.substring(i, i + needle.length()))) {
                map.put(haystack.substring(i, i + needle.length()), i);
            }
        }
        if(map.containsKey(needle)) {
            return map.get(needle);
        }
        return -1;
    }
}
