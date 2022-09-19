'''
Created on Apr 12, 2020

@author: Timothy
'''
import turtle

class MyTurtle(turtle.Turtle):
    
    def __init__(self):
        turtle.Turtle.__init__(self, shape = "turtle")
        
        
    def drawCircle(self, x, y, radius, color):
        self.penup()
        self.setposition(x, y)
        self.fillcolor(color)
        self.pendown()
        self.begin_fill()
        self.circle(radius)
        self.end_fill()
        
        
    def drawMickeyMouse(self):
        self.drawCircle(100, 100, 100, "blue")
        self.drawCircle(-28, 225, 50, "red")
        self.drawCircle(228, 225, 50, "red")
        self.penup()
        self.setposition(0, 0)
        
        
    
        
        
if __name__ == "__main__":
    t = MyTurtle()
    t.drawMickeyMouse()
    turtle.getscreen()._root.mainloop()