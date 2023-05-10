function solution(brown, yellow) {
    for(let i = 1; i<=(yellow+1)/2; i++){
        if(yellow%i ==0){
            if((i+2)*(yellow/i+2) == brown + yellow){
                return [yellow/i+2, i+2];
            }
        }    
    }
}