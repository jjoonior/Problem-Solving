function solution(s){
    var answer = true;

  let stack = 0

    if (s.length % 2 != 0) {
    return false;
  }
    
  for (let i = 0; i < s.length; i++) {

    if (s[i] === "(") {
      stack++;
    } else {
      stack--;
    }

    if (stack < 0) {
      return false;
    }
  }
    
  answer = stack === 0 ? true : false;

    return answer;
}