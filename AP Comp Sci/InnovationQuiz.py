'''
Created on Sep 9, 2020

@author: Timothy
'''
import pygame
import pygame_gui
from pygame import event

pygame.init()
quizboard = pygame.display.set_mode((1000, 800))
background = pygame.Surface((1000, 1000))
background.fill((0, 51, 51))
manager = pygame_gui.UIManager((1000, 1000))
pygame.display.set_caption("[Oculus Quest Quiz]")

def main():
    clock = pygame.time.Clock()
    is_running = True
    
    ##Main menu GUI
    start = False
    end = False
    title_label = pygame_gui.elements.UILabel(pygame.Rect((375, 75), (250, 100)), "Oculus Quest Quiz", manager = manager)
    welcome_label = pygame_gui.elements.UITextBox("Welcome to a quiz about the Oculus Quest innovation! Click the play button below to start the quiz or click the instructions button to learn how to play.", pygame.Rect((300, 250), (400, 150)), manager = manager)
    start_button = pygame_gui.elements.UIButton(pygame.Rect((250, 450), (200, 100)), "Play", manager = manager)
    instructions_button = pygame_gui.elements.UIButton(pygame.Rect((550, 450), (200, 100)), "Instructions", manager = manager)
    
    ##Quiz GUI and variables
    answerscorrect = 0
    question = "1. Which technology does the Oculus Quest use to track and sense its location and the objects around it?"
    answer1 = "Oculus Tracker"
    answer2 = "Oculus Insight"
    answer3 = "Oculus Virtual"
    answer4 = "Oculus Sense"
    answer = "None"
    correctanswer = "B"
    selectedanswer = "Selected answer: " + answer
    questionnumber = 1
    questionscorrect = [None, None, None, None, None]
    wronglist = []
    questionswrong = ""
    question_label = pygame_gui.elements.UITextBox(question, pygame.Rect((300, 250), (400, 125)), manager = manager)
    selectedanswer_label = pygame_gui.elements.UITextBox(selectedanswer, pygame.Rect((400, 600), (200, 50)), manager = manager)
    answer1_button = pygame_gui.elements.UIButton(pygame.Rect((25, 450), (200, 100)), "A: " + answer1, manager = manager)
    answer2_button = pygame_gui.elements.UIButton(pygame.Rect((275, 450), (200, 100)), "B: " + answer2, manager = manager)
    answer3_button = pygame_gui.elements.UIButton(pygame.Rect((525, 450), (200, 100)), "C: " + answer3, manager = manager)
    answer4_button = pygame_gui.elements.UIButton(pygame.Rect((775, 450), (200, 100)), "D: " + answer4, manager = manager)
    submit_button = pygame_gui.elements.UIButton(pygame.Rect((400, 700), (200, 100)), "Submit", manager = manager)
    
    checkanswers_button = ""
    checkanswerstext = ""
    
    question_label.hide()
    selectedanswer_label.hide()
    answer1_button.hide()
    answer2_button.hide()
    answer3_button.hide()
    answer4_button.hide()
    submit_button.hide()
    
    manager.draw_ui(quizboard)
    while is_running:
        time_delta = clock.tick(60)/1000.0
        
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                is_running = False
        
            if event.type == pygame.USEREVENT:
                if event.user_type == pygame_gui.UI_BUTTON_PRESSED:
                    if event.ui_element == instructions_button:
                        instructions_text = pygame_gui.windows.UIMessageWindow(rect = pygame.Rect((550, 450), (250, 200)), html_message = "The quiz consists of 5 questions worth 20 points each (total 100). They are all multiple choice questions relating to the Oculus Quest. After clicking an answer button, press the submit button to finalize your answer and move on to the next question. Press the Play button to start.", manager = manager, window_title = "Instructions")
                    
                    if event.ui_element == start_button:
                        start = True
                        instructions_button.hide()
                        start_button.hide()
                        welcome_label.hide()
                        selectedanswer_label.show()
                        quiz(question_label, selectedanswer_label, answer1_button, answer2_button, answer3_button, answer4_button, submit_button)
                    
                    if event.ui_element == answer1_button:
                        answer = "A"
                        selectedanswer_label.kill()
                        selectedanswer_label = pygame_gui.elements.UITextBox("Selected answer: " + answer, pygame.Rect((400, 600), (200, 50)), manager = manager)
                    if event.ui_element == answer2_button:
                        answer = "B"
                        selectedanswer_label.kill()
                        selectedanswer_label = pygame_gui.elements.UITextBox("Selected answer: " + answer, pygame.Rect((400, 600), (200, 50)), manager = manager)
                    if event.ui_element == answer3_button:
                        answer = "C"
                        selectedanswer_label.kill()
                        selectedanswer_label = pygame_gui.elements.UITextBox("Selected answer: " + answer, pygame.Rect((400, 600), (200, 50)), manager = manager)
                    if event.ui_element == answer4_button:
                        answer = "D"
                        selectedanswer_label.kill()
                        selectedanswer_label = pygame_gui.elements.UITextBox("Selected answer: " + answer, pygame.Rect((400, 600), (200, 50)), manager = manager)
                    
                    if event.ui_element == submit_button:
                        if answer == "None":
                            noanswer_popup = pygame_gui.windows.UIMessageWindow(rect = pygame.Rect((550, 450), (250, 200)), html_message = "You must first choose an answer choice before submitting your answer. Try again.", manager = manager, window_title = "Instructions")
                            continue
                        if answer == correctanswer:
                            answerscorrect += 1
                            questionnumber += 1
                            answer = "None"
                            selectedanswer_label.kill()
                            selectedanswer_label = pygame_gui.elements.UITextBox("Selected answer: " + answer, pygame.Rect((400, 600), (200, 50)), manager = manager)
                        else:
                            
                            answer = "None"
                            if questionnumber == 1:
                                questionscorrect[0] = False
                            if questionnumber == 2:
                                questionscorrect[1] = False
                            if questionnumber == 3:
                                questionscorrect[2] = False
                            if questionnumber == 4:
                                questionscorrect[3] = False
                            if questionnumber == 5:
                                questionscorrect[4] = False
                            questionnumber += 1
                            selectedanswer_label.kill()
                            selectedanswer_label = pygame_gui.elements.UITextBox("Selected answer: " + answer, pygame.Rect((400, 600), (200, 50)), manager = manager)
                        answer1_button.kill()
                        answer2_button.kill()
                        answer3_button.kill()
                        answer4_button.kill()
                        if questionnumber == 2:
                            question = "2. Why was the Oculus Quest made (What was its intended purpose)?"
                            correctanswer = "C"
                            question_label = pygame_gui.elements.UITextBox(question, pygame.Rect((300, 250), (400, 125)), manager = manager)
                            answer1 = "Create businesses"
                            answer2 = "Collect user data"
                            answer3 = "Wider access to VR"
                            answer4 = "Computer accessory"
                        if questionnumber == 3:
                            question = "3. In order, what were the other Oculus VR systems before the Oculus Quest?"
                            correctanswer = "D"
                            question_label = pygame_gui.elements.UITextBox(question, pygame.Rect((300, 250), (400, 125)), manager = manager)
                            answer1 = "Go, Rift, Rift S"
                            answer2 = "Go, Search"
                            answer3 = "Rift, Depth, Rift S"
                            answer4 = "Rift, Go"
                        if questionnumber == 4:
                            question = "4. Which program is educational and useful for art students?"
                            correctanswer = "A"
                            question_label = pygame_gui.elements.UITextBox(question, pygame.Rect((300, 250), (400, 125)), manager = manager)
                            answer1 = "Tilt Brush"
                            answer2 = "PaintX"
                            answer3 = "3D Painter"
                            answer4 = "The Complete Sketch"
                        if questionnumber == 5:
                            question = "5. What is a harmful effect of the Oculus Quest?"
                            correctanswer = "C"
                            question_label = pygame_gui.elements.UITextBox(question, pygame.Rect((300, 250), (400, 125)), manager = manager)
                            answer1 = "Losing money"
                            answer2 = "Losing balance"
                            answer3 = "Addiction to VR"
                            answer4 = "No harmful effects"
                        answer1_button = pygame_gui.elements.UIButton(pygame.Rect((25, 450), (200, 100)), "A: " + answer1, manager = manager)
                        answer2_button = pygame_gui.elements.UIButton(pygame.Rect((275, 450), (200, 100)), "B: " + answer2, manager = manager)
                        answer3_button = pygame_gui.elements.UIButton(pygame.Rect((525, 450), (200, 100)), "C: " + answer3, manager = manager)
                        answer4_button = pygame_gui.elements.UIButton(pygame.Rect((775, 450), (200, 100)), "D: " + answer4, manager = manager)
                        
                        if questionnumber >= 6:
                            end = True
                            question_label.hide()
                            answer1_button.hide()
                            answer2_button.hide()
                            answer3_button.hide()
                            answer4_button.hide()
                            submit_button.hide()
                            selectedanswer_label.kill()
                            percent = str(answerscorrect * 20)
                            for idx, answers in enumerate(questionscorrect):
                                if answers == False:
                                    wronglist += str(idx + 1)
                            if len(wronglist) > 1:
                                i = 1
                                for x in wronglist:
                                    if i == len(wronglist):
                                        questionswrong += str(x)
                                    else:
                                        questionswrong += str(x) + ", "
                                    i += 1
                                    
                                    
                            if len(wronglist) == 1:
                                questionswrong += wronglist[0]
                            endtext = 'Congrats! You finished the Oculus Quest Innovation Quiz. You scored: ' + percent + '%! If you want to see what you missed, click the button below. To find answers to the quiz and find more information on the Oculus Quest, visit <a href="educationandvr.weebly.com">educationandvr.weebly.com</a>'
                            endscreen_label = pygame_gui.elements.UITextBox(endtext, pygame.Rect((300, 200), (400, 200)), manager = manager)
                            checkanswers_button = pygame_gui.elements.UIButton(pygame.Rect((400, 450), (200, 100)), "Check your answers", manager = manager)
                            if wronglist == []:
                                checkanswerstext = "All of your answers were correct! Congratulations. You can find more information on the Oculus Quest on my website."
                            else:
                                checkanswerstext = "Here are the questions you got wrong: " + questionswrong + ". You can find the correct answers on my website as well as additional information. Come again and see if you can get a higher score!"
                        
                    if event.ui_element == checkanswers_button:
                        checkanswers_popup = pygame_gui.windows.UIMessageWindow(rect = pygame.Rect((550, 450), (400, 300)), html_message = checkanswerstext, manager = manager, window_title = "See What You Missed")
                if event.user_type == pygame_gui.UI_TEXT_BOX_LINK_CLICKED:
                        print("clicked the link")
            manager.process_events(event)
        
            
        manager.update(time_delta)
        quizboard.blit(background, (0,0))
        manager.draw_ui(quizboard)
        pygame.display.update()
        
def quiz(question_label, selectedanswer_label, answer1_button, answer2_button, answer3_button, answer4_button, submit_button):
    question_label.show()
    answer1_button.show()
    answer2_button.show()
    answer3_button.show()
    answer4_button.show()
    submit_button.show()
    
    
main()