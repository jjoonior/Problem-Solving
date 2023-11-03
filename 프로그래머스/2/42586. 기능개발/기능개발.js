function solution(progresses, speeds) {
    var answer = [];
    let stack = [];

    for (let i = 0; i < progresses.length; i++) {
        const x = Math.ceil((100 - progresses[i]) / speeds[i]);
        if (stack.length !== 0 && stack[0] < x) {
            answer.push(stack.length);
            stack = [];
        }
        stack.push(x);
    }
    answer.push(stack.length);

    return answer;
}