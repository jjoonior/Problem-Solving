function solution(sequence, k) {
    // sequence.sort();
    var answer;

    let a = 0;
    let sum = 0;
    let min = sequence.length + 1;

    for (let i = 0; i < sequence.length; i++) {
        sum += sequence[i];

        while (sum > k) {
            sum -= sequence[a];
            a++;
        }

        if (sum === k) {
            if (i - a + 1 < min) {
                min = i - a + 1;
                answer = [a, i];
            }
        }
    }

    return answer;
}