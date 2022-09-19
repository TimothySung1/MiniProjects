'''
Created on Feb 3, 2021

@author: tsung
'''
#loops
def repeat(count, phrase):
    for i in range(count):
        print(str(i + 1) + " " + phrase)
        
#corrections
def corrections(phrase, wrong, replacement):
    print(phrase.replace(wrong, replacement))
    
#volume of a sphere
def sphere(variable, value):
    if variable == "radius":
        print("volume = " + str((4 / 3) * (3.14159) * (value ** 3)))
    if variable == "volume":
        print("radius = " + str(((3 * value) / (4 * 3.14159)) ** (1 / 3)))
        
#votes
def votes(number, ballots):
    pass
    
#rovot moves
def moves(columns, rows, start_pos, movements):
    cols_dict = {"A": 1, "B": 2, "C": 3, "D": 4, "E": 5, "F": 6, "G": 7, "H": 8, "I": 9, "J": 10, "K": 11, "L": 12, "M": 13, "N": 14, "O": 15, "P": 16, "Q": 17, "R": 18, "S": 19, "T": 20, "U": 21, "V": 22, "W": 23, "X": 24, "Y": 25, "Z": 26}
    ##row = [-1] * columns
    ##field = [row] * rows
    ##print(field)
    col = cols_dict[start_pos[0:1]]
    row = int(start_pos[1:2])
    print(col, row)
    outOfBounds = False
    for move in movements:
        if move == "N":
            row -= 1
        elif move == "E":
            col += 1
        elif move == "S":
            row += 1
        elif move == "W":
            col -= 1
        if row > rows or row < 1:
            outOfBounds = True
        if col > columns or col < 1:
            outOfBounds = True
            
    if outOfBounds:
        print("Out of bounds.")
    else:
        for key, value in cols_dict.items():
            if value == col:
                col = key
        print(col + str(row))
"""
sphere("radius", 5)
sphere("volume", 523.6)
corrections("To be or not to be, that is the potato.", "potato", "question")
corrections("Old King Cole was a dairy cold sole, and a dairy cold sole was he.", "dairy cold sole", "merry old soul")
repeat(5, "\"Reason obeys itself, and ignorance submits to whatever is dictated to it.\" -Thomas Paine")
repeat(1, "\"The advancement and diffusion of knowledge is the only guardian of true liberty.\" -James Madison")
"""
moves(4, 4, "D4", "NNNWWW")