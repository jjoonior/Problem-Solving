function solution(k, dungeons) {
    var answer = -1;

    const path = [];

    (function fn(m) {
        for (let i = 0; i < dungeons.length; i++) {
            if (!path.includes(i) && m >= dungeons[i][0] && m >= dungeons[i][1]) {
                    path.push(i);
                    m -= dungeons[i][1];
                    answer = Math.max(answer, path.length);
                    fn(m);
                    m += dungeons[i][1];
                    path.pop(i);
            }
        }
    })(k);

    return answer;
}