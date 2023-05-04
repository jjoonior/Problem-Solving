function solution(targets) {
    var answer = 0;
    
    targets.sort((a, b)=>{
        return a[1] - b[1];
    })
    
    let start = 0;
    
    for (let i = 0; i < targets.length; i++) {
        if (targets[i][0] >= start) {
        start = targets[i][1];
        answer++;
        }
    }
    
    return answer;
}