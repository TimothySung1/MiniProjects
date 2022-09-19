'''
Created on Apr 5, 2020

@author: Timothy
'''
from pygame.locals import *
from random import randint
import pygame
import time
from pip.utils.outdated import SELFCHECK_DATE_FMT
from _ast import If

class Snake:
    x = [0]
    y = [0]
    step = 20
    direction = 0
    defaultLength = 1
    updateCountMax = 2
    updateCount = 0
    
    def __init__(self, length):
        self.defaultLength = length
        self.length = length
        for i in range(0, 2000):
            self.x.append(-100)
            self.y.append(-100)
        self.x[1] = 1 * self.step
        self.x[2] = 2 * self.step
        
    def reset(self):
        self.x = [0]
        self.y = [0]
        self.direction = 0
        self.length = self.defaultLength + 1
        for i in range(0, 2000):
            self.x.append(-100)
            self.y.append(-100)
        self.x[1] = 1 * self.step
        self.x[2] = 2 * self.step
    
    def update(self):
        self.updateCount += 1
        if self.updateCount > self.updateCountMax:
            for i in range(self.length - 1, 0, -1):
                self.x[i] = self.x[i-1]
                self.y[i] = self.y[i-1]
            if self.direction == 0:
                ##moving to the right
                self.x[0] += self.step
            elif self.direction == 1:
                ##moving to the left
                self.x[0] -= self.step
            elif self.direction == 2:
                ##moving up
                self.y[0] -= self.step
            elif self.direction == 3:
                ##moving down
                self.y[0] += self.step
            self.updateCount = 0
    def moveRight(self):
        self.direction = 0
        
    def moveLeft(self):
        self.direction = 1
    
    def moveUp(self):
        self.direction = 2
        
    def moveDown(self):
        self.direction = 3
        
    def draw(self, surface, head_image, body_image):
        surface.blit(head_image, (self.x[0], self.y[0]))
        for i in range(1, self.length):
            surface.blit(body_image, (self.x[i], self.y[i]))
    
    def getLength(self):
        return self.length
        
class Apple:
    step = 20
    x = 0
    y= 0
    
    def draw(self, surface, image):
        surface.blit(image, (self.x, self.y))
    
    def reset(self, app):
        self.x = randint(0, app.windowWidth / self.step - 1) * self.step
        self.y = randint(0, app.windowHeight / self.step - 1) * self.step
      
class App:
    windowWidth = 800
    windowHeight = 600
    snake = 0
    apple = 0
    level = 1
    playing = False
    score = 0
    
    def __init__(self):
        self._running = True
        self._display_surf = None
        self._body_surf = None
        self._head_surf = None
        self._apple_surf = None
        self.snake = Snake(3)
        self.apple = Apple()
    
    def un_init(self):
        pygame.init()
        self._display_surf = pygame.display.set_mode((self.windowWidth, self.windowHeight), pygame.HWSURFACE)
        self._running = True
        self._body_surf = pygame.image.load("bodyLarge.png").convert()
        self._head_surf = pygame.image.load("headLarge.png").convert()
        self._apple_surf = pygame.image.load("appleLarge.png").convert()
        
    def on_event(self, event):
        if event.type == pygame.QUIT:
            self._running = False
        
    def on_execute(self):
        if self.un_init() == False:
            self._running = False
        while self._running:
            if self.playing:
                self.score = self.snake.getLength()
                pygame.display.set_caption("Snake          Level: " + str(self.level) + "          Score: " + str(self.score))
            else:
                pygame.display.set_caption("Snake          Level: " + str(self.level) + "          Score: " + str(self.score) + "          Press 'P' to Start Game")
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    self._running == False
            pygame.event.pump()
            keys = pygame.key.get_pressed()
            if self.playing:
                if keys[K_RIGHT]:
                    self.snake.moveRight()
                elif keys[K_LEFT]:
                    self.snake.moveLeft()
                elif keys[K_UP]:
                    self.snake.moveUp()
                elif keys[K_DOWN]:
                    self.snake.moveDown()
            else:
                if keys[K_p]:
                    self.playing = True
            if keys[K_ESCAPE]:
                self._running = False
                
                
            self.on_loop()
            self.on_render()
            sleepTime = 50.0 - self.snake.length / 10
            self.level = int(self.snake.getLength() / 20) + 1
            time.sleep(sleepTime / 1000.0)
        self.on_cleanUp()
    
    def on_cleanUp(self):
        pygame.QUIT
        
    def isCollision(self, x1, y1, x2, y2):
        if x1 == x2 and y1 == y2:
            return True
        else:
            return False
        
    def on_render(self):
        self._display_surf.fill((0, 0, 0))
        self.snake.draw(self._display_surf, self._head_surf, self._body_surf)
        self.apple.draw(self._display_surf, self._apple_surf)
        pygame.display.flip()
    
    def on_loop(self):
        self.snake.update()
        for i in range(0, self.snake.length):
            if self.isCollision(self.apple.x, self.apple.y, self.snake.x[i], self.snake.y[i]):
                self.apple.reset(self)
                self.snake.length += 1
        for i in range(1, self.snake.length):
            if self.isCollision(self.snake.x[0], self.snake.y[0], self.snake.x[i], self.snake.y[i]):
                self.playing = False
                self.snake.reset()
                self.apple.reset(self)
        
        if self.snake.x[0] < 0 or self.snake.y[0] < 0 or self.snake.x[0] >= self.windowWidth or self.snake.y[0] >= self.windowHeight:
            if self.playing:
                self.playing = False
                self.apple.reset(self)
            self.snake.reset()
            
        
        ##Does the snake go out of bounds
        
if __name__ == "__main__":
    app = App()
    app.on_execute()