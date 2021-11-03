package com.newler.leetcode.desgin;
// [355]、设计推特
// 2020年4月13日09:49:49
//设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个
//功能： 
//
// 
// postTweet(userId, tweetId): 创建一条新的推文 
// getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
//
// follow(followerId, followeeId): 关注一个用户
// unfollow(followerId, followeeId): 取消关注一个用户
//
//
// 示例:
//
// 
//Twitter twitter = new Twitter();
//
//// 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
//twitter.postTweet(1, 5);
//
//// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//twitter.getNewsFeed(1);
//
//// 用户1关注了用户2.
//twitter.follow(1, 2);
//
//// 用户2发送了一个新推文 (推文id = 6).
//twitter.postTweet(2, 6);
//
//// 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
//// 推文id6应当在推文id5之前，因为它是在5之后发送的.
//twitter.getNewsFeed(1);
//
//// 用户1取消关注了用户2.
//twitter.unfollow(1, 2);
//
//// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//// 因为用户1已经不再关注用户2.
//twitter.getNewsFeed(1);
// 
// Related Topics 堆 设计 哈希表



import java.util.*;

import static java.lang.System.nanoTime;
import static java.lang.System.out;


public class DesignTwitter {
    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 4);
        twitter.postTweet(2, 5);
//        twitter.getNewsFeed(1);
        twitter.follow(1, 2);
//        twitter.postTweet(2, 6);
//        twitter.getNewsFeed(1);
//        twitter.unfollow(1, 2);
        twitter.getNewsFeed(1);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 - o2 > 0) return -1;
                if (o1.equals(o2)) return 0;
                return 1;
            }
        });
        List<Integer> list1 = new ArrayList<>();
        list1.add(4);
        List<Integer> list2 = new ArrayList<>();
        list2.add(5);
        priorityQueue.addAll(list1);
        priorityQueue.addAll(list2);
//        priorityQueue.add(1);
//        priorityQueue.add(5);
        priorityQueue.forEach(out::println);
        priorityQueue.poll();

//        priorityQueue.addAll(list1);
        priorityQueue.forEach(out::println);
    }

    static class Twitter {
        Map<Integer, LinkedList<Post>> twitterMap;
        Map<Integer, Set<Integer>> followUserMap;
         /**
         * Initialize your data structure here.
         */
        public Twitter() {
            twitterMap = new HashMap<>();
            followUserMap = new HashMap<>();
        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId) {
            Post post = new Post(tweetId, nanoTime());

            if (twitterMap.containsKey(userId)) {
                twitterMap.get(userId).addFirst(post);
            } else {
               LinkedList<Post> twitters = new LinkedList<>();
                twitters.addFirst(post);
                twitterMap.put(userId, twitters);
            }
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId) {
            PriorityQueue<Post> priorityQueue = new PriorityQueue<>((o1, o2) -> {
                if (o1.createTime - o2.createTime > 0)
                    return -1;
                if (o1.createTime - o2.createTime == 0)
                    return 0;
                return 1;
            });

            if (twitterMap.containsKey(userId)) {
                priorityQueue.addAll(twitterMap.get(userId));
            }
            if (followUserMap.containsKey(userId)) {
                Set<Integer> followees = followUserMap.get(userId);

                for (Integer followee : followees) {
                    if (twitterMap.containsKey(followee)) {
                        if (twitterMap.containsKey(followee) && followee != userId) {
                            priorityQueue.addAll(twitterMap.get(followee));
                        }
                    }
                }
            }

            List<Integer> tiwtters = new ArrayList<>(Math.min(priorityQueue.size(), 10));
            int length = Math.min(priorityQueue.size(), 10);
            for (int i = 0; i < length; i++) {
                if (priorityQueue.peek() != null) {
                    tiwtters.add(priorityQueue.poll().Id);
                }
            }
            return tiwtters;
        }

        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         */
        public void follow(int followerId, int followeeId) {
            if (followUserMap.containsKey(followerId)) {
                followUserMap.get(followerId).add(followeeId);
            } else {
                Set<Integer> followers = new LinkedHashSet<>();
                followers.add(followeeId);
                followUserMap.put(followerId, followers);
            }
        }

        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         */
        public void unfollow(int followerId, int followeeId) {
            if (followUserMap.containsKey(followerId)) {
                followUserMap.get(followerId).remove(Integer.valueOf(followeeId));
            }
        }

        class Post {
            public int Id;
            public long createTime;

            public Post(int id, long createTime) {
                Id = id;
                this.createTime = createTime;
            }
        }
    }

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

}

