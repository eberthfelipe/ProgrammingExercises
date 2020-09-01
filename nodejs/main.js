'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.trim().split('\n').map(string => {
        return string.trim();
    });
    
    main();    
});

function readLine() {
    return inputString[currentLine++];
}

function getMaxLessThanKRecursive(n, k, init, maxCurrent){
    let bitwise;
    for(let i=init+1; i <= n; i++){
        if(maxCurrent == (k-1))
            return maxCurrent;
        bitwise = init & i;
        //console.log(init , ' & ', i, ' = ', bitwise);
        if(bitwise < k && bitwise > maxCurrent){
            maxCurrent = bitwise;
            //console.log('NEW biggest < ', k, ' = ', maxCurrent);
        }
    }
    if(init == (n-1))
        return maxCurrent;
    else 
        return getMaxLessThanK(n, k, ++init, maxCurrent);
}

function getMaxLessThanK(n, k){
    let bitwise;
    let init=1, maxCurrent=0;
    do {
        for(let i=init+1; i <= n; i++){
            if(maxCurrent == (k-1))
                return maxCurrent;
            bitwise = init & i;
            //console.log(init , ' & ', i, ' = ', bitwise);
            if(bitwise < k && bitwise > maxCurrent){
                maxCurrent = bitwise;
                //console.log('NEW biggest < ', k, ' = ', maxCurrent);
            }
        }
        init++;
    } while (init < n);
    return maxCurrent;
}

function main() {
    const q = +(readLine());
    
    for (let i = 0; i < q; i++) {
        const [n, k] = readLine().split(' ').map(Number);
        
        console.log(getMaxLessThanK(n, k));
    }
}