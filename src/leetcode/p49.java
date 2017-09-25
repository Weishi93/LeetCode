package leetcode;
import java.util.*;
public class p49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        int count = 0;
        List<List<String>> res = new ArrayList<>();
        HashMap<HashMap<Character, Integer>, Integer> map = new HashMap<>();
        for(String str : strs) {
            HashMap<Character, Integer> tmp = new HashMap<>();
            for(int i = 0; i < str.length(); i++) {
                if(!tmp.containsKey(str.charAt(i))) {
                    tmp.put(str.charAt(i), 1);
                } else {
                    tmp.replace(str.charAt(i), tmp.get(str.charAt(i)) + 1);
                }
            }
            if(!map.containsKey(tmp)) { // no such an anagram
                List<String> tmpList = new ArrayList<>();
                tmpList.add(str);
                map.put(tmp, count);
                res.add(count++, tmpList);
            } else { // yes we have this anagram
                res.get(map.get(tmp)).add(str);
            }
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		p49 a = new p49();
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat", "tab"};
		List<List<String>> res = a.groupAnagrams(strs);
		System.out.println(res.toString());
	}
}
