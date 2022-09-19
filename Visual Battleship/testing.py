import pygame
import pygame_gui

pygame.init()

pygame.display.set_caption('Quick Start')
window_surface = pygame.display.set_mode((800, 600))

background = pygame.Surface((800, 600))
background.fill(pygame.Color('#000000'))

manager = pygame_gui.UIManager((800, 600))

start_button = pygame_gui.elements.UIButton(relative_rect=pygame.Rect((200, 50), (250, 100)), text = 'Start Game', manager = manager)


window_surface.blit(background, (0, 0))
manager.draw_ui(window_surface)

pygame.display.update()