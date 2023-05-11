function solution(priorities, location) {
  var answer = 1;

  const arr = priorities.map((e, i)=>{
    return [e,i]
  })
  let i = 0;
  const maxArr = priorities.sort();
  let max = maxArr.pop();

  while (arr.length > 0) {
    i = i % arr.length;

    if (arr[i][0] == max) {
      if (arr[i][1] == location) {
        break;
      }
      arr.splice(i, 1);
      max = maxArr.pop();
      answer++;
    } else {
      i++;
    }
  }

  return answer;
}