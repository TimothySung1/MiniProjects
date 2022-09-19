'''
Created on Apr 19, 2020

@author: Timothy
'''
from random import randint
import enum
import pygame
from pygame_functions import *

import pygame_gui
from builtins import True

    

def printBoard(board):
    print("   1 2 3 4 5 6 7 8")
    print("")
    num = 1
    for row in board:
        print(str(num) + "  " + (" ").join(row))
        num += 1
    print("")
def setShips(board, ships):
    for ship in ships:
        print("Adding ship")
        setShip(board, ship)
        print("Ship added")
        
def setShip(board, shiplength):
    ##while True:
    while True:
        orientation = randint(0, 2)
        if orientation == 0:
            ##horizontal
            starting = randint(0, len(board[0]) - shiplength)
            starting2 = starting
            shiplength2 = shiplength
            row = randint(0, len(board) - 1)
            valid = True
            while shiplength2 > 0:
                if board[row][starting2] != "0":
                    valid = False
                    break
                starting2 += 1
                shiplength2 -= 1
            if not valid:
                continue
            while shiplength > 0:
                board[row][starting] = "S"
                starting += 1
                shiplength -= 1
        else:
            ##vertical
            starting = randint(0, len(board) - shiplength)
            starting2 = starting
            shiplength2 = shiplength
            col = randint(0, len(board[0]) - 1)
            valid2 = True
            while shiplength2 > 0:
                if board[starting2][col] != "0":
                    valid2 = False
                    break
                starting2 += 1
                shiplength2 -= 1
            if not valid2:
                continue
            while shiplength > 0:
                board[starting][col] = "S"
                starting += 1
                shiplength -= 1
        break
    
def myGuess(x, y, myhitsboard, pcboard, gameboard):
        
    guessRow = y
    guessCol = x
    valid = False
    
    if myhitsboard[guessRow][guessCol] == "0":
        if pcboard[guessRow][guessCol] == "S":
            myhitsboard[guessRow][guessCol] = "H"
            print("You hit a ship!")
            ##gameboard.fill((204, 0, 0), rect = (x * 100, y * 100, (x * 100) + 100, (y * 100) + 100))
            pygame.draw.rect(gameboard, (204, 0, 0), ((x * 100) + 2, (y * 100) + 2, 98, 98))
            pygame.display.update()
        else:
            myhitsboard[guessRow][guessCol] = "X"
            print("You missed")
            ##gameboard.fill((255, 255, 255), rect = (x * 100, y * 100, (x * 100) + 100, (y * 100) + 100))
            pygame.draw.rect(gameboard, (255, 255, 255), ((x * 100) + 2, (y * 100) + 2, 98, 98))
            pygame.display.update()
        return True
        
    else:
        print("You already guessed that location. Try again.")
        pygame.display.set_caption("[Battleship]        You already guessed that location. Try again.")
        return False
        
def pcGuess(myboard, pchitsboard):
    print("The computer is choosing...")
    valid = False
    
    while not valid:
        
        location = pcCheckHit(pchitsboard)
        
        if location == None:
            pcGuessRow = randint(0, len(myboard) - 1)
            pcGuessCol = randint(0, len(myboard[0]) - 1)
            print("The computer is choosing a random location")
            
        else:
            pcGuessRow = location[0]
            pcGuessCol = location[1]
            print("The computer is choosing near a hit")
        
        print("The computer chose row " + str((pcGuessRow + 1)) + " and column " + str((pcGuessCol + 1)))
        if pchitsboard[pcGuessRow][pcGuessCol] == "0":
            if myboard[pcGuessRow][pcGuessCol] == "S":
                print("Your battleship got hit")
                pchitsboard[pcGuessRow][pcGuessCol] = "H"
                
            else:
                print("Your battleship was not hit")
                pchitsboard[pcGuessRow][pcGuessCol] = "X"
            valid = True
        
def guess(myboard, pchitsboard, row, col):

    if pchitsboard[row][col] == "0":
            if myboard[row][col] == "S":
                print("Your battleship got hit")
                pchitsboard[row][col] = "H"
                
            else:
                print("Your battleship was not hit")
                pchitsboard[row][col] = "X"
                
