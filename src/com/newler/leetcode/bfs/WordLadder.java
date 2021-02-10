package com.newler.leetcode.bfs;
// [127]、单词接龙
// 2021年2月10日11:39:28
//字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列： 
//
// 
// 序列中第一个单词是 beginWord 。 
// 序列中最后一个单词是 endWord 。 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典 wordList 中的单词。 
// 
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中
//的 单词数目 。如果不存在这样的转换序列，返回 0。 
// 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有字符串 互不相同 
// 
// Related Topics 广度优先搜索 
// 👍 691 👎 0


import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        List<String> wordList =  Arrays.asList("ymann","yycrj","oecij","ymcnj","yzcrj","yycij","xecij","yecij","ymanj","yzcnj","ymain");
        new Solution().ladderLength("ymain", "oecij", wordList);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Queue<String> queue = new LinkedList<>();
            HashSet<String> wordSet = new HashSet<>(wordList);
            int step = 1;
            if (!wordList.contains(endWord)) return 0;
            queue.add(beginWord);
            wordSet.remove(beginWord);
            while (!queue.isEmpty()) {
                step++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    char[] word = queue.poll().toCharArray();
                    for (int j = 0; j < word.length; j++) {
                        char oldChar = word[j];
                        for (int k = 0; k < 26; k++) {
                            word[j] = (char) ('a' + k);
                            String newWord = new String(word);
                            if (newWord.equals(endWord)) return step;
                            if (wordSet.contains(newWord)) {
                                System.out.println(newWord +"--" + step);
                                wordSet.remove(newWord);
                                queue.add(newWord);
                            }
                        }
                        word[j] = oldChar;
                    }
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

