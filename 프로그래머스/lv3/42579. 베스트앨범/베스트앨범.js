function solution(genres, plays) {
  var answer = [];

  const dict = {}

  for (let i = 0; i < genres.length; i++) {
    if (!dict.hasOwnProperty(genres[i])) {
      dict[genres[i]] = {
        total: 0,
        first: null,
        second: null
      };
    }
    dict[genres[i]].total += plays[i];

    if (dict[genres[i]].first == null) {
      dict[genres[i]].first = i;
      continue;
    }

    if (dict[genres[i]].second == null) {
      if (plays[dict[genres[i]].first] < plays[i]) {
        dict[genres[i]].second = dict[genres[i]].first;
        dict[genres[i]].first = i;
        continue;
      }

      dict[genres[i]].second = i;
      continue;
    }

    if (plays[dict[genres[i]].first] < plays[i]) {
      dict[genres[i]].second = dict[genres[i]].first;
      dict[genres[i]].first = i;
      continue;
    }

    if (plays[dict[genres[i]].second] < plays[i]) {
      dict[genres[i]].second = i;
      continue;
    }
  }

  const sortArr = []
  for (const dictElement in dict) {
    sortArr.push(dict[dictElement]);
  }

  sortArr.sort((a, b) =>{
    return b.total - a.total;
  })

  for (const sortArrElement of sortArr) {
    answer.push(sortArrElement.first);
    if (sortArrElement.second !== null) {
      answer.push(sortArrElement.second);
    }
  }

  return answer;
}