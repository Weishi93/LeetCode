package leetcode;

import java.util.*;

/**
 * Created by Wei Shi on 11/10/16.
 */
public class p127 {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        wordList.add(endWord);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
//        Set<String> visited = new HashSet<>();
//        if (isTrans(beginWord,endWord)) return 2;
//        if (beginWord.equals(endWord)) return 1;
//        if (wordList.isEmpty()) return 0;
        int depth = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String s = q.poll();
                if (s.equals(endWord)) return depth + 1;
//                for(int j = 0; j < s.length(); j++){
//                    char[] word = s.toCharArray();
//                    for(char ch = 'a'; ch < 'z'; ch++){
//                        word[j] = ch;
//                        String check = new String(word);
//                        if(!check.equals(s) && wordList.contains(check)){
//                            q.add(check);
//                            wordList.remove(check);
//                        }
//                    }
//                }
                List<String> list = getTrans(s, wordList);
                for (String tmp : list) {
                    q.add(tmp);
                    wordList.remove(tmp);

                }
            }
            depth++;
        }
        return depth;
    }

    private List<String> getTrans(String word, Set<String> wordList) {
        List<String> list = new ArrayList<>();
        Iterator<String> it = wordList.iterator();
        while (it.hasNext()) {
            String tmp = it.next();
            if (isTrans(word, tmp)) {
                list.add(tmp);
            }
        }
        return list;
    }

    private boolean isTrans(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) diff++;
        }
        return diff == 1;
    }

    public static void main(String[] args) {
        p127 some = new p127();
        Set<String> wordList = new HashSet<>();
        wordList.add("ts");
        wordList.add("sc");
        wordList.add("ph");
        wordList.add("ca");
        wordList.add("cf");
        wordList.add("jr");
        wordList.add("hf");
        wordList.add("to");
        wordList.add("if");
        wordList.add("ha");
        wordList.add("is");
        wordList.add("io");
        wordList.add("ta");
        System.out.println(some.ladderLength("ta", "if", wordList));
//        System.out.println(some.getTrans("ha", wordList));
    }

}
