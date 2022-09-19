'''
Created on Apr 19, 2020

@author: Timothy
'''
from random import randint

import pygame
import os
import pickle
import pygame_gui
import glob
import sys

infoText = 'Welcome to Battleship'
turn = 0

class Ships:
    def __init__(self):
        self.playerShipList = []
        self.PCShipList = []
    def PlayerAddShip(self, coordinates):
        self.playerShipList.append(Ship(coordinates))
    def PCAddShip(self, coordinates):
        self.PCShipList.append(Ship(coordinates))
    
        
class Ship:
    def __init__(self, coordinates):
        self.coordinates = coordinates  
        self.hit = [False] * len(coordinates)
    
        
        
        
ships = Ships()


def printBoard(board):
    print("   1 2 3 4 5 6 7 8")
    print("")
    num = 1
    for row in board:
        print(str(num) + "  " + (" ").join(row))
        num += 1
    print("")
    

    
    
def setShips(board, ships, player):
    for ship in ships:
        print("Adding ship")
        
        setShip(board, ship, player)
        
        print("Ship added")
        
def setShip(board, shiplength, player):
    ##while True:
    
    
    
    while True:
        
        xyList = []
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
            if not player:
                
                PCcoordList = []
                while shiplength > 0:
                    PCxyList = []
                    PCxyList.append(row)
                    PCxyList.append(starting)
                    PCcoordList.append(PCxyList)
                    board[row][starting] = "S"
                    starting += 1
                    shiplength -= 1
            else:
                
                coordList = []
                while shiplength > 0:
                    xyList = []
                    xyList.append(row)
                    xyList.append(starting)
                    coordList.append(xyList)
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
                    coordList = []
                    break
                starting2 += 1
                shiplength2 -= 1
            if not valid2:
                continue
            if not player:
                
                PCcoordList = []
                while shiplength > 0:
                    PCxyList = []
                    PCxyList.append(starting2)
                    PCxyList.append(col)
                    PCcoordList.append(PCxyList)
                    board[starting][col] = "S"
                    starting += 1
                    shiplength -= 1
            else:
                
                coordList = []
                while shiplength > 0:
                    xyList = []
                    xyList.append(starting2)
                    xyList.append(col)
                    coordList.append(xyList)
                    board[starting][col] = "S"
                    starting += 1
                    shiplength -= 1
        
        if not player:
            ships.PCAddShip(PCcoordList)
        else:
            ships.PlayerAddShip(coordList)
        break
    
def myGuess(x, y, myhitsboard, pcboard, gameboard):
    global infoText
    global turn
    guessRow = y
    guessCol = x
    valid = False
    
    if guessCol <= 8:
    
        if myhitsboard[guessRow][guessCol] == "0":
            
            if pcboard[guessRow][guessCol] == "S":
                myhitsboard[guessRow][guessCol] = "H"
                print("You hit a ship!")
                turn += 1
                infoText += '<br>Turn: ' + str(turn)
                infoText += '<br>You hit a ship!'
                                ##gameboard.fill((204, 0, 0), rect = (x * 100, y * 100, (x * 100) + 100, (y * 100) + 100))
                pygame.draw.rect(gameboard, (204, 0, 0), ((x * 100) + 2, (y * 100) + 2, 98, 98))
                pygame.display.update()
                
            else:
                myhitsboard[guessRow][guessCol] = "X"
                print("You missed")
                turn += 1
                infoText += '<br>Turn: ' + str(turn)
                infoText += '<br>You missed.'
                ##gameboard.fill((255, 255, 255), rect = (x * 100, y * 100, (x * 100) + 100, (y * 100) + 100))
                pygame.draw.rect(gameboard, (255, 255, 255), ((x * 100) + 2, (y * 100) + 2, 98, 98))
                pygame.display.update()
                
            return True
          
        else:
            print("You already guessed that location. Try again.")
            
            infoText += '<br>You already guessed that location. <br>Try again.'
                                                                  
            return False
        
