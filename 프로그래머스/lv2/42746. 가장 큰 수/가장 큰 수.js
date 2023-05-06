function solution(numbers) {
    var answer = '';
    
  for (let i = 0; i < numbers.length; i++) {
    numbers[i] = numbers[i].toString();
  }
  numbers.sort((a,b) => {
    return (b+a)-(a+b);
  })
  
  answer= numbers.join('')
    
  if (answer[0] === "0") {
    answer = '0'
  }
    
    return answer;
}