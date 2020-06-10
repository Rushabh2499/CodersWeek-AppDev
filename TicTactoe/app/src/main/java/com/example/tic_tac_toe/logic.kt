package com.example.tic_tac_toe

val gameSquare: Array<CharArray>? = Array(3) {CharArray(3) {'-'} }
var compTurn=0
var a:Int?=null
var b:Int?=null
var turns:Int=0

fun comp(x:Int,y:Int): Int{
    gameSquare!![x][y]='x'
    if(checker(1)==1){
        return 1
    }
    if(turns++==4)return 5

    compTurn=1
    if(gameSquare[1][1]=='-'){
        gameSquare[1][1]='o'
        a=1
        b=1
    }else if( game('o')==1){
        //do nothing
        compTurn=0
    }else if(game('x')==1){
        //do nothing
        compTurn=0
    }else{
        while (compTurn==1){
            val x1 = (0..2).random()
            val y1 = (0..2).random()
            if(gameSquare[x1][y1]=='-'){
                gameSquare[x1][y1]='o'
                a=x1
                b=y1
                compTurn=0

            }
        }
    }
    if (checker(2)==2){
        return 2
    }
    return 0
}
fun checker(turn :Int): Int {
    var check ='-'
    if(turn==1)  check ='x'
    else if(turn==2) check='o'

    if(check==gameSquare!![0][0]){
        if(check==gameSquare[0][1] && check==gameSquare[0][2]) return turn
        else if(check==gameSquare[1][1] && check==gameSquare[2][2]) return turn
        else if(check==gameSquare[1][0] && check==gameSquare[2][0]) return turn
    }
    if(check==gameSquare[1][1]){
        if(check==gameSquare[0][1] && check==gameSquare[2][1]) return turn
        else if(check==gameSquare[1][0] && check==gameSquare[1][2]) return turn
        else if(check==gameSquare[0][2] &&  check==gameSquare[2][0]) return turn
    }
    if(check==gameSquare[2][2]){
        if(check==gameSquare[2][1] && check==gameSquare[2][0]) return turn
        else if(check==gameSquare[0][2] && check==gameSquare[1][2]) return turn
    }

    return 0
}
fun game(block: Char):Int{
    if(gameSquare!![0][0]==block){
        if(gameSquare[0][1]==block && gameSquare[0][2]=='-'){
            gameSquare[0][2]='o'
            a=0
            b=2
            return 1
        }else if(gameSquare[0][2]==block && gameSquare[0][1]=='-'){
            gameSquare[0][1]='o'
            a=0
            b=1
            return 1
        }else if(gameSquare[2][0]==block && gameSquare[1][0]=='-'){
            gameSquare[1][0]='o'
            a=1
            b=0
            return 1
        }else if(gameSquare[1][0]==block && gameSquare[2][0]=='-'){
            gameSquare[2][0]='o'
            a=2
            b=0
            return 1
        }
    }
    if(gameSquare[1][1]==block){
        if(gameSquare[1][0]==block && gameSquare[1][2]=='-'){
            gameSquare[1][2]='o'
            a=1
            b=2
            return 1
        }else if(gameSquare[1][2]==block && gameSquare[1][0]=='-'){
            gameSquare[1][0]='o'
            a=1
            b=0
            return 1
        }else if(gameSquare[0][1]==block && gameSquare[2][1]=='-'){
            gameSquare[2][1]='o'
            a=2
            b=1
            return 1
        }else if(gameSquare[2][1]==block && gameSquare[0][1]=='-'){
            gameSquare[0][1]='o'
            a=0
            b=1
            return 1
        }else if(gameSquare[0][2]==block && gameSquare[2][0]=='-'){
            gameSquare[2][0]='o'
            a=2
            b=0
            return 1
        }else if(gameSquare[2][0]==block && gameSquare[0][2]=='-'){
            gameSquare[0][2]='o'
            a=0
            b=2
            return 1
        }
    }
    if(gameSquare[2][2]==block){
        if(gameSquare[0][2]==block && gameSquare[1][2]=='-'){
            gameSquare[1][2]='o'
            a=1
            b=2
            return 1
        }else if(gameSquare[1][2]==block && gameSquare[0][2]=='-'){
            gameSquare[0][2]='o'
            a=0
            b=2
            return 1
        }else if(gameSquare[2][0]==block && gameSquare[2][1]=='-'){
            gameSquare[2][1]='o'
            a=2
            b=1
            return 1
        }else if(gameSquare[2][1]==block && gameSquare[2][0]=='-'){
            gameSquare[2][0]='o'
            a=2
            b=0
            return 1
        }
    }else if(gameSquare[2][2]=='-'&& block=='x'){
        gameSquare[2][2]='o'
        a=2
        b=2
        return 1
    }

    return 0
}