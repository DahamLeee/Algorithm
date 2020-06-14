package programmers_3_dfs_bfs_단어변환;

public class Solution {
	static boolean[] visited;
	static String begin1;
	static String target1;
	static String[] words1;
	static int MIN;
	
	public static void main(String[] args) {
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"}; // 문제 마다 바뀜
		int answer = solution("hit", "cog", words); // 문제 마다 바뀜
		System.out.println(answer);
	}
    public static int solution(String begin, String target, String[] words) { // 답안
        int answer = 0;
        
        begin1 = begin;
        target1 = target;
        words1 = words;
        visited = new boolean[words.length];
        // 필요한게 해당 단어를 썼는지 안썼는지 확인해줄 boolean 배열
        MIN = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++) {
        	// 
        	if(isOkay(begin, words[i])) { // 시작을 할 수 있다.
        		// 그러면 dfs 돌리는 거지
        		dfs(i, words[i], 1); // 몇 번을 누적했는지
        	}
        }
        System.out.println(MIN);
        answer = MIN == Integer.MAX_VALUE ? 0 : MIN;
        return answer;
    }
    public static void dfs(int idx, String word, int cnt) {
    	System.out.println("word : " + word + " , cnt : " + cnt);
    	if(word == target1) {
    		MIN = Math.min(MIN, cnt);
    		return;
    	}
    	
    	visited[idx] = true;
    	for(int i = 0; i < words1.length; i++) {
    		if(isOkay(word, words1[i]) && !visited[i]) {
    			dfs(i, words1[i], cnt + 1);
    		}
    	}
    	visited[idx] = false;
    	
    }
    public static boolean isOkay(String word, String word2) {
    	int cnt = 0;
    	for(int i = 0; i < word.length(); i++) {
    		if(word.charAt(i) != word2.charAt(i)) {
    			cnt++;
    		}
    		if(cnt > 2) {
    			return false;
    		}
    	}
    	if(cnt == 1) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    
}
