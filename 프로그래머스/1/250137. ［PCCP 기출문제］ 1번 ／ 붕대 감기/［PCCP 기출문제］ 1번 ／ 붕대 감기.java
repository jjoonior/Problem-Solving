import java.util.*;

class Solution {
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        
        int gauge = 0;
        int attack_idx = 0;
        for(int t = 1; t <= attacks[attacks.length-1][0]; t++){
            if(gauge>0){
                answer = Math.min(health, answer+bandage[1]);
                if(gauge == bandage[0]){
                    answer = Math.min(health, answer+bandage[2]);
                    gauge = 0;
                }
            }
            
            if(attack_idx < attacks.length && attacks[attack_idx][0] == t){
                answer -= attacks[attack_idx++][1];
                gauge = 0;
                
                if(answer <=0){
                    answer = -1;
                    break;
                }
            }else{
                gauge++;
            }
                        
        }
        
        return answer;
    }
}