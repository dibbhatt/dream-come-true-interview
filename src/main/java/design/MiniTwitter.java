package design;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

class Tweet {
	 public static int gid = 0;
     public int id;
     public int user_id;
     public String text;
     
     public Tweet(int id, int user_id, String text) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.text = text;
	}
     
     public static Tweet create(int user_id, String tweet_text) {
         return new Tweet(gid++, user_id, tweet_text);
     }
}

public class MiniTwitter {
    
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, Tweet> tweetMap; 
    private Map<Integer, List<Integer>> timeLineMap;
    

    public MiniTwitter() {
        // initialize your data structure here.
        followMap = new HashMap<Integer, Set<Integer>>();
        tweetMap = new HashMap<Integer, Tweet>();
        timeLineMap = new HashMap<Integer, List<Integer>>();
    }

    // @param user_id an integer
    // @param tweet a string
    // return a tweet
    public Tweet postTweet(int user_id, String tweet_text) {
        int tweetId = tweetMap.keySet().size();
        
        Tweet tweet = Tweet.create(user_id, tweet_text);
        tweetMap.put(tweetId, tweet);
        if (!timeLineMap.containsKey(user_id)) {
        	timeLineMap.put(user_id, new LinkedList<Integer>());
        }
        timeLineMap.get(user_id).add(0, tweetId);
        return tweet;
    }

    private List<Integer> getTopKTweetId(int user_id, int k) {
    	LinkedList<Integer> result = new LinkedList<Integer>();
    	if (!timeLineMap.containsKey(user_id)) {
    		return result;
    	}
        List<Integer> all = timeLineMap.get(user_id);
        List<Integer> sub = null;
        if (all.size() >= k) {
            sub = all.subList(0, k);
        } else {
            sub = all;
        }
        result.addAll(sub);
        return result;
    }

    // @param user_id an integer
    // return a list of 10 new feeds recently
    // and sort by timeline
    public List<Tweet> getNewsFeed(int user_id) {
    	List<Integer> tweetIdList = getTopKTweetId(user_id, 10);
    	if (followMap.containsKey(user_id)) {
    		for (Integer fid : followMap.get(user_id)) {
    			List<Integer> sub = getTopKTweetId(fid, 10);
    			tweetIdList.addAll(sub);
    		}
    	}
    	Set<Integer> set = new HashSet<Integer>();
    	set.addAll(tweetIdList);
    	tweetIdList = new LinkedList<Integer>(set);
    	
        Collections.sort(tweetIdList, Collections.reverseOrder());
        List<Tweet> result = new LinkedList<Tweet>();
        // Join
        int count = 0;
        for (Integer tweetId : tweetIdList) {
            result.add(tweetMap.get(tweetId));
            count++;
            if (count == 10) {
            	break;
            }
        }
        return result;
    }
        
    // @param user_id an integer
    // return a list of 10 new posts recently
    // and sort by timeline
    public List<Tweet>  getTimeline(int user_id) {
        if (!timeLineMap.containsKey(user_id)) {
            return new LinkedList<Tweet>();
        }
        List<Integer> sub = getTopKTweetId(user_id, 10);
        
        List<Tweet> result = new LinkedList<Tweet>();
        // Join
        for (Integer tweetId : sub) {
            result.add(tweetMap.get(tweetId));
        }
        return result;
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id follows to_user_id
    public void follow(int from_user_id, int to_user_id) {
        if (!followMap.containsKey(from_user_id)) {
            followMap.put(from_user_id, new HashSet<Integer>());
        }
        followMap.get(from_user_id).add(to_user_id);
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id unfollows to_user_id
    public void unfollow(int from_user_id, int to_user_id) {
        if (!followMap.containsKey(from_user_id)) {
            return;
        }
        followMap.get(from_user_id).remove(to_user_id);
    }
    
    @Test
    public void test() {
    	MiniTwitter mt = new MiniTwitter();
    	mt.postTweet(1, "LintCode is Good!!!");
    	mt.getNewsFeed(1);
    	mt.getTimeline(1);
    	mt.follow(2, 1);
    	mt.follow(2, 3);
    	mt.postTweet(3, "LintCode is Cool!!!");
    	mt.postTweet(3, "How to do A + B problem?");
    	mt.postTweet(3, "I have accepted A + B problem.");
    	mt.postTweet(3, "I favorite A + B problem.");
    	mt.postTweet(1, "I favorite A + B problem too.");
    	mt.postTweet(2, "Nani?");
    	mt.postTweet(2, "I want to solve this problem now.");
    	mt.postTweet(3, "I want to solve this problem now.");
    	mt.postTweet(3, "The problem is so easy.");
    	mt.postTweet(1, "hehe.");
    	mt.postTweet(2, "Let's to do it together.");
    	mt.postTweet(2, "haha");
    	mt.getNewsFeed(2);
    	mt.getTimeline(2);
    	mt.getNewsFeed(1);
    	mt.follow(1, 2);
    	mt.getNewsFeed(1);
    	mt.follow(1, 3);
    	mt.getNewsFeed(1);
    	mt.unfollow(2, 1);
    	mt.getNewsFeed(2);
    }
    
}
