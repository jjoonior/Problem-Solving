function solution(players, callings) {
    const obj={} 
    for(let i = 0; i < players.length; i++){
        obj[players[i]] = i;
    }
    for(const calling of callings){
        const prev = players[obj[calling] - 1];
        players[obj[calling]] = prev;
        players[obj[calling] - 1] = calling;
        obj[calling] -= 1;
        obj[prev] += 1;
    }
    return players;
}