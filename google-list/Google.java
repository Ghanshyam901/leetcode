import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Collection;

public class Google{


    //332

    public boolean isSelfCrossing(int[] distance) {
        if(distance.length <= 3){
            return false;
        }
        
        int i =2;
        //spiraling 
        
        while(i <distance.length && distance[i] > distance[i-2]){
            i++;
        }
        
        if(i >= distance.length){
            return false;
        }
        
        //
        if(i >=4 && distance[i] >= distance[i-2]-distance[i-4] || (i ==3  && distance[i]==distance[i-2])){
            distance[i-1] -=distance[i-3];
        }
        
        i++;
        
        while(i< distance.length){
            if(distance[i] >=distance[i-2]){
                return true;
            }
            i++;
        }
        
        return false;
    }


    /// jump 2 lc: 45

    public int jump(int[] nums) {
        // int count =0;
        Integer [] dp = new Integer[nums.length];
            dp[nums.length-1] =0;    
            
        for(int i = nums.length-2; i>=0; i--){
            int steps = nums[i];
            
         int min = Integer.MAX_VALUE;
            for(int j =1; j<=steps && i+j < nums.length; j++){
                if(dp[i+j] != null && dp[i+j] < min){
                    min = dp[i+j];  
                    // count++;
                }
            }
            
            if(min != Integer.MAX_VALUE){
                dp[i] = min+1;
                // count++;
            }
        }
     
        
        return dp[0];
    }

    // 41 find missiing number

    public int firstMissingPositive(int[] nums) {
     
        int n = nums.length;
        
        for(int i =0; i<nums.length; i++){
            if(i+1 == nums[i])continue;
            
            if(nums[i] < 1 || nums[i] > n)continue;
            
            int idx1 = i;
            int idx2 = nums[i]-1;
            
            if(nums[idx2] == nums[idx1]) continue;
            
            int temp = nums[idx1];
            nums[idx1] = nums[idx2];
            nums[idx2] = temp;
            i--;
        }
        // int ans = -1;
        for(int i =0; i<n; i++){
            if(nums[i] != i+1) return i+1;
        }
        return n+1;
    }


    // 871. Minimum Number of Refueling Stops

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        
        if(startFuel >= target) return 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b-a));
        int i =0;
        int n= stations.length;
        int stop =0;
        int maxDis = startFuel;
        
        while(maxDis < target){
            while(i < n && stations[i][0] <= maxDis){
                pq.offer(stations[i++][1]);
            }
            
            if(pq.isEmpty()) return -1;
            maxDis +=pq.poll();
            stop++;
        }
        return stop;
    }
    //174. Dungeon Game

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0)
            return 0;
        HashMap<String, Integer> hm = new HashMap<>();
        
        return rec(0, 0, dungeon, hm);
    }
    
    private int rec(int i, int j, int[][] dungeon, HashMap<String, Integer> hm) {
        
        if(i >= dungeon.length || j >= dungeon[0].length)
            return Integer.MAX_VALUE;
        String key = i + "king"  + j;
        if(hm.containsKey(key))
             return hm.get(key);
        int next = Math.min(rec(i+1, j, dungeon, hm), rec(i, j+1, dungeon, hm));
    
        if(next == Integer.MAX_VALUE)
           next  = 1;
        
        int res = Math.max(next - dungeon[i][j], 1);
        hm.put(key, res);
        return res;
    }


    //630. Course Schedule III

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b) -> a[1]-b[1]);  ///srot the array by lastday
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b-a); // 
        
        int time =0;
        for(int [] course : courses){
            time+=course[0];
            queue.add(course[0]);
            if(time > course[1]) time-=queue.poll();
            
        }
        return queue.size()+1;
    }

///218. The Skyline Problem


        public List<List<Integer>> getSkyline(int[][] buildings) {
            List<List<Integer>> result = new ArrayList<>();
            List<int[]> height = new ArrayList<>();
            for (int[] b : buildings) {
                height.add(new int[]{b[0], -b[2]});
                height.add(new int[]{b[1], b[2]});
            }
            Collections.sort(height, (a, b) -> {
                if (a[0] != b[0])
                    return a[0] - b[0];
                return a[1] - b[1];
            });
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
            pq.offer(0);
            int prev = 0;
            for (int[] h : height) {
                if (h[1] < 0) {
                    pq.offer(-h[1]);
                } else {
                    pq.remove(h[1]);
                }
                int cur = pq.peek();
                if (prev != cur) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(h[0]);
                    tmp.add(cur);
                    result.add(new ArrayList<>(tmp));
                    prev = cur;
                }
            }
            return result;
        }
    

public static void main(String[] args) {
    
}


}