def pcCheckHit(pchitsboard):
    row = 0
    col = 0
    while row < len(pchitsboard):
        col = 0
        while col < len(pchitsboard[0]):
            if pchitsboard[row][col] == "H":
                x = pcAroundHit(row, col, pchitsboard)
                if x != None:
                    return x
            col += 1
        row += 1
    return None
    

def pcAroundHit(row, col, pchitsboard):
    
    if row + 1 < len(pchitsboard):
        if pchitsboard[row + 1][col] == "0":
            return [row + 1, col]
    if row - 1 >= 0:
        if pchitsboard[row - 1][col] == "0":
            return [row - 1, col]
    if col + 1 < len(pchitsboard[0]):
        if pchitsboard[row][col + 1] == "0":
            return [row, col + 1]
    if col - 1 >= 0:
        if pchitsboard[row][col - 1] == "0":
            return [row, col - 1]
    else:
        return None
    
def testWin(pcboard, myhitsboard):
    row = 0
    col = 0
    
    while row < len(pcboard):
        col = 0
        while col < len(pcboard[0]):
            if pcboard[row][col] != "0":
                if myhitsboard[row][col] == "0":
                    return False
            col += 1
        row += 1
    return True     
    
class Strategy():
    RANDOM = 1
    
    HUNTTARGET = 2
        
    ##Checkered
    GRID1 = 3
    ##Diagonal
    GRID2 = 4
    

def checkered(myboard, pchitsboard, strategy):
    boardlength = len(pchitsboard)
    valid = False
    location = pcCheckHit(pchitsboard)
    if location == None:
        while not valid:
            col = randint(0, boardlength - 1)
            row = randint(0, boardlength - 1)
            if strategy == 3:   
                if (row + col) % 2 == 0:
                    if pchitsboard[row][col] == "0":
                        valid = True
            if strategy == 4:
                if (row + col) % 2 == 1:
                    if pchitsboard[row][col] == "0":
                        valid = True
        guess(myboard, pchitsboard, row, col)
    else:
        while not valid:
            row = location[0]
            col = location[1]
            if pchitsboard[row][col] == "0":
                valid = True
        print("The computer is choosing near a hit")
        guess(myboard, pchitsboard, row, col)
    
        
def random(myboard, pchitsboard):
    boardlength = len(pchitsboard)
    valid = False
    while not valid:
        row = randint(0, boardlength - 1)
        print(str(row))
        col = randint(0, boardlength - 1)
        print(str(col))
        if pchitsboard[row][col] == "0":
            valid = True
    guess(myboard, pchitsboard, row, col)
    

def setShipsVisual(myboard, gameboard):
    row = 0
    col = 0
    
    while row < len(myboard):
        col = 0
        while col < len(myboard[0]):
            if myboard[row][col] == "S":
                ##pygame.draw.circle(gameboard, (255, 255, 255), (((col + 1) * 100) + 1000, ((row + 1) * 100)), 35)
                pygame.draw.rect(gameboard, (255, 255, 255), (((col) * 100 + 1002), ((row) * 100), 98, 98))
                pygame.display.update()
                if myboard[row][col] == "0":
                    pass
            col += 1
        row += 1
         
def pcHitVisual(pchitsboard, gameboard):
    row = 0
    col = 0
    
    while row < len(pchitsboard):
        col = 0
        while col < len(pchitsboard[0]):
            if pchitsboard[row][col] == "H":
                ##pygame.draw.circle(gameboard, (255, 255, 255), (((col + 1) * 100) + 1000, ((row + 1) * 100)), 35)
                pygame.draw.rect(gameboard, (255, 0, 0), (((col) * 100 + 1002), ((row) * 100), 98, 98))
                pygame.display.update()
            if pchitsboard[row][col] == "X":
                pygame.draw.rect(gameboard, (0, 0, 0), (((col) * 100 + 1002), ((row) * 100), 98, 98))
                pygame.display.update()
            col += 1
        row += 1
