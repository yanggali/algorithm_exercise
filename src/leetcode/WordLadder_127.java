package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder_127 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(){{
            add("hot");
            add("dot");
            add("dog");
            add("lot");
            add("cog");
        }};
        System.out.println(ladderLength("hit","cog",list));
    }

    public static int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)){
            return 0;
        }
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        int len = 1;
        Set<String> visited = new HashSet<>();
        while (!beginSet.isEmpty() && !endSet.isEmpty()){
            if (beginSet.size() > endSet.size()){
                Set<String> set = endSet;
                endSet = beginSet;
                beginSet = set;
            }

            Set<String> temp = new HashSet<>();
            for (String begin : beginSet) {
                char[] beginArr = begin.toCharArray();
                for (int i = 0;i <begin.length();i++){
                    for (char c = 'a'; c < 'z';c++){
                        char old = beginArr[i];
                        beginArr[i] = c;

                        String newWord = String.valueOf(beginArr);
                        if (endSet.contains(newWord)){
                            return len+1;
                        }

                        if (!visited.contains(newWord) && wordList.contains(newWord)){
                            temp.add(newWord);
                            visited.add(newWord);
                        }
                        beginArr[i] = old;
                    }
                }
            }
            beginSet = temp;
            len++;
        }
        return 0;
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)){
            return 0;
        }
        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        startSet.add(beginWord);
        endSet.add(endWord);
        int len = 1;

        Set<String> visited = new HashSet<>();
        while (!startSet.isEmpty() && !endSet.isEmpty()) {
            if (startSet.size() > endSet.size()) {
                Set<String> set = endSet;
                endSet = startSet;
                startSet = set;
            }

            Set<String> temp = new HashSet<>();
            for (String start : startSet) {
                char[] startArr = start.toCharArray();

                for (int i = 0; i < startArr.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char oldChar = startArr[i];
                        startArr[i] = c;
                        String newNode = String.valueOf(startArr);

                        if (endSet.contains(newNode)) {
                            return len + 1;
                        }
                        if (!visited.contains(newNode) && wordList.contains(newNode)) {
                            temp.add(newNode);
                            visited.add(newNode);
                        }
                        startArr[i] = oldChar;
                    }
                }
            }
            startSet = temp;
            len++;
        }
        return 0;
    }
}
