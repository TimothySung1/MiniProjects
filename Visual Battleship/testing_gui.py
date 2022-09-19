import pygame
import pygame_gui


pygame.init()

pygame.display.set_caption('Quick Start')
window_surface = pygame.display.set_mode((800, 600))

background = pygame.Surface((800, 600))
background.fill(pygame.Color('#000000'))

manager = pygame_gui.UIManager((800, 600))

hello_button = pygame_gui.elements.UIButton(relative_rect=pygame.Rect((350, 275), (100, 50)), text='Feature Off', manager=manager)

test_drop_down = pygame_gui.elements.UIDropDownMenu(['option 1', 'option 2', 'option 3'], "testing", pygame.Rect(50, 100, 200, 25), manager=manager)

clock = pygame.time.Clock()
is_running = True
feature = False;
while is_running:
    time_delta = clock.tick(60)/1000.0
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            is_running = False

        if event.type == pygame.USEREVENT:
            if event.user_type == pygame_gui.UI_BUTTON_PRESSED:
                if event.ui_element == hello_button:
                    print('button clicked')
                    feature = not feature;
                    if feature:
                        hello_button.set_text("Feature On")
                    else:
                        hello_button.set_text("Feature Off")

            if event.user_type == pygame_gui.UI_DROP_DOWN_MENU_CHANGED:
                if event.ui_element == test_drop_down:
                    print("drop down changed")
                    print(test_drop_down.selected_option)

        #need this to click buttons and do st uff from them
        manager.process_events(event)

    #need this to actually see the button
    manager.update(time_delta)

    window_surface.blit(background, (0, 0))
    manager.draw_ui(window_surface)

    pygame.display.update()