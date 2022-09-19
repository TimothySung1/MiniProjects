'''
Created on Jan 10, 2022

@author: tsung
'''

class test:
    
    def __init__(self):
        self.variable = "test string"
        
    def printVariable(self):
        print(self.variable)
        
object = test()
object.printVariable()
print(object.variable)