def main():
    pygame.display.init()
    
    ##myhitsboard
    gameboard = pygame.display.set_mode((1800, 800))
    gameboard.fill((128, 128, 128))
    
    
    ##myshipboard
    ##shipboard = pygame.display.set_mode((800, 800))
    ##shipboard.fill((128, 128, 128))
    pygame.display.set_caption("[Battleship]        Guess Here:                                        Your Ships:")
    
    ##stratLabel = makeLabel("Which strategy do you want the AI to use? [1: Random, 2: Hunt/Target 3: Grid]", 30, 900, 400, )
    ##make pop up/combobox to choose strategy
    """pygame_gui.elements.ui_drop_down_menu(["Random", "Hunt/Target", "Checkered 1", "Checkered 2"], "Hunt/Target", pygame.Rect((int(self.rect.width / 2), int(self.rect.height * 0.3)), (200, 25)),
                                                  self.ui_manager,
                                                  container=self)
    """
    
    for x in range(8):
        num = (x + 1) * 100
        
        pygame.draw.line(gameboard, (0, 0, 0), (num, 0), (num, 800))
        pygame.draw.line(gameboard, (0, 0, 0), (0, num), (800, num))
        
        
        pygame.draw.line(gameboard, (0, 0, 0), (num + 900, 0), (num + 900, 1800))
        pygame.draw.line(gameboard, (0, 0, 0), (1000, num), (1800, num))
        ##pygame.draw.line(shipboard, (0, 0, 0), (num, 0), (num, 800))
        ##pygame.draw.line(shipboard, (0, 0, 0), (num, 0), (num, 800))
    pygame.display.update()
    
    
    
    ships = [5, 4, 3, 3, 2]
    print("Welcome to Battleship")
    print("Choose a row and column you want to guess. Rows and columns start at 1, and there are 8 rows and 8 columns.")
    print("X's indicate a miss, and H's indicate a hit.")
    print("")
    
    pcboard = []
    myboard = []
    myhitsboard = []
    pchitsboard = []
    for x in range(8):
        pcboard.append(["0"] * 8)
        myboard.append(["0"] * 8)
        myhitsboard.append(["0"] * 8)
        pchitsboard.append(["0"] * 8)
        
    pygame.display.set_caption("[Battleship]        Welcome to Battleship")
    strat = input("Which strategy do you want the AI to use?\n[1: Random, 2: Hunt/Target 3: Grid]\n")
    if strat == "3":
        gridStrat = input("Which grid strategy do you want the AI to use?\n[1: Checkered, 2: Checkered2]\n")
        strat = int(gridStrat) + 2
    strategy = int(strat)
    
    
    
    ##printBoard(pcboard)
    ##printBoard(myboard)
    
    setShips(pcboard, ships)
    setShips(myboard, ships)
    setShipsVisual(myboard, gameboard)
    ##printBoard(pcboard)
    
    print("This is your board")
    printBoard(myboard)
    
    
    print("This is your hits board")
    printBoard(myhitsboard)
    
    ##pygame.display.set_caption("[Battleship]        Welcome to Battleship")
    
    manager = pygame_gui.UIManager((1800, 800))
    
    start_button = pygame_gui.elements.UIButton(relative_rect=pygame.Rect((800, 300), (1000, 200)),
                                             text='Start Game',
                                             manager=manager)
    while True:
        event = pygame.event.wait()
        if event.type == pygame.QUIT:
            break
        
        if event.type == pygame.USEREVENT:
            if event.user_type == pygame_gui.UI_BUTTON_PRESSED:
                if event.ui_element == start_button:
                    
        
        if event.type == pygame.MOUSEBUTTONDOWN:
            location = pygame.mouse.get_pos()
            
                
            x = (location[0] // 100)
            y = (location[1] // 100)
            
        
            ##print(str(x) + " " + str(y))
            
            if myGuess(x, y, myhitsboard, pcboard, gameboard):
                pygame.display.set_caption("[Battleship]")
                
                if testWin(pcboard, myhitsboard):
                    print("You won! You sunk their battleship")
                    break
                if strategy == 1:
                    random(myboard, pchitsboard)
                if strategy == 2:
                    pcGuess(myboard, pchitsboard)
                if strategy == 3:
                    checkered(myboard, pchitsboard, 3)
                if strategy == 4:
                    checkered(myboard, pchitsboard, 4)
                pcHitVisual(pchitsboard, gameboard)
                pygame.display.update()
                if testWin(myboard, pchitsboard):
                    print("You lost. Your battleship was sunken")
                    break
            
        
                
            
        
       
        print("")
        print("PC's Hits:")
        printBoard(pchitsboard)
        print("\n")
        print("Your Hits:")
        printBoard(myhitsboard)
        print("\n")



    



main()