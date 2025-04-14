import java.util.*;

class Solution {
    static int n,m;
    static boolean[][] visited;
    static Map<Integer, Set<Integer>> has;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int oilNum;
    static Map<Integer, Integer> oilCnt;
    
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];
        has = new HashMap<>();
        oilNum = 0;
        oilCnt = new HashMap<>();
        
        for(int i = 0; i < m; i++){
            has.put(i, new HashSet<>());
        }
        
        for(int i = 0; i< n; i++){
            for(int j = 0; j < m; j++){
                if(land[i][j] == 1 && !visited[i][j]){
                    oilNum++;
                    oilCnt.put(oilNum, 0);
                    dfs(land, i, j);
                }
            }
        }
        
        int answer = 0;
        for(int i = 0; i < m; i++){
            Set<Integer> set = has.get(i);

            int sum = 0;
            for(Integer num : set){
                sum += oilCnt.get(num);
            }
            
            answer = Math.max(answer, sum);
        }
        
        return answer;
    }
    
    void dfs(int[][] land, int y, int x){        
        visited[y][x] = true;
        has.get(x).add(oilNum);
        oilCnt.put(oilNum, oilCnt.get(oilNum) + 1);
        
        for(int i = 0; i < 4; i++){
            int newY = dy[i] + y;
            int newX = dx[i] + x;
                        
            if(newY<0 || newY>=n || newX<0 || newX>=m){
                continue;
            }

            if(!visited[newY][newX] && land[newY][newX] == 1){
                dfs(land, newY, newX);
            }
        }
    }
}