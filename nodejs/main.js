'use strict';

const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.replace(/\s*$/, '')
        .split('\n')
        .map(str => str.replace(/\s*$/, ''));

    main();
});

function readLine() {
    return inputString[currentLine++];
}

// Complete the marsExploration function below.
function marsExploration(s) {
    const SOS = "SOS";
    const maxSize = 3;
    let count = 0;
    for(let i=0; i < s.length/maxSize; i++){
        let current = s.substr(i*maxSize, maxSize).split(""); 
        //console.log(current);
        if(current[0] != 'S')
            count++;
        if(current[2] != 'S')
            count++;
        if(current[1] != 'O')
            count++;
    }
    return count;
}

function main() {
    //const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const s = readLine();

    let result = marsExploration(s);
    console.log(result);
    //ws.write(result + "\n");

    //ws.end();
}