def pcGuess(myboard, pchitsboard):
    global infoText
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
        infoText += '<br>The computer chose row ' + str((pcGuessRow + 1)) + ' and column ' + str((pcGuessCol + 1)) + '.'
        if pchitsboard[pcGuessRow][pcGuessCol] == "0":
            if myboard[pcGuessRow][pcGuessCol] == "S":
                print("Your battleship got hit")
                infoText += '<br>Your battleship got hit.'
                pchitsboard[pcGuessRow][pcGuessCol] = "H"
                
            else:
                print("Your battleship was not hit.")
                infoText += '<br>Your battleship was not hit'
                pchitsboard[pcGuessRow][pcGuessCol] = "X"
            valid = True
        
def guess(myboard, pchitsboard, row, col):
    global infoText
    if pchitsboard[row][col] == "0":
            if myboard[row][col] == "S":
                print("Your battleship got hit")
                infoText += '<br>The computer chose row ' + str((row + 1)) + ' and column ' + str((col + 1)) + '.'
                infoText += '<br>Your battleship got hit.'
                pchitsboard[row][col] = "H"
                
            else:
                print("Your battleship was not hit")
                infoText += '<br>The computer chose row ' + str((row + 1)) + ' and column ' + str((col + 1)) + '.'
                infoText += '<br>Your battleship was not hit.'
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
        
def color(hitboard, gameboard):
    row = 0
    col = 0
   
    while row < len(hitboard):
        col = 0
        while col < len(hitboard[0]):
            if hitboard[row][col] == "H":
                ##pygame.draw.circle(gameboard, (255, 255, 255), (((col + 1) * 100) + 1000, ((row + 1) * 100)), 35)
                pygame.draw.rect(gameboard, (255, 0, 0), (((col) * 100 + 2), ((row) * 100), 98, 98))
                pygame.display.update()
            if hitboard[row][col] == "X":
                pygame.draw.rect(gameboard, (255, 255, 255), (((col) * 100 + 2), ((row) * 100), 98, 98))
                pygame.display.update()
            col += 1
        row += 1
def resetGame():
    pass

