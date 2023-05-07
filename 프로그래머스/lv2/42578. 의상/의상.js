function solution(clothes) {
  var answer = 1;

  const dict = {};
  for (const clothe of clothes) {
    if (!dict.hasOwnProperty(clothe[1])) {
      dict[clothe[1]] = 0;
    }
    dict[clothe[1]]++;
  }

  for (const dictElement in dict) {
    answer *= dict[dictElement] + 1;
  }

  return answer - 1;
}
