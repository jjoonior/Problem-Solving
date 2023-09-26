function solution(r1, r2) {
    var answer = 0;

    for (let i = 0; i <= r2; i++) {
        const max = Math.floor(Math.sqrt(r2 ** 2 - i ** 2));
        let a = r1 ** 2 - i ** 2
        
        a< 0 ? a=0 : null        
        const min = Math.ceil(Math.sqrt(a));

        answer += max - min + 1 || 0;
    }

    answer -= (r2 - r1 + 1)
    
    return answer * 4;
}