class GameData:
    def __init__(self):
        self.filename = "Battleship_Data.txt"
        if os.path.isfile(self.filename):
            file = open(self.filename, "r")
            self.wins = int(file.readline())
            self.moves_per_win = int(file.readline())
            self.losses = int(file.readline())
            self.moves_per_loss = int(file.readline())
            file.close()
        else:
            ##resetData()
            self.wins = 0
            self.moves_per_win = 0
            self.losses = 0
            self.moves_per_loss = 0
            
    def __del__(self):
        try:
            self.wins
        except NameError:
            print("self.wins does not exist. Game Data not written.")
        else:
            file = open(self.filename, "w")
            file.write(str(self.wins) + "\n")
            file.write(str(self.moves_per_win) + "\n")
            file.write(str(self.losses) + "\n")
            file.write(str(self.moves_per_loss) + "\n")
            file.close()
        
    def getWins(self):
        return self.wins
    def getLosses(self):
        return self.losses
    def getMovesPerWin(self):
        return self.moves_per_win
    def getMovesPerLoss(self):
        return self.moves_per_loss
    
    def gameFinish(self, win, turns):
        if win:
            self.wins += 1
            self.moves_per_win += turns
            
        else:
            self.losses += 1
            self.moves_per_loss += turns
    
    def AverageMovesWin(self, wins, turns):
        print("AVG moves per win: " + str(turns//wins))
        return turns // wins
    
    def resetData(self):
        self.wins = 0
        self.moves_per_win = 0
        self.losses = 0
        self.moves_per_loss = 0
        print("Data reset to 0")
        

class SaveGame:
    def __init__(self, moves, myboard, pcboard, myhitsboard, pchitsboard, ships, saveName):
        
        file = open(saveName + ".bts", "wb")
        
        self.moves = moves
        
        self.myboard = myboard
        self.pcboard = pcboard
        self.myhitsboard = myhitsboard
        self.pchitsboard = pchitsboard
        self.ships = ships
        saveList = []
        saveList.append(moves)
        
        saveList.append(myboard)
        saveList.append(pcboard)
        saveList.append(myhitsboard)
        saveList.append(pchitsboard)
        saveList.append(ships)
        pickle.dump(saveList, file)
        file.flush()
        file.close()
        
    def getMoves(self):
        return self.moves
    def getShipLocation(self):
        return self.shipLocation
    def getMyBoard(self):
        return self.myboard
    def getPcBoard(self):
        return self.pcboard
    def getmyhitsboard(self):
        return self.myhitsboard
    def getpchitsboard(self):
        return self.pchitsboard
    def getShips(self):
        return self.ships
    
def main():
    gameData = GameData()
    """if os.path.isfile("Battleship_Data.txt"):
        f = open("Battleship_Data.txt", "r")
        tempLine = f.readline()
    """
    
        ##reading and writing files to save game info like wins/losses/save game
    pygame.init()
    
    ##myhitsboard
    gameboard = pygame.display.set_mode((1800, 800))
    ##gameboard.fill((128, 128, 128))
    background = pygame.Surface((1800, 800))
    background.fill((128, 128, 128))
    manager = pygame_gui.UIManager((1800, 800))
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
        
        pygame.draw.line(background, (0, 0, 0), (num, 0), (num, 800))
        pygame.draw.line(background, (0, 0, 0), (0, num), (800, num))
        pygame.draw.line(background, (0, 0, 0), (num + 900, 0), (num + 900, 1800))
        pygame.draw.line(background, (0, 0, 0), (1000, num), (1800, num))
        ##pygame.draw.line(shipboard, (0, 0, 0), (num, 0), (num, 800))
        ##pygame.draw.line(shipboard, (0, 0, 0), (num, 0), (num, 800))
    pygame.display.update()
    
    
    
    ships = [5, 4, 3, 3, 2]
    print("Welcome to Battleship")
    print("Choose a row and column you want to guess. Rows and columns start at 1, and there are 8 rows and 8 columns.")
    print("X's indicate a miss, and H's indicate a hit.")
    print("")
    
    #save_file_text_entry = pygame_gui.elements.ui_text_entry_line(relative_rect=pygame.Rect((700, 400), (400, 200)), manager = manager, container = None)
    
    #copy
    """
    saveList = glob.glob("*.bts")
    print(saveList)
    if saveList != []:
        loc = 0
        for save in saveList:
            saveList[loc] = save[0:-4]
            loc += 1
        print(saveList)
        save_file_drop_down = pygame_gui.elements.UIDropDownMenu(saveList, "Choose Save File", relative_rect=pygame.Rect((700, 500), (400, 100)), manager = manager)
        
        saveName = save_file_drop_down.selected_option
        print(saveName)
        
    else:
        saveName = ""
    if os.path.isfile(saveName + ".bts"):
            file = open(saveName + ".bts", "rb")
            saveFile = file.read()
            de = pickle.loads(saveFile)
            turn = de[0]
            myboard = de[1]
            pcboard = de[2]
            myhitsboard = de[3]
            pchitsboard = de[4]
            ships = de[5]
            file.close()
    else:
        turn = 0
        pcboard = []
        myboard = []
        myhitsboard = []
        pchitsboard = []
        for x in range(8):
            
            pcboard.append(["0"] * 8)
            myboard.append(["0"] * 8)
            myhitsboard.append(["0"] * 8)
            pchitsboard.append(["0"] * 8)
        setShips(pcboard, ships, False)
        setShips(myboard, ships, True)
        """
    pygame.display.set_caption("[Battleship]        Welcome to Battleship")
    """strat = input("Which strategy do you want the AI to use?\n[1: Random, 2: Hunt/Target 3: Grid]\n")
    if strat == "3":
        gridStrat = input("Which grid strategy do you want the AI to use?\n[1: Checkered, 2: Checkered2]\n")
        strat = int(gridStrat) + 2
    strategy = int(strat)
    """
    
    
    ##printBoard(pcboard)
    ##printBoard(myboard)
    
    
    
    ##printBoard(pcboard)
    
    """print("This is your board")
    printBoard(myboard)
    
    
    print("This is your hits board")
    printBoard(myhitsboard)
    """
    ##pygame.display.set_caption("[Battleship]        Welcome to Battleship")
    
    
    strategyList = ['Random', 'Hunt/Target', 'Checkered Grid 1', 'Checkered Grid 2']
    start_button = pygame_gui.elements.UIButton(relative_rect=pygame.Rect((550, 300), (750, 200)), text = 'Start Game', manager = manager)
    strategy_drop_down = pygame_gui.elements.UIDropDownMenu(strategyList, "Choose AI Strategy", relative_rect=pygame.Rect((585, 150), (685, 75)), manager = manager)
    reset_data_button = pygame_gui.elements.UIButton(pygame.Rect((550, 600), (750, 100)), text = 'Reset Game Data', manager = manager)
    ##restart_game_button = pygame_gui.elements.UIButton(relative_rect=pygame.Rect((550, 150), (750, 100)), text = 'Restart Game', manager = manager)
    ##test_drop_down = pygame_gui.elements.UIDropDownMenu(['option 1', 'option 2', 'option 3'], "testing", pygame.Rect(50, 100, 200, 25), manager=manager)
    ##save_button = pygame_gui.elements.UIButton(pygame.Rect((550, 300), (500, 200)), text = 'Save Progress', manager = manager)
    ##infoText = 'Welcome to Battleship. This is where you will receive info and feedback on the game.'
    save_text_entry = pygame_gui.elements.UITextEntryLine(relative_rect=pygame.Rect((700, 200), (400, 150)), manager = manager)
    global infoText
    info_text_box = pygame_gui.elements.ui_text_box.UITextBox(infoText,
                                                              pygame.Rect((800, 0), (200, 800)),
                                                              manager = manager)
    save_label = pygame_gui.elements.UILabel(pygame.Rect((700, 100), (400, 100)), "Enter the name of the save file", manager = manager)
    save_error_label = pygame_gui.elements.UILabel(pygame.Rect((650, 300), (500, 100)), "There was an error creating your save file. Try again", manager = manager)
    info_text_box.hide()
    start_button.disable()
    reset_data_button.hide()
    save_text_entry.hide()
    save_label.hide()
    save_error_label.hide()
    ##save_button.hide()
    ##strategy_error_pop_up = pygame_gui.elements.
    manager.draw_ui(gameboard)
              
    #error messages                               
    ##AIstrategy_error_message = pygame_gui.elements.UITextBox("You must choose a strategy for your AI opponent to use before starting the game", pygame.Rect((550, 500), (750, 475)), manager=manager)
    ##gameDoc = pygame_gui.elements.UITextBox('temporary temporary', )
    ##location_error_message1 = pygame.gui.elements.UITextBox("You already chose that location. Try again", )
    
    #just to see if this works
    """htm_text_block_2 = pygame_gui.elements.UITextBox('<font face=fira_code size=2 color=#000000><b>Hey, What the heck!</b>'
                             '<br><br>'
                             'This is some <a href="test">text</a> in a different box,'
                             ' hooray for variety - '
                             'if you want then you should put a ring upon it. '
                             '<body bgcolor=#990000>What if we do a really long word?</body> '
                             '<b><i>derp FALALALALALALALXALALALXALALALALAAPaaaaarp gosh'
                             '</b></i></font>',
                             pygame.Rect((400, 400), (600, 600)),
                             manager=manager,
                             object_id="#text_box_2")
    htm_text_block_2.set_active_effect('typing_appear')"""
    
    
    
            
    clock = pygame.time.Clock()
    is_running = True
    """
    print("")
    print("PC's Hits:")
    printBoard(pchitsboard)
    print("\n")
    print("Your Hits:")
    printBoard(myhitsboard)
    print("\n")
    """
    b = ""
    turn = 0
    saveUsed = False
    #copy
    dropdownfirstoption = "Choose Save File"
    noInfo = False
    saveList = glob.glob("*.bts")
    print(saveList)
    if saveList != []:
        loc = 0
        for save in saveList:
            saveList[loc] = save[0:-4]
            loc += 1
        print(saveList)
        save_file_drop_down = pygame_gui.elements.UIDropDownMenu(saveList, dropdownfirstoption, relative_rect=pygame.Rect((700, 500), (400, 100)), manager = manager)
        
        #saveName = save_file_drop_down.selected_option
        #print(saveName)
    saveScreen = False    
    
    saveName = None
        #copy
    gameOver = False
    trueGameOver = False
    averageTurnPerWin = 0
    if gameData.getWins() != 0:
        averageTurnPerWin = gameData.AverageMovesWin(gameData.getWins(), gameData.getMovesPerWin())
    pygame.display.set_caption("[Battleship]        Wins: " + str(gameData.getWins()) + "        Losses: " + str(gameData.getLosses()) + "        Turn: " + str(turn) + "        Average Moves Per Win: " + str(averageTurnPerWin))
    reset_data_button.show()
    
    while is_running:
        
        time_delta = clock.tick(60)/1000.0
        
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                info_text_box.kill()
                noInfo = True
                if b == "":
                    is_running = False
                if not gameOver:
                    #print("save name: " + saveName)
                    if saveName == None:
                        print("show text entry")
                        
                        save_text_entry.show()
                        save_label.show()
                        saveScreen = True
                        break
                    else:
                        save = SaveGame(turn, myboard, pcboard, myhitsboard, pchitsboard, ships, saveName)
                        
                        
                    is_running = False
                    
                    
                else:
                    if os.path.isfile(saveName + ".bts"):
                        
                        os.remove(saveName + ".bts")
                    is_running = False
                
                
            if event.type == pygame.USEREVENT:
                
                if event.user_type == pygame_gui.UI_BUTTON_PRESSED:
                    if event.ui_element == start_button:
                        #copy
                        if saveUsed:
                            if os.path.isfile(saveName + ".bts"):
                                    file = open(saveName + ".bts", "rb")
                                    saveFile = file.read()
                                    de = pickle.loads(saveFile)
                                    turn = de[0]
                                    myboard = de[1]
                                    pcboard = de[2]
                                    myhitsboard = de[3]
                                    pchitsboard = de[4]
                                    ships = de[5]
                                    file.close()
                                    pygame.display.set_caption("[Battleship]        Wins: " + str(gameData.getWins()) + "        Losses: " + str(gameData.getLosses()) + "        Turn: " + str(turn) + "        Average Moves Per Win: " + str(averageTurnPerWin))
                            else:
                                turn = 0
                                pcboard = []
                                myboard = []
                                myhitsboard = []
                                pchitsboard = []
                                for x in range(8):
                                    
                                    pcboard.append(["0"] * 8)
                                    myboard.append(["0"] * 8)
                                    myhitsboard.append(["0"] * 8)
                                    pchitsboard.append(["0"] * 8)
                                setShips(pcboard, ships, False)
                                setShips(myboard, ships, True)
                        else:
                            turn = 0
                            pcboard = []
                            myboard = []
                            myhitsboard = []
                            pchitsboard = []
                            for x in range(8):
                                
                                pcboard.append(["0"] * 8)
                                myboard.append(["0"] * 8)
                                myhitsboard.append(["0"] * 8)
                                pchitsboard.append(["0"] * 8)
                            setShips(pcboard, ships, False)
                            setShips(myboard, ships, True)

                        
                        #copy
                        save_file_drop_down.hide()
                        start_button.hide()
                        strategy_drop_down.hide()
                        reset_data_button.hide()
                        info_text_box.show()
                        manager.draw_ui(gameboard)
                        b = "pressed"
                        color(myhitsboard, background)
                        setShipsVisual(myboard, background)
                        print("this works")
                    if event.ui_element == reset_data_button:
                        gameData.resetData()
                if event.user_type == pygame_gui.UI_DROP_DOWN_MENU_CHANGED:
                    if event.ui_element == strategy_drop_down:
                        print(strategy_drop_down.selected_option)
                        if strategy_drop_down.selected_option == strategyList[0]:
                            strategy = 1
                        if strategy_drop_down.selected_option == strategyList[1]:
                            strategy = 2
                        if strategy_drop_down.selected_option == strategyList[2]:
                            strategy = 3
                        if strategy_drop_down.selected_option == strategyList[3]:
                            strategy = 4
                        start_button.enable()
                        ##strategy_drop_down.kill()
                    if event.ui_element == save_file_drop_down:
                        saveUsed = True
                        if strategy_drop_down.selected_option != dropdownfirstoption:
                            saveName = save_file_drop_down.selected_option
                        if strategy_drop_down.selected_option == dropdownfirstoption:
                            saveName = None
                if event.user_type == pygame_gui.UI_TEXT_ENTRY_FINISHED:
                    newSaveName = save_text_entry.get_text()
                    #\/*"<>|?:
                    
                        
                    
                    print("this is the new save name: " + newSaveName)
                    try:
                        save = SaveGame(turn, myboard, pcboard, myhitsboard, pchitsboard, ships, newSaveName)
                    except IOError:
                        print("There was an error in creating your save file")
                        save_error_label.show()
                        continue
                    is_running = False
                    
                                                    
            if b == "pressed":            
                
                if event.type == pygame.MOUSEBUTTONDOWN:
                    
                    location = pygame.mouse.get_pos()
                    
                        
                    x = (location[0] // 100)
                    y = (location[1] // 100)
                    
                    
                    ##print(str(x) + " " + str(y))
                    
                    if x < 8 and not gameOver:    
                        if myGuess(x, y, myhitsboard, pcboard, background):
                            
                            turn += 1
                            pygame.display.set_caption("[Battleship]        Wins: " + str(gameData.getWins()) + "        Losses: " + str(gameData.getLosses()) + "        Turn: " + str(turn) + "        Average Moves Per Win: " + str(averageTurnPerWin))
                            
                            if testWin(pcboard, myhitsboard):
                                print("You won! You sunk their battleship")
                                infoText = '<br>You won! You sunk their battleship!' 
                                gameOver = True
                                
                                gameData.gameFinish(True, turn)
                                pygame.display.set_caption("[Battleship]        Wins: " + str(gameData.getWins()) + "        Losses: " + str(gameData.getLosses()) + "        Turn: " + str(turn) + "        Average Moves Per Win: " + str(averageTurnPerWin))
                                ##is_running = False
                            if not gameOver:
                                if strategy == 1:
                                    random(myboard, pchitsboard)
                                if strategy == 2:
                                    pcGuess(myboard, pchitsboard)
                                if strategy == 3:
                                    checkered(myboard, pchitsboard, 3)
                                if strategy == 4:
                                    checkered(myboard, pchitsboard, 4)
                                pcHitVisual(pchitsboard, background)
                                color(myhitsboard, background)
                                pygame.display.update()
                                if testWin(myboard, pchitsboard):
                                    print("You lost. Your battleship was sunken")
                                    infoText = '<br>You lost. Your battleship was sunken.'
                                    gameOver = True
                                    gameData.gameFinish(False, turn)
                                    pygame.display.set_caption("[Battleship]        Wins: " + str(gameData.getWins()) + "        Losses: " + str(gameData.getLosses()) + "        Turn: " + str(turn) + "        Average Moves Per Win: " + str(averageTurnPerWin))
                                    ##is_running = False
                
                                    
            if gameOver:
                    ##start_button.show()
                    ##strategy_drop_down.show()
                    ##manager.set_visual_debug_mode(True)
                    ##reset_data_button.show()
                    pass
        
            manager.process_events(event)
    
        manager.update(time_delta)
    
        ##gameboard.blit((0, 0, 0), (0, 0))
        gameboard.blit(background, (0, 0))
        xlocation = pygame.mouse.get_pos()[0]
        if b == "pressed" and xlocation < 800:
            info_text_box.kill()
            textLength = infoText.count("<br>")
            
            #print(textLength)
            while textLength > 25:
                cut = infoText.find("<br>") + 4 
                infoText = infoText[cut:]
                
                textLength = infoText.count("<br>")
                
            ##if len(infoText) >= 700:
                ##infoText = infoText[50:]
            #41 lines, 23 long 943 characters
            if not noInfo:
                info_text_box = pygame_gui.elements.ui_text_box.UITextBox(infoText,
                                                                  pygame.Rect((800, 0), (200, 800)),
                                                                  manager = manager)
            
        manager.draw_ui(gameboard)
        
    
        pygame.display.update()
        



    